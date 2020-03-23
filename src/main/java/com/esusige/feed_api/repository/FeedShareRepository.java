package com.esusige.feed_api.repository;

import com.esusige.feed_api.domain.Share;
import com.esusige.feed_api.dto.FeedShared;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedShareRepository extends JpaRepository<Share, Long> {
    int countByFeedId(Long feedId);
}
