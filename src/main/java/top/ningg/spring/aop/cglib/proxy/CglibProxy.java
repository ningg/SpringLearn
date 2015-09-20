package top.ningg.spring.aop.cglib.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import top.ningg.spring.aop.PerformanceMonitor;

import java.lang.reflect.Method;

/**
 * Created by guoning on 15/9/20.
 */
public class CglibProxy implements MethodInterceptor{

    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class clazz){
        // 1. 设置业务类,并以此为父类
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        // 2. 利用字节码动态增强技术,创建子类实例
        return enhancer.create();
    }

    // 3. 拦截父类所有方法的调用
    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        PerformanceMonitor.start(object.getClass().getName() + "." + method.getName());
        Object result = methodProxy.invokeSuper(object, args);
        PerformanceMonitor.end();
        return result;
    }
}
