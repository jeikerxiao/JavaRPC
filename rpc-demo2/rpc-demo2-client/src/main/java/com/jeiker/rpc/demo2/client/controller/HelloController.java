package com.jeiker.rpc.demo2.client.controller;

import com.jeiker.rpc.client.RpcProxy;
import com.jeiker.rpc.demo.api.HelloService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

/**
 * @author : xiao
 * @date : 17/12/25 下午2:02
 * @description :
 */
@RestController
@RequestMapping("/say")
public class HelloController {

    private RpcProxy rpcProxy;

    public HelloController() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        rpcProxy = context.getBean(RpcProxy.class);
    }

    @GetMapping("/hi")
    public Map<String, String> hi() {
        return Collections.singletonMap("message", "hi");
    }

    @GetMapping("/hello")
    public Map<String, String> hello() {
        HelloService helloService = rpcProxy.create(HelloService.class);
        String message = helloService.hello("World");
        return Collections.singletonMap("message", message);
    }

    @GetMapping("/hello2")
    public Map<String, String> hello2() {
        HelloService helloService2 = rpcProxy.create(HelloService.class, "sample.hello2");
        String message = helloService2.hello("世界");
        return Collections.singletonMap("message", message);
    }
}
