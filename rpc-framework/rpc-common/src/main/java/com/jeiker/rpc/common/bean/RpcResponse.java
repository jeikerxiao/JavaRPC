package com.jeiker.rpc.common.bean;

/**
 * 封装 RPC 响应
 *
 * @author : xiao
 * @date : 17/12/22 上午10:39
 * @description :
 */
public class RpcResponse {

    /**
     * 响应id
     */
    private String requestId;
    /**
     * 响应异常
     */
    private Exception exception;
    /**
     * 响应结果
     */
    private Object result;

    public boolean hasException() {
        return exception != null;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "RpcResponse{" +
                "requestId='" + requestId + '\'' +
                ", exception=" + exception +
                ", result=" + result +
                '}';
    }
}
