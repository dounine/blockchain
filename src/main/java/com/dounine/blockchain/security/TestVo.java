package com.dounine.blockchain.security;

import javax.validation.constraints.NotNull;

/**
 * vo信息
 * Created by lake on 17-4-21.
 */
public class TestVo {

    public interface TestA{}

    /**
     * username
     */
    @NotNull(groups = {TestVo.TestA.class},message = "not empty")
    private String[] username;


    public String[] getUsername() {
        return username;
    }

    public void setUsername(String[] username) {
        this.username = username;
    }
}
