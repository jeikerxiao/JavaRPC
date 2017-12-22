package com.jeiker.rpc.registry;

/**
 * 服务发现接口
 *
 * @author : xiao
 * @date : 17/12/22 上午11:05
 * @description :
 */
public interface ServiceDiscovery {

    /**
     * 根据服务名称查找服务地址
     *
     * @param serviceName 服务名称
     * @return 服务地址
     */
    String discover(String serviceName);
}
