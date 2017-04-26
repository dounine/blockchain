package com.dounine.blockchain.core;

import java.time.LocalDateTime;

/**
 * Created by lake on 17-4-20.
 */
public interface BlockInfo {

    /**
     * 区块创建时间
     * @return
     */
    LocalDateTime getCreateTime();

    /**
     * 区块创建人
     * @return
     */
    String getAuthor();

    /**
     * 区块hash
     * @return
     */
    String getHash();

}
