package com.esusige.feed_api.service;

import com.esusige.feed_api.domain.Share;
import com.esusige.feed_api.dto.FeedShared;
import com.esusige.feed_api.repository.FeedLikeRepository;
import com.esusige.feed_api.repository.FeedShareRepository;
import com.esusige.feed_api.service.interfaces.IFeedShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedShareService implements IFeedShareService {

    @Autowired
    private FeedShareRepository feedShareRepository;

    @Override
    public FeedShared CountShare(Long feedId) {

        FeedShared feedShared = new FeedShared();
        feedShared.setSharedCount(this.feedShareRepository.countByFeedId(feedId));

        return feedShared;
    }

    @Override
    public FeedShared AddShare(Long feedId, Long userId){
            Share share = new Share(feedId,userId);
            feedShareRepository.save(share);
        return CountShare(feedId);
    }
}
