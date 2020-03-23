package com.esusige.feed_api.service.interfaces;

import com.esusige.feed_api.dto.FeedShared;

public interface IFeedShareService {
    FeedShared CountShare(Long feedId);
    FeedShared AddShare(Long feedId,Long userId);
}
