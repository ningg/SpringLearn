package top.ningg.spring.aop;

/**
 * Created by guoning on 15/9/20.
 */
public class MethodPerformance {

    private long start;
    private long end;
    private String serviceMethod;

    public MethodPerformance(String serviceMethod){
        this.serviceMethod = serviceMethod;
        // 1. 记录目标方法开始执行的时间
        start = System.currentTimeMillis();
    }

    public void printPerformance(){
        // 2. 记录目标方法执行完成的时间
        end = System.currentTimeMillis();

        // 3. 计算并输出方法的执行时间
        long elapse = end - start;
        System.out.println(serviceMethod + "运行花费时间:" + elapse + "毫秒");

    }


}
