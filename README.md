#Spring cloud Stream demo
> 研究这个是打算与Flink进行对比，因为Flink没有代码版本控制，只能通过命令行的方式触发保存点然后更新代码做版本更新.


# demo示例操作（kafka）
- 引入依赖
      在这一步出现问题，kafka服务端用的是0.10.0.0版本，依赖太高服务端会报错 
      错误为：Invalid version for API key 3: 2
      解决方案：更新依赖即可
      
- 修改application.properties
    ````
    spring.cloud.stream.bindings.shop_input.destination=test_spring_stream
    spring.cloud.stream.bindings.shop_output.destination=test_spring_stream
    ````
    上面配置了目的地,配置格式如下：
    ````
    spring.cloud.stream.bindings.<channelName>.<key>=value
    ````
  
- 自定义方法
自定义Sink，类似
````
public interface Sink {
    String INPUT = "input";

    @Input("input")
    SubscribableChannel input();
}
````

自定义Source，类似
````
public interface Source {
    String OUTPUT = "output";

    @Output("output")
    MessageChannel output();
}
````
自定义processor，类似
````
public interface Processor extends Source, Sink {
}
````

- 启动项目 并访问
  
  http://localhost:8080/sendMsg?content=hello
  
  页面会返回'发送成功’字样

- 开发步骤

1. 开启Middleware（Kafka）
2. 创建通道并与Binder绑定（@EnableBinding）
3. 编写操作通道的代码
4. 在配置文件上配置目的地，组，Middleware的地址，端口等等

  
- @EnableBinding注解
 ````
 @EnableBinding(ShopChannel.class)
 @SpringBootApplication
 public class SpringStreamingLearningApplication {
     public static void main(String[] args) {
         SpringApplication.run(SpringStreamingLearningApplication.class, args);
     }
 }
 ````
 
 > @EnableBinding注解接收一个参数，参数类型是class。上面代码中，
 传入的参数是"ShopChannel.class",这是一个接口，定义了两个channel，
 分别是input和output。看名称就知道，一个是输出通道（input channel），
 一个是输出通道（output channel）.
 默认的可以用："@EnableBinding(value = { Processor.class })"
 这整段代表创建Processor定义的通道，并将通道和Binder绑定。
 Porcessor是Spring Cloud Stream为方便使用而预先定义好的，除了Processor还有Sink和Source，这些接口定义了一些通道（channel），需要时，直接使用就好。

- 参考
1. [Spring Cloud 集成 kafka](https://blog.csdn.net/ldy1016/article/details/72852179)
2. [Spring cloud 简明教程](https://my.oschina.net/u/2342449/blog/1589297)