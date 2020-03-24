package com.esusige.feed_api.controller;

import com.esusige.feed_api.dto.FeedShared;
import com.esusige.feed_api.service.interfaces.IFeedShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/feed/{feedId}/")
public class ShareController {

    @Autowired
    private IFeedShareService feedShareService;

    @PutMapping("/Share")
    public FeedShared Share(@PathVariable Long feedId, @RequestParam("userId") Long userId){
        return feedShareService.AddShare(feedId,userId);
    }



}
