package com.dounine.blockchain.core.impl;

import com.dounine.blockchain.core.BlockInfo;
import com.dounine.blockchain.core.Element;
import com.dounine.blockchain.core.Storage;
import com.dounine.blockchain.exception.BlockException;

import java.util.List;

/**
 * Created by lake on 17-4-21.
 */
public class DbStorage implements Storage {

    @Override
    public List<BlockInfo> list() {
        return null;
    }

    @Override
    public void saveBlock(BlockInfo blockInfo) throws BlockException {

    }

    @Override
    public void pushElement(String blockId, Element element) {

    }
}
