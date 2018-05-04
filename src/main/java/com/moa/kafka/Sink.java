package com.moa.kafka;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by Administrator on 2018/5/4.
 * @author  丹丘生
 */
public interface Sink {
    String INPUT = "input";

    @Input("input")
    SubscribableChannel input();
}