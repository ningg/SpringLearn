package top.ningg.spring.ioc.classloader;

/**
 * Created by guoning on 15/9/19.
 */
public class ClassLoaderTest {

    public static void main(String[] args) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        System.out.println("Current ClassLoader: " + classLoader);
        System.out.println("Parent ClassLoader: " + classLoader.getParent());
        System.out.println("GrandParent ClassLoader: " + classLoader.getParent().getParent());

        // 强制装载已经存在的 class
        Class carOne = null;
        Class carTwo = null;
        Class string = null;
        try {
            carOne = classLoader.loadClass("top.ningg.spring.ioc.Car");
            carTwo = classLoader.loadClass("top.ningg.spring.ioc.Car");
            System.out.println(carOne.getName() + " classLoader is: " + carOne.getClassLoader());

            // JVM 类加载采取双亲委派模式, 会优先从 parent 类加载器加载类, 其中 parent 类加载器是组合方式接入
            // 可以自定义类加载器, 破坏掉双亲委派模式.
            string = classLoader.loadClass("java.lang.String");
            System.out.println(string.getName() + " classLoader is: " + string.getClassLoader());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
