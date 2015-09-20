package top.ningg.spring.aop.jdk.proxy;

import top.ningg.spring.aop.IForumService;

/**
 * Created by guoning on 15/9/20.
 */
public class ForumService2Impl implements IForumService {

    @Override
    public void removeTopic(int topicId) {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeForum(int forumId) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
