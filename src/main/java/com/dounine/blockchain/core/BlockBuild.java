package com.dounine.blockchain.core;

import com.dounine.blockchain.exception.BlockException;

/**
 * Created by lake on 17-4-20.
 */
public interface BlockBuild {
    /**
     * 创建区块信息
     * @param blockInfo
     */
    void create(BlockInfo blockInfo) throws BlockException;

    /**
     * 往区块链中增加元素
     * @param element
     */
    void push(String blockId,Element element) throws BlockException;
}
