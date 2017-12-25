package com.jeiker.rpc.demo2.server.controller;

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

    @GetMapping("/hello")
    public Map<String, String> hello() {
        return Collections.singletonMap("message", "hello");
    }
}
