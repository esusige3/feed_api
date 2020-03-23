package com.esusige.feed_api.controller;

import com.esusige.feed_api.dto.FeedDetail;
import com.esusige.feed_api.service.interfaces.IFeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

@RequestMapping("feed/")
public class FeedController {

    @Autowired
    private IFeedService feedService;

    @GetMapping("/")
    public String FeedList(Model model,@RequestParam(value = "pageNo", defaultValue = "0") int pageNo,@RequestParam(value = "pageSize",defaultValue = "0")int pageSize){
        List<FeedDetail> feedList = this.feedService.ListAllFeeds();
        model.addAttribute("list",feedList);
        return "Feed";
    }
    @GetMapping("/{feedId}")
    public String FeedDetail(@PathVariable Long feedId,@RequestParam("userId") Long userId, Model model){
        FeedDetail feedDetail = this.feedService.GetDetail(feedId,userId);
        model.addAttribute("feed",feedDetail);
        return "Detail";
    }


  //  @GetMapping("/")
    //public List<FeedDetail> ListFeeds(){
      //  return this.feedService.ListAllFeeds();
    //}

    @GetMapping("/test")
    public void test(){
        this.feedService.GetTest();
    }

   /*  @GetMapping("/{feedId}")
   public FeedDetail FeedDetail(@RequestParam("userId") Long userId, @PathVariable Long feedId){
        return this.feedService.GetDetail(feedId,userId);
    }*/

}
