package com.esusige.feed_api.repository;

import com.esusige.feed_api.domain.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image,Long> {
}
