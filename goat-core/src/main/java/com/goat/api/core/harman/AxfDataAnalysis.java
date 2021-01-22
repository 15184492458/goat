package com.goat.api.core.harman;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AxfDataAnalysis {

    private static DocumentBuilderFactory dbFactory;

    private static DocumentBuilder db;

    private static Pattern pattern = Pattern.compile("[a-zA-z]|[0-9]");

    private static Set set = new HashSet();

    private static Predicate<String> predicate = str -> str.contains("·") || str.contains("、") || str.contains("-")
            || str.contains("．") || str.contains("＋") || str.contains("の") || str.contains("／")
            || str.contains("！") || str.contains("，") || str.contains("—") || str.contains("ひ")
            || str.contains("み") || str.contains("？") || str.contains("＇") || str.contains("い")
            || str.contains("り") || str.contains("ん") || str.contains("と") || str.contains("〉")
            || str.contains("；") || str.contains("ま") || str.contains("わ") || str.contains("ら")
            || str.contains("め") || str.contains("々") || str.contains("｀") || str.contains("＝")
            || str.contains("バ") || str.contains("ー") || str.contains("か") || str.contains("き")
            || str.contains("る") || str.contains("さ") || str.contains("く") || str.contains("∶")
            || str.contains("ツ") || str.contains("ス") || str.contains("タ") || str.contains("ミ")
            || str.contains("ナ") || str.contains("た") || str.contains("ち") || str.contains("ば")
            || str.contains("う") || str.contains("ど") || str.contains("ネ") || str.contains("イ")
            || str.contains("ル") || str.contains("に") || str.contains("つ") || str.contains("し")
            || str.contains("ゃ") || str.contains("ざ") || str.contains("や") || str.contains("て");

    static {
        try {
            dbFactory = DocumentBuilderFactory.newInstance();
            db = dbFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    private static Document document = null;

    public static void main(String[] args) {
        try {
            xmlFileResolver(args[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void xmlFileResolver(String filePath) throws Exception {
//        String filePath = args[0];
//        String filePath = "C:\\Users\\PengWang2\\Desktop\\admin";
        List<File> files = getXmlFiles(filePath);//获取目录下所有的xml文件
        List<Future<Integer>> futures = new ArrayList<>();//处理成功结果集
        int count = threadPoolHandleFiles(files, futures);//线程池批量处理files，各个线程返回处理总数
        int suc = futures.stream().mapToInt(p -> {
            try {
                return p.get();
            } catch (Exception e) {
                return 0;
            }
        }).sum();//求处理标签总数
        printResult(suc,count);//打印结果
    }

    public static int threadPoolHandleFiles(List<File> files, List<Future<Integer>> futures){
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(5);
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                20, 30, 30, TimeUnit.SECONDS,
                workQueue, new ThreadPoolExecutor.AbortPolicy());//多线程处理
        int count = files.stream().mapToInt( file -> {
            String tagName = file.getName().contains("POI") ? "POI" : "STREET";
            NodeList finalElement = null;
            int nodeSize = 0;
            try {
                finalElement = db.parse(file.getPath()).getElementsByTagName(tagName);
                nodeSize += finalElement.getLength();
            } catch (Exception e) {
                e.printStackTrace();
            }
            NodeList finalElement1 = finalElement;
            futures.add(
                    pool.submit(() -> { return handleFile(finalElement1,tagName, file);})
            );
            return nodeSize;
        }).sum();
        pool.shutdown();//关闭线程池
        return count;
    }

    public static void printResult(int suc, int count){
        System.out.println("检查成功数据量 = " + suc);
        System.out.println("检查总数量 = " + count);
        DecimalFormat df=new DecimalFormat("0.00");//设置保留位数
        String x = df.format((double)suc/count);
        System.out.println("检查率 = " + x);
    }

    public static int handleFile(NodeList element,String tagName,File file){
        int success = 0;
        for (int i = 0;i < element.getLength();++i){
            Node node = element.item(i);
            String name = node.getAttributes().getNamedItem("NAME").getTextContent();
            boolean matcher = pattern.matcher(name).find();//name 包含数字字母的跳过
            if (predicate.test(name) || matcher) continue;//如果名字包含"·"  "、" "-" "．" "＋" "の" 符号直接跳过不检查

            int pinYinSpace = 0;
            int nameSpace = countSpace(name.replaceAll("\u00AD"," "));
            NodeList childNodes = node.getChildNodes();//获取<STREET>标签的子标签
            for (int j = 1;j < childNodes.getLength();++j){
                if (childNodes.item(j).getNodeName() == "ALT_NAME"){//获取子标签中的<ALT_NAME>标签
                    NamedNodeMap map = childNodes.item(j).getAttributes();
                    String lan = map.getNamedItem("LAN").getTextContent();
                    if ("zh_CN_PHONETIC".equals(lan) ){//判断标签是拼音标签
                        String pinyin = map.getNamedItem("STRING").getTextContent();//获取拼音内容
                        Predicate<String> pre = str -> pinyin.contains("\u00AD") || pinyin.contains("-");
                        if (pre.negate().test(pinyin)) {//如果拼音包含符号"&#xad;"说明是充电站
                            pinYinSpace = countSpace(pinyin);
                            if (pinYinSpace == nameSpace) {
                                ++success;
                                break;//如果相等说明校验成功
                            }
                        }
                    }
                }
            }
            if (pinYinSpace != nameSpace && pinYinSpace != 0){ //如果拼音空格和汉字空格不相等则打印对应的文件名称和ID值
                String id = tagName == "POI" ? "POI_ID" : "ID";
                System.out.println("file name = " + file.getName() + ","
                        + id + " = " + node.getAttributes().getNamedItem(id).getTextContent());
            }
        }
        return success;
    }

    public static int countSpace(String str){
        int countSpace = 0;
        for (char c : str.toCharArray()){
            if (c == ' ') ++countSpace;
        }
        return countSpace;
    }

    public static List<File> getXmlFiles(String path) {
        File[] files = new File(path).listFiles();
        return Arrays.stream(files).filter(f -> f.isFile()).collect(Collectors.toList());
    }
}
