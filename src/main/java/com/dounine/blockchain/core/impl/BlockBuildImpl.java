package com.dounine.blockchain.core.impl;

import com.dounine.blockchain.core.BlockBuild;
import com.dounine.blockchain.core.BlockInfo;
import com.dounine.blockchain.core.Element;
import com.dounine.blockchain.core.Storage;
import com.dounine.blockchain.exception.BlockException;

/**
 * Created by lake on 17-4-21.
 */
public class BlockBuildImpl implements BlockBuild {

    private Storage storage;

    @Override
    public void create(BlockInfo blockInfo) throws BlockException {
        storage.saveBlock(blockInfo);
    }

    @Override
    public void push(String blockId,Element element) throws BlockException {
        storage.pushElement(blockId,element);
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }
}
