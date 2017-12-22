package com.jeiker.rpc.registry;

/**
 * 服务注册接口
 *
 * @author : xiao
 * @date : 17/12/22 上午11:05
 * @description :
 */
public interface ServiceRegistry {

    /**
     * 注册服务名称与服务地址
     *
     * @param serviceName    服务名称
     * @param serviceAddress 服务地址
     */
    void register(String serviceName, String serviceAddress);
}
