package com.esusige.feed_api.dto;

import lombok.Data;

@Data
public class FeedLike {
    private Long feedId;
    private Long userId;

    private int likeCount;



}
