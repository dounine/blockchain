package com.dounine.blockchain.result;

/**
 * Created by lake on 17-4-19.
 */
public interface Result {

    /**
     * 响应码
     */
    int getCode();

    /**
     * 数据
     */
    Object getData();

    /**
     * 错
     */
    String getMsg();

}
