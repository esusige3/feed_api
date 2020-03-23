package com.esusige.feed_api.repository;

import com.esusige.feed_api.domain.Feed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedRepository extends JpaRepository<Feed,Long> {
}
