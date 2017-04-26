package com.dounine.blockchain.core.impl;

import com.dounine.blockchain.core.Element;
import com.dounine.blockchain.exception.BlockException;

import java.time.LocalDateTime;

/**
 * Created by lake on 17-4-21.
 */
public class ElementImpl implements Element {

    private String author;
    private String content;
    private LocalDateTime createTime;

    @Override
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String getContent() {
        return content;
    }

    public void setContent(String content){
        if(content.length()>1024){
            throw new RuntimeException("只能存储1024个字符");
        }
        this.content = content;
    }

    @Override
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}
