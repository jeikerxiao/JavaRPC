package com.jeiker.rpc.demo.api;

/**
 * @author : xiao
 * @date : 17/12/22 下午3:19
 * @description :
 */
public interface HelloService {

    String hello(String name);

    String hello(Person person);
}
