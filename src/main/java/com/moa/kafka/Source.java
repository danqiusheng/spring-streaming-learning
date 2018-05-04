package com.moa.kafka;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * Created by Administrator on 2018/5/4.
 *
 * @author 丹丘生
 */
public interface Source {
    String OUTPUT = "output";

    @Output("output")
    MessageChannel output();
}