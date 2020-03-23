package com.esusige.feed_api.controller;

import com.esusige.feed_api.dto.FeedDetail;
import com.esusige.feed_api.service.interfaces.IFeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/feed")
public class FeedController {

    @Autowired
    private IFeedService feedService;


    @GetMapping("/")
    public List<FeedDetail> ListFeeds(){
        return this.feedService.ListAllFeeds();
    }

    @GetMapping("/test")
    public void test(){
        this.feedService.GetTest();
    }

    @GetMapping("/{feedId}")
    public FeedDetail FeedDetail(@PathVariable Long feedId){
        return this.feedService.ViewDetail(feedId);
    }

}
