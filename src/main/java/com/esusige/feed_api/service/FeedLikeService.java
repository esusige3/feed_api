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
    public boolean Like(Long feedId, Long userId) {

        return false;
    }

    @Override
    public boolean Dislike(Long feedId, Long userId) {
        return false;
    }

    @Override
    public boolean CheckOwnLike(Long feedId, Long userId) {
        Like feed = this.likeRepository.findById(feedId).orElse(null);
        if(feed!=null){
            return true;
        }
        return false;
    }

    @Override
    public FeedLike CountLike(Long feedId) {
        FeedLike feedLike = new FeedLike();
        feedLike.setLikeCount(this.likeRepository.countByFeedId(feedId));
        return feedLike;
        //return new FeedLike().setCount(this.likeRepository.countByFeedId(feedId));
    }


}
