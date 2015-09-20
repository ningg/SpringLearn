package top.ningg.spring.config;

/**
 * Created by guoning on 15/9/20.
 */
public class ForumService {

    @NeedTest(true)
    public void deleteForum(int forumId){
        System.out.println("Delete Forum: " + forumId);
    }

    @NeedTest(false)
    public void deleteTopic(int topicId){
        System.out.println("Delete Topic: " + topicId);
    }
}
