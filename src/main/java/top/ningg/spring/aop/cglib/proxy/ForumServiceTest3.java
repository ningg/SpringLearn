package top.ningg.spring.aop.cglib.proxy;

import top.ningg.spring.aop.IForumService;
import top.ningg.spring.aop.jdk.proxy.ForumService2Impl;

/**
 * Created by guoning on 15/9/20.
 */
public class ForumServiceTest3 {

    public static void main(String[] args) {
        CglibProxy proxy = new CglibProxy();
        IForumService forumService = (ForumService2Impl) proxy.getProxy(ForumService2Impl.class);

        forumService.removeForum(11);
        forumService.removeTopic(12);
    }
}
