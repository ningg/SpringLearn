package top.ningg.spring.ioc;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by guoning on 15/9/19.
 */
public class CarOfReflect {

    public static void main(String[] args)
            throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // 创建 Car 实例: 传统方式
        // Car carOfOrdinary = new Car();
        Car carOfOrdinaryWithArgs = new Car("New Brand", "Red", 100);

        // 创建 Car 实例: 反射
        Car carOfReflect = initByDefaultConst();
        String result = carOfReflect.introduce();
        System.out.println(result);

    }

    static Car initByDefaultConst()
            throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // 1. 通过类加载器,获取Car的Class对象
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Class clazz = classLoader.loadClass("top.ningg.spring.ioc.Car");

        // 获取Car的Class对象的其他方法:
        // Class clazz = Class.forName("top.ningg.spring.ioc.Car");
        // Class clazz = Car.class;
        // Class clazz = new Car().getClass();

        // 思考: 上述几种获取 Class 对象的方式, 哪种最优?

        // 2. 获取Car的Class中的默认构造方法,创建Car对象
        // 补充: getDeclaredConstructor((Class[])null), 使用 Class[] 是因为底层使用
        // Object[] 来匹配构造方法的输入参数, 如果使用(Class)null, 则抛出异常.
        Constructor constructor = clazz.getDeclaredConstructor((Class[]) null);
        Car car = (Car) constructor.newInstance();

        // 3. 获取Car的Class中的setter方法,设置属性
        Method setBrand = clazz.getMethod("setBrand", String.class);
        setBrand.invoke(car, "new Brand");
        Method setColor = clazz.getMethod("setColor", String.class);
        setColor.invoke(car, "Red");
        Method setMaxSpeed = clazz.getMethod("setMaxSpeed", int.class);
        setMaxSpeed.invoke(car, 1000);

        return car;
    }
}
