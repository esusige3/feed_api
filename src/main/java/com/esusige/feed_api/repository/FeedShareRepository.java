package com.esusige.feed_api.repository;

import com.esusige.feed_api.domain.Share;
import com.esusige.feed_api.dto.FeedShared;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface FeedShareRepository extends JpaRepository<Share, Long> {
    int countByFeedId(Long feedId);
    @Transactional
    @Modifying
    @Query(value = "update Feed f set f.sharedCount=:count where f.id=:id")
    int SetSharedCount(@Param("count") int count, @Param("id") Long feedId);
}
