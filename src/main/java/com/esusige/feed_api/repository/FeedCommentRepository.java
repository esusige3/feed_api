package com.esusige.feed_api.repository;

import com.esusige.feed_api.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedCommentRepository extends JpaRepository<Comment,Long> {
    List<Comment> findByFeedId(Long feedId);
    int countByFeedId(Long feedId);

}
