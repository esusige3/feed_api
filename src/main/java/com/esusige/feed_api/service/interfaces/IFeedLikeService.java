package com.esusige.feed_api.service.interfaces;

import com.esusige.feed_api.domain.Like;
import com.esusige.feed_api.dto.FeedLike;

public interface IFeedLikeService {
    boolean Like(Long feedId, Long userId);
    boolean Dislike(Long feedId, Long userId);
    boolean CheckOwnLike(Long feedId, Long userId);
    FeedLike CountLike(Long feedId);
}
