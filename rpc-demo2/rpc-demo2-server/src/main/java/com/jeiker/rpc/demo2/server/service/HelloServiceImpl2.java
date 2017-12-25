package com.jeiker.rpc.demo2.server.service;

import com.jeiker.rpc.demo.api.HelloService;
import com.jeiker.rpc.demo.api.Person;
import com.jeiker.rpc.server.RpcService;

/**
 * @author : xiao
 * @date : 17/12/22 下午3:25
 * @description :
 */
@RpcService(value = HelloService.class, version = "sample.hello2")
public class HelloServiceImpl2 implements HelloService {

    @Override
    public String hello(String name) {
        return "你好! " + name;
    }

    @Override
    public String hello(Person person) {
        return "你好! " + person.getFirstName() + " " + person.getLastName();
    }
}