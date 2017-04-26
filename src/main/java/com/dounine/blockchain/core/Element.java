package com.dounine.blockchain.core;

import java.time.LocalDateTime;

/**
 * Created by lake on 17-4-21.
 */
public interface Element {

    String getAuthor();

    String getContent();

    LocalDateTime getCreateTime();
}
