package com.esusige.feed_api.service.interfaces;


import com.esusige.feed_api.dto.FeedDetail;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IFeedService {
    Page<FeedDetail> ListFeeds(int pageNo, int pageSize);
    FeedDetail GetDetail(Long feedId, Long userId);
    boolean PostFeed(FeedDetail dto_feed);
    void GetTest();
}
