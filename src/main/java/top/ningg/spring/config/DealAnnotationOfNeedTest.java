package top.ningg.spring.config;

import java.lang.reflect.Method;

/**
 * Created by guoning on 15/9/20.
 */
public class DealAnnotationOfNeedTest {
    public static void main(String[] args) {
        // 1. 获取ForumService的Class对象
        Class clazz = ForumService.class;
        // Class clazz = new ForumService().getClass();
        // clazz = Class.forName("top.ningg.spring.config.ForumService");
        // ClassLoader classLoader =
        // Thread.currentThread().getContextClassLoader();
        // clazz =
        // classLoader.loadClass("top.ningg.spring.config.ForumService");

        // 2. 获取所有方法
        Method[] methods = clazz.getDeclaredMethods();

        // 3. 获取方法上的指定注解
        for (Method method : methods) {
            NeedTest needTest = method.getAnnotation(NeedTest.class);
            if (null != needTest) {
                if (needTest.value()) {
                    System.out.println(String.format("方法:%s, 需要测试", method.getName()));
                } else {
                    System.out.println(String.format("方法:%s, 不需要测试", method.getName()));
                }
            }
        }

    }
}
