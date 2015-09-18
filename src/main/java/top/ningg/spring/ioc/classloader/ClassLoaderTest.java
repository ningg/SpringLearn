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
    }
}
