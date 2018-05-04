package com.moa.kafka;


import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * 这里面Processor这个接口既定义输入通道又定义了输出通道。同时我们也可以自己定义通道接口，
 * 参见同包名下的Sink和Source
 * Created by Administrator on 2018/5/4.
 *
 * @author 丹丘生
 */
public interface ShopChannel {

    /**
     * 发消息的通道名称
     */
    String SHOP_OUTPUT = "shop_output";

    /**
     * 消息的订阅通道名称
     */
    String SHOP_INPUT = "shop_input";

    /**
     * 发消息的通道
     *
     * @return
     */
    @Output(SHOP_OUTPUT)
    MessageChannel sendShopMessage();

    /**
     * 收消息的通道
     *
     * @return
     */
    @Input(SHOP_INPUT)
    SubscribableChannel recieveShopMessage();


}