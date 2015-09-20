package top.ningg.spring.threadlocal;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by guoning on 15/9/20.
 */
public class TopicDAOSafe {

    // 1. 使用ThreadLocal保存 Connection对象
    private static ThreadLocal<Connection> connThreadLocal = new ThreadLocal<Connection>();


    public static Connection getConnection() {
        // 2. 如果 ThreadLocal中没有当前线程的Connection对象,则创建一个
        if (connThreadLocal.get() == null) {
//            Connection conn = ConnectionManager.getConnection();
//            connThreadLocal.set(conn);
        }
        return connThreadLocal.get();
    }

    public void addTopic() throws SQLException {
        // 3. 获取当前Thread对应的线程安全变量
        Statement statement = getConnection().createStatement();
    }

}
