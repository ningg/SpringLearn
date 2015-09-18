package top.ningg.spring.ioc;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by guoning on 15/9/19.
 */
public class PrivateCarOfReflect {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, NoSuchFieldException,
            InvocationTargetException, ClassNotFoundException {
        PrivateCar privateCar = privateCarOfReflect();
    }

    static PrivateCar privateCarOfReflect() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException,
            InstantiationException, NoSuchFieldException {
        // 1. 获取类加载器
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Class clazz = classLoader.loadClass("top.ningg.spring.ioc.PrivateCar");

        // 2. 反射获取构造方法, 创建对象
        Constructor constructor = clazz.getConstructor((Class[]) null);
        PrivateCar privateCar = (PrivateCar) constructor.newInstance();

        // 3. 反射获取private属性
        Field brand = clazz.getDeclaredField("brand");
        brand.setAccessible(true);
        brand.set(privateCar, "new Brand");

        // 4. 反射获取protected方法
        Method introduce = clazz.getDeclaredMethod("introduce");
        introduce.setAccessible(true);
        introduce.invoke(privateCar);

        return privateCar;
    }
}
