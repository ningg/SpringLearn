package top.ningg.spring.aop.jdk.proxy;

import top.ningg.spring.aop.PerformanceMonitor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by guoning on 15/9/20.
 */

// 1. 实现 InvocationHandler, 通过反射获取对象内部的方法
public class PerformanceHandler implements InvocationHandler {

    private Object target;

    // 2. 目标业务类
    public PerformanceHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 3. 开启性能监控
        PerformanceMonitor.start(target.getClass().getName() + "." + method.getName());
        // 4. 利用反射, 执行业务方法
        Object object = method.invoke(target, args);
        // 5. 结束性能监控
        PerformanceMonitor.end();
        return object;
    }
}
