package com.jeiker.rpc.demo.client;

import com.jeiker.rpc.client.RpcProxy;
import com.jeiker.rpc.demo.api.HelloService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author : xiao
 * @date : 17/12/22 下午3:31
 * @description :
 */
public class HelloClient {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        RpcProxy rpcProxy = context.getBean(RpcProxy.class);

        HelloService helloService = rpcProxy.create(HelloService.class);
        String result = helloService.hello("World");
        System.out.println(result);

        HelloService helloService2 = rpcProxy.create(HelloService.class, "sample.hello2");
        String result2 = helloService2.hello("世界");
        System.out.println(result2);

        System.exit(0);
    }
}
