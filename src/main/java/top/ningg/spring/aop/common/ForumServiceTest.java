package top.ningg.spring.aop.common;

import top.ningg.spring.aop.IForumService;

/**
 * Created by guoning on 15/9/20.
 */
public class ForumServiceTest {
    public static void main(String[] args) {
        IForumService forumService = new ForumServiceImpl();
        forumService.removeForum(11);
        forumService.removeTopic(12);
    }
}
