package top.ningg.spring.event;

import org.springframework.context.ApplicationEvent;

/**
 * Created by guoning on 2017/10/12.
 * <a href="https://docs.spring.io/spring-framework/docs/4.3.x/spring-framework-reference/html/beans.html#context-functionality-events">context-functionality-events</a>
 */
public class BlackListEvent extends ApplicationEvent {

    private final String address;
    private final String test;

    public BlackListEvent(Object source, String address, String test) {
        super(source);
        this.address = address;
        this.test = test;
    }

    // accessor and other methods...
}
