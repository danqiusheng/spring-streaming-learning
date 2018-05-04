package com.moa.rabbit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * Created by Administrator on 2018/5/3.
 */
@EnableBinding(Sink.class)
public class SinkReceiver {

    protected Logger logger = LoggerFactory.getLogger(getClass());


    @StreamListener(Sink.INPUT)
    public void receive(Object payload) {
        logger.info("Received:" + payload);
    }


}
