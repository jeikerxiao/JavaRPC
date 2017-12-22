package com.jeiker.rpc.demo.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author : xiao
 * @date : 17/12/22 下午3:25
 * @description :
 */
public class RpcBootstrap {

    private static final Logger logger = LoggerFactory.getLogger(RpcBootstrap.class);

    public static void main(String[] args) {
        logger.debug("start server");
        new ClassPathXmlApplicationContext("spring.xml");
    }
}
