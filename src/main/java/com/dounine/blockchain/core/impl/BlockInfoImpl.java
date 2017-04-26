package com.dounine.blockchain.core.impl;

import com.dounine.blockchain.core.BlockInfo;

import java.time.LocalDateTime;

/**
 * Created by lake on 17-4-21.
 */
public class BlockInfoImpl implements BlockInfo {

    private LocalDateTime createTime;
    private String author;
    private String hash;

    @Override
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}
