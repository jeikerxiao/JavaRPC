package com.jeiker.rpc.demo.client;

import com.jeiker.rpc.client.RpcProxy;
import com.jeiker.rpc.demo.api.HelloService;
import com.jeiker.rpc.demo.api.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试对象调用
 */
public class HelloClient2 {

    private static final Logger logger = LoggerFactory.getLogger(HelloClient2.class);

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        RpcProxy rpcProxy = context.getBean(RpcProxy.class);

        HelloService helloService = rpcProxy.create(HelloService.class);
        String result = helloService.hello(new Person("jeiker", "xiao"));
        logger.info(result);

        System.exit(0);
    }
}
