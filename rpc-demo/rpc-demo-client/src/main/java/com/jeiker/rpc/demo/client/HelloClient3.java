package com.jeiker.rpc.demo.client;

import com.jeiker.rpc.client.RpcProxy;
import com.jeiker.rpc.demo.api.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试调用时间
 */
public class HelloClient3 {

    private static final Logger logger = LoggerFactory.getLogger(HelloClient3.class);

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        RpcProxy rpcProxy = context.getBean(RpcProxy.class);

        int loopCount = 100;

        long start = System.currentTimeMillis();

        HelloService helloService = rpcProxy.create(HelloService.class);
        for (int i = 0; i < loopCount; i++) {
            String result = helloService.hello("World");
            logger.info(result);
        }

        long time = System.currentTimeMillis() - start;
        logger.info("loop: " + loopCount);
        logger.info("time: " + time + "ms");
        logger.info("tps: " + (double) loopCount / ((double) time / 1000));

        System.exit(0);
    }
}
