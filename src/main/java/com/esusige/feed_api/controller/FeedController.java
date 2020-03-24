package com.esusige.feed_api.controller;

import com.esusige.feed_api.dto.FeedDetail;
import com.esusige.feed_api.service.interfaces.IFeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feed")
public class FeedController {

    @Autowired
    private IFeedService feedService;

    /*@GetMapping("")
    public List<FeedDetail> FeedList(Model model,@RequestParam(value = "pageNo", defaultValue = "0") int pageNo,@RequestParam(value = "pageSize",defaultValue = "0")int pageSize){

        return this.feedService.ListFeeds(pageNo,pageSize);
    }*/


    @GetMapping("")
    public Page<FeedDetail> GetPagableFeedList(@RequestParam(value = "pageNo", defaultValue = "0") int pageNo,@RequestParam(value = "pageSize",defaultValue = "0")int pageSize){
        return this.feedService.ListFeeds(pageNo,pageSize);
    }

    @GetMapping("/{feedId}")
    public FeedDetail FeedDetail(@PathVariable Long feedId,@RequestParam("userId") Long userId){
        return this.feedService.GetDetail(feedId,userId);
    }


    @GetMapping("/test")
    public void test(){
        this.feedService.GetTest();
    }


}
