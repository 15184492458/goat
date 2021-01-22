package com.goat.api.designpattern.structuralmodel.adaptermodel;

/**
 * 适配器模式（Adapter Pattern）是作为两个不兼容的接口之间的桥梁。它结合了两个独立接口的功能。
 *
 * 我们有一个 MediaPlayer 接口和一个实现了 MediaPlayer 接口的实体类 AudioPlayer。默认情况下，AudioPlayer 可以播放 mp3 格式的音频文件。
 * 我们还有另一个接口 AdvancedMediaPlayer 和实现了 AdvancedMediaPlayer 接口的实体类。该类可以播放 vlc 和 mp4 格式的文件。
 * 我们想要让 AudioPlayer 播放其他格式的音频文件。为了实现这个功能，我们需要创建一个实现了 MediaPlayer 接口的适配器类 MediaAdapter，
 * 并使用 AdvancedMediaPlayer 对象来播放所需的格式。AudioPlayer 使用适配器类 MediaAdapter 传递所需的音频类型，不需要知道能播放所需格式音频的实际类。
 * AdapterPatternDemo 类使用 AudioPlayer 类来播放各种格式。
 *
 * 在Spring MVC中，DispatcherServlet根据请求信息调用HandlerMapping，解析请求对应的Handler，
 * 解析到对应的Handler（也就是我们常说的Controller控制器）后，开始由HandlerAdapter适配器处理。
 * 为什么要在Spring MVC中使用适配器模式？Spring MVC中的Controller种类众多不同类型的Controller
 * 通过不同的方法来对请求进行处理，有利于代码的维护拓展。
 *
 * 优点：
 *      1、可以让任何两个没有关联的类一起运行。
 *      2、提高了类的复用。
 *      3、增加了类的透明度。
 *      4、灵活性好。
 *
 * 缺点：
 *      1、过多地使用适配器，会让系统非常零乱，不易整体进行把握。比如，明明看到调用的是 A 接口，其实内部被适配成了 B 接口的实现，
 *         一个系统如果太多出现这种情况，无异于一场灾难。因此如果不是很有必要，可以不使用适配器，而是直接对系统进行重构。
 *
 *      2、由于 JAVA 至多继承一个类，所以至多只能适配一个适配者类，而且目标类必须是抽象类。
 *
 * 使用场景：有动机地修改一个正常运行的系统的接口，这时应该考虑使用适配器模式。
 */
public class TestClass {

    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("mp3", "beyond the horizon.mp3");
        audioPlayer.play("mp4", "alone.mp4");
        audioPlayer.play("vlc", "far far away.vlc");
        audioPlayer.play("avi", "mind me.avi");
    }
}
