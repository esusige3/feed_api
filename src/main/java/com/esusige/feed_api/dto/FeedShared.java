package com.esusige.feed_api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data

public class FeedShared {

    Long userId;
    int sharedCount;


}
