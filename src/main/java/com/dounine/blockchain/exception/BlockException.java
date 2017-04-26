package com.dounine.blockchain.exception;

/**
 * Created by lake on 17-4-24.
 */
public class BlockException extends Exception {

    public BlockException(String msg){
        super(msg);
    }

    public BlockException(String msg,Throwable throwable){
        super(msg,throwable);
    }

}
