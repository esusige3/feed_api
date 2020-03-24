package com.esusige.feed_api.repository;

import com.esusige.feed_api.domain.Feed;
import com.esusige.feed_api.domain.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


public interface FeedLikeRepository extends JpaRepository<Like,Long> {
    int countByFeedId(Long feedId);
    boolean deleteByFeedIdAndUserId(@Param("feedId")Long feedId,@Param("userId")Long userId);
    Optional<Feed> findByFeedIdAndUserId(@Param("feeedId") Long feedId, @Param("userId")Long userId);

    @Transactional
    @Modifying
    @Query(value = "update Feed f set f.likeCount=:count where f.id=:id")
    int SetLikeCount(@Param("count") int count, @Param("id") Long feedId);
}
