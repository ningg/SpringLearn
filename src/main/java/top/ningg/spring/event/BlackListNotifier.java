package top.ningg.spring.event;

import com.alibaba.fastjson.JSON;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Created by guoning on 2017/10/12.
 */
@Component
public class BlackListNotifier {

    private String notificationAddress;

    public void setNotificationAddress(String notificationAddress) {
        this.notificationAddress = notificationAddress;
    }

    @EventListener
    public void receiveBlackListEvent(BlackListEvent event) {
        // notify appropriate parties via notificationAddress...
        System.out.println(String.format("[subscribe event]: publish event:(%s)", JSON.toJSON(event)));
    }
}
