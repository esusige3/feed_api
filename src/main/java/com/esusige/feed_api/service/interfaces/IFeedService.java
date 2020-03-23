package com.esusige.feed_api.service.interfaces;


import com.esusige.feed_api.dto.FeedDetail;

import java.util.List;

public interface IFeedService {
    List<FeedDetail> ListAllFeeds();
    FeedDetail GetDetail(Long feedId, Long userId);
    boolean PostFeed(FeedDetail dto_feed);
    void GetTest();
}
