package com.esusige.feed_api.controller;

import com.esusige.feed_api.dto.FeedLike;
import com.esusige.feed_api.service.interfaces.IFeedLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/feed/{feedId}")
public class LikeController {

    @Autowired
    private IFeedLikeService feedLikeService;

    @PutMapping("/Like")
    public FeedLike Like(@PathVariable Long feedId, @RequestParam Long userId){
        return this.feedLikeService.Like(feedId,userId);
    }

    @DeleteMapping("/Dislike")
    public FeedLike Dislike(@PathVariable Long feedId, @RequestParam Long userId){
        return  this.feedLikeService.Dislike(feedId,userId);
    }

}
