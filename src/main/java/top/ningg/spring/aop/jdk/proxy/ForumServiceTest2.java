package top.ningg.spring.aop.jdk.proxy;

import top.ningg.spring.aop.IForumService;

import java.lang.reflect.Proxy;

/**
 * Created by guoning on 15/9/20.
 */
public class ForumServiceTest2 {

    public static void main(String[] args) {
        // 1. 获取业务类
        IForumService forumService = new ForumService2Impl();

        // 2. 将横切逻辑与业务类编织到一起, 生成 InvocationHandler 实例对象
        PerformanceHandler handler = new PerformanceHandler(forumService);

        // 3. 利用 InvocationHandler 实例对象,生成代理对象
        IForumService proxy = (IForumService) Proxy.newProxyInstance(forumService.getClass().getClassLoader(), forumService.getClass().getInterfaces(), handler);

        // 4. 调用代理对象
        proxy.removeForum(11);
        proxy.removeTopic(12);
    }

}
