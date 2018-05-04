package com.moa.kafka;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *这里面大家注意 @StreamListener 这个注解可以监听输入通道里的消息内容，这里面要指定我们刚才定义的输入通道名称，而MessageChannel则可以通过
 * 输出通道发送消息，使用@Resource注入时也要指定我们刚才定义的输出通道名称
 * Created by Administrator on 2018/5/4.
 */

@RestController
public class ShopService {

    @Resource(name = ShopChannel.SHOP_OUTPUT)
    private MessageChannel sendShopMessageChannel;

    @GetMapping("/sendMsg")
    public String sendShopMessage(String content) {
        boolean isSendSuccess = sendShopMessageChannel.
                send(MessageBuilder.withPayload(content).build());
        return isSendSuccess ? "发送成功" : "发送失败";
    }

    @StreamListener(ShopChannel.SHOP_INPUT)
    public void receive(Message<String> message) {
        System.out.println("message:"+message.getPayload());
    }
}