package com.jeiker.rpc.registry.zookeeper;

/**
 * zookeeper 配置参数
 *
 * @author : xiao
 * @date : 17/12/22 上午11:10
 * @description :
 */
public interface Constant {

    int ZK_SESSION_TIMEOUT = 5000;
    int ZK_CONNECTION_TIMEOUT = 1000;

    String ZK_REGISTRY_PATH = "/registry";
}
