package top.ningg.spring.aop.common;

import top.ningg.spring.aop.IForumService;
import top.ningg.spring.aop.PerformanceMonitor;

/**
 * Created by guoning on 15/9/20.
 */
public class ForumServiceImpl implements IForumService {

    @Override
    public void removeTopic(int topicId) {
        PerformanceMonitor.start("removeTopic");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        PerformanceMonitor.end();
    }

    @Override
    public void removeForum(int forumId) {
        PerformanceMonitor.start("removeForum");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        PerformanceMonitor.end();
    }
}
