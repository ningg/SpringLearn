package top.ningg.spring.threadlocal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by guoning on 15/9/20.
 */
public class SimpleThreadLocal {

    // 用于存储 thread:object
    private Map valueMap = Collections.synchronizedMap(new HashMap());

    // 1. key 为 Thread, value 为线程本地变量
    public void set(Object newValue){
        valueMap.put(Thread.currentThread(), newValue);
    }

    public Object get(){
        Thread currentThread = Thread.currentThread();
        // 2. 获取当前Thread对应的变量
        Object object = valueMap.get(currentThread);
        // 3. 如果当前Thread对应变量的值不存在,则进行初始化
        if (null == object && !valueMap.containsKey(currentThread)){
            object = initialValue();
            set(object);
        }
        return object;
    }

    public Object initialValue(){
        // 根据具体情况进行实现
        return null;
    }

}
