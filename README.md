# SpringLearn
阅读Spring源码

## 目录

* [SpringLearn 的 wiki](https://github.com/ningg/SpringLearn/wiki)


## 测试 Spring 中扩展 schema 来定义 Bean

添加依赖:

```
<dependency>
    <groupId>top.ningg.learn.spring</groupId>
    <artifactId>spring-learn</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

配置文件中, 添加配置:

```
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:myns="http://www.mycompany.com/schema/myns"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
       http://www.mycompany.com/schema/myns http://www.mycompany.com/schema/myns/myns-1.0.xsd">

    <myns:dateformat />

</beans>
```


