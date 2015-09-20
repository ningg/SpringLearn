package top.ningg.spring.threadlocal;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by guoning on 15/9/20.
 */
public class TopicDAOUnSafe {
    // 1. 非线程安全变量
    private Connection connection;

    public void addTopic() throws SQLException {
        // 2. 引用非线程安全变量
        Statement statement = connection.createStatement();
    }
}
