package com.esusige.feed_api.repository;

import com.esusige.feed_api.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FeedCommentRepository extends JpaRepository<Comment,Long> {
    List<Comment> findByFeedId(Long feedId);
    int countByFeedId(Long feedId);

    @Modifying
    @Query(value = "UPDATE Comment c SET c.text=:text WHERE c.id=:id")
    boolean modify(@Param("text") String text, @Param("id") Long id);

}
