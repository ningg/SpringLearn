package top.ningg.spring.aop;

/**
 * Created by guoning on 15/9/20.
 */
public class PerformanceMonitor {

    // 1. ThreadLocal中保存性能监控信息
    private static ThreadLocal<MethodPerformance> threadLocal = new ThreadLocal<>();

    // 2. 启动对目标方法的性能监控
    public static void start(String method){
        MethodPerformance methodPerformance = new MethodPerformance(method);
        threadLocal.set(methodPerformance);
    }

    // 3. 结束性能监控
    public static void end(){
        MethodPerformance methodPerformance = threadLocal.get();
        methodPerformance.printPerformance();
    }

}
