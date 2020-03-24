package com.esusige.feed_api.controller;

import com.esusige.feed_api.dto.FeedComment;
import com.esusige.feed_api.service.interfaces.IFeedCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feed/{feedId}/comment")
public class CommentController {

    @Autowired
    private IFeedCommentService feedCommentService;

    @GetMapping("")
    public List<FeedComment> ListComments(@PathVariable Long feedId){
        return this.feedCommentService.ListComments(feedId);
    }

    @DeleteMapping("/{commentId}")
    public boolean DeleteComment(@PathVariable Long feedId,@PathVariable Long commentId){
        return this.feedCommentService.DeleteComment(commentId,feedId);
    }

    @PutMapping("")
    public int ModifyComment(@PathVariable Long feedId,@RequestBody FeedComment feedComment){
        return this.feedCommentService.ModifyComment(feedComment,feedId);
    }


    @PostMapping("")
    public boolean WriteComment(@RequestBody FeedComment feedComment,@PathVariable Long feedId){

        return this.feedCommentService.WriteComment(feedComment,feedId);
    }
}