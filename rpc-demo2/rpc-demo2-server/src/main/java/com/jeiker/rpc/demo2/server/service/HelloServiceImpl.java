package com.jeiker.rpc.demo2.server.service;

import com.jeiker.rpc.demo.api.HelloService;
import com.jeiker.rpc.demo.api.Person;
import com.jeiker.rpc.server.RpcService;

/**
 * @author : xiao
 * @date : 17/12/22 下午3:25
 * @description :
 */
@RpcService(HelloService.class)
public class HelloServiceImpl implements HelloService {

    @Override
    public String hello(String name) {
        return "Hello! " + name;
    }

    @Override
    public String hello(Person person) {
        return "Hello! " + person.getFirstName() + " " + person.getLastName();
    }
}
