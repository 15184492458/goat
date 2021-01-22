package com.goat.api.designpattern.structuralmodel.proxymodel;

/**
 * 我们将创建一个Image接口和实现了Image接口的实体类。ProxyImage是一个代理类，减少RealImage对象加载的内存占用。
 * TestClass 类使用ProxyImage 来获取要加载的Image对象，并按照需求进行显示。
 *
 * 当被请求时，使用 ProxyImage 来获取 RealImage 类的对象。
 *
 * 在代理模式（Proxy Pattern）中，一个类代表另一个类的功能。这种类型的设计模式属于结构型模式。
 * 在代理模式中，我们创建具有现有对象的对象，以便向外界提供功能接口。
 *
 * Spring框架中的运用：
 *  Spring AOP就是基于动态代理的，如果要代理的对象，实现了某个接口，那么Spring AOP会使用JDK Proxy，去创建代理对象，
 *  而对于没有实现接口的对象，就无法使用JDK Proxy去进行代理了，这时候Spring AOP会使用Cglib，这时候Spring AOP会使用
 *  Cglib生成一个被代理对象的子类来作为代理。
 *
 *  当然你也可以使用AspectJ，Spring AOP已经继承了AspectJ,AspectJ应该算的上是java生态系统中最完整的AOP框架了。
 *
 * Spring AOP和AspectJ AOP有什么区别？
 *
 * Spring AOP属于运行时增强，而AspectJ是编译时增强。Spring AOP基于代理，而AspectJ基于字节码操作。
 *
 * Spring AOP已经集成了AspectJ，AsectJ应该算的上是Java生态系统中最完整的AOP框架了。AspectJ相比于Spring AOP功能更加强大，
 * 但是Spring AOP相对来说更简单，如果我们的切面比较少，那么两者的性能差异不大。但是当切面太多的话，最好选择AspectJ，它比Spring AOP快很多。
 *
 * 优点： 1、职责清晰。 2、高扩展性。 3、智能化。
 *
 * 缺点： 1、由于在客户端和真实主题之间增加了代理对象，因此有些类型的代理模式可能会造成请求的处理速度变慢。
 *        2、实现代理模式需要额外的工作，有些代理模式的实现非常复杂。
 *
 * 使用场景：
 *      按职责来划分，通常有以下使用场景：
 *          1、远程代理。
 *          2、虚拟代理。
 *          3、Copy-on-Write 代理。
 *          4、保护（Protect or Access）代理。
 *          5、Cache代理。
 *          6、防火墙（Firewall）代理。
 *          7、同步化（Synchronization）代理。
 *          8、智能引用（Smart Reference）代理。
 */
public class TestClass {

    public static void main(String[] args) {
        Image image = new ProxyImage("xxx.txt");
        image.display();
    }
}
