## 工程介绍

### common 
主要封装一些通用公共类、工具类，如业务异常父类，对象父类,日志等

### producer 
该模块与数据库交互,进行数据处理,返回对应的结果

### consumer-feign 
通过feign,调用producer下的接口,获取producer服务接口返回的结果.  
可将该层抽离为API层,作为jar包引入应用服务,再而对外提供服务(须知,此时需要将resources下的配置文件迁移到应用服务工程)  

### 技术栈整合

#### nacos
功能点: 服务注册   配置管理
```
 nacos:
      discovery:
        server-addr: ${REGISTER_HOST:172.16.0.6}:${REGISTER_PORT:30000}
      config:
        server-addr: ${REGISTER_HOST:172.16.0.6}:${REGISTER_PORT:30000}
        file-extension: yml

```

#### sentinel
功能点:限流
```
sentinel:
      transport:
        dashboard: ${SENTINEL_DASHBOARD_HOST:192.168.1.77}:${SENTINEL_DASHBOARD_PORT:9020}
      datasource:
        dsl:
          nacos:
            server-addr: ${REGISTER_HOST:172.16.0.6}:${REGISTER_PORT:30000}
            data-id: ${spring.application.name:consumer-feign}
            group-id: DEFAULT_GROUP
            data-type: json
            rule-type: flow

```
#### feign
```$xslt
feign:
  sentinel:
    enabled: true
  okhttp:
    enabled: true

```