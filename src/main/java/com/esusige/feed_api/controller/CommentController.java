package com.esusige.feed_api.controller;

import com.esusige.feed_api.dto.FeedComment;
import com.esusige.feed_api.service.interfaces.IFeedCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feeds/{feedId}/comments")
public class CommentController {

    @Autowired
    private IFeedCommentService feedCommentService;

    @GetMapping("/")
    public List<FeedComment> ListComments(@PathVariable Long feedId){
        return this.feedCommentService.ListComments(feedId);
    }

    @DeleteMapping("/{commentId}")
    public void DeleteComment(@PathVariable Long commentId){
        this.feedCommentService.DeleteComment(commentId);
    }

    //@PostMapping("/{feedId}")
    //public

    @PostMapping("/write")
    public void WriteComment(@RequestBody FeedComment feedComment,@PathVariable Long feedId){

        this.feedCommentService.WriteComment(feedComment,feedId);
    }


}
