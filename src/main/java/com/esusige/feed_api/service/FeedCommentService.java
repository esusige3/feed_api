package com.esusige.feed_api.service;

import com.esusige.feed_api.domain.Feed;
import com.esusige.feed_api.repository.FeedCommentRepository;
import com.esusige.feed_api.dto.FeedComment;
import com.esusige.feed_api.domain.Comment;
import com.esusige.feed_api.service.interfaces.IFeedCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FeedCommentService implements IFeedCommentService {

    @Autowired
    private FeedCommentRepository commentRepository;


    @Override
    public List<FeedComment> ListComments(Long feedId) {
        List<Comment> commentList = this.commentRepository.findByFeedId(feedId);
        List<FeedComment> dto_commentList = new ArrayList<>();
        commentList.forEach(comment -> {
            System.out.println("id: "+comment.getId()+" comment: "+comment.getText());
            dto_commentList.add(new FeedComment(comment.getId(),comment.getUserId(),comment.getText(),comment.getModified()));
        });
        return dto_commentList;
    }

    @Override
    public boolean WriteComment(FeedComment feedComment,Long feedId) {
        try{
           Comment comment = new Comment(feedId,feedComment.getUserId(),feedComment.getText());

            this.commentRepository.save(this.commentRepository.save(comment));
            System.out.println("서비스객체 진입");
            this.commentRepository.SetCommentCount(CountCommentAnInt(feedId),feedId);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean DeleteComment(Long commentId,Long feedId) {
        Optional<Comment> commentList = this.commentRepository.findById(commentId);
        if(commentList.isPresent()){
            this.commentRepository.deleteById(commentId);
            this.commentRepository.SetCommentCount(CountCommentAnInt(feedId),feedId);
            return true;
        }
        return false;
    }

    @Override
    public int ModifyComment(FeedComment dto_comment, Long feedId) {

       return this.commentRepository.modify(dto_comment.getText(),dto_comment.getId(),feedId);
    }

    @Override
    public FeedComment CountComment(Long feedId) {
        FeedComment feedComment = new FeedComment();
        feedComment.setCommentCount(CountCommentAnInt(feedId));
        return feedComment;

    }

    private int CountCommentAnInt(Long feedId){
        return this.commentRepository.countByFeedId(feedId);
    }

}
