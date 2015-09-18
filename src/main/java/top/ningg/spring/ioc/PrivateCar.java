package top.ningg.spring.ioc;

/**
 * Created by guoning on 15/9/19.
 */
public class PrivateCar {

    // private 属性: 传统类实例调用方式,只能在当前类内部使用
    private String brand;

    // protected 方法: 传统类实例调用方式, 只能在子类和当前包内调用
    protected void introduce(){
        System.out.println(String.format("brand:%s", brand));
    }

}
