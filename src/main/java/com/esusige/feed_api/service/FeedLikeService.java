package com.esusige.feed_api.service;

import com.esusige.feed_api.domain.Feed;
import com.esusige.feed_api.domain.Like;
import com.esusige.feed_api.dto.FeedLike;
import com.esusige.feed_api.repository.FeedLikeRepository;
import com.esusige.feed_api.service.interfaces.IFeedLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FeedLikeService implements IFeedLikeService {

    @Autowired
    private FeedLikeRepository likeRepository;

    @Override
    public FeedLike Like(Long feedId, Long userId) {
        Like like = new Like(feedId,userId);
        this.likeRepository.save(like);
        return CountLike(feedId);
    }

    @Override
    public FeedLike Dislike(Long feedId, Long userId) {
        this.likeRepository.deleteByFeedIdAndUserId(feedId,userId);
        return CountLike(feedId);
    }

    @Override
    public boolean CheckOwnLike(Long feedId, Long userId) {
         Optional<Feed> feed = this.likeRepository.findByFeedIdAndUserId(feedId,userId);
        if(feed.isPresent()){
            return true;
        }
        return false;
    }

    @Override
    public FeedLike CountLike(Long feedId) {
        FeedLike feedLike = new FeedLike();
        feedLike.setLikeCount(this.likeRepository.countByFeedId(feedId));
        return feedLike;
    }


}
