package com.esusige.feed_api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@Data
@NoArgsConstructor
@Getter
public class FeedComment {

    private Long id;
    private Long userId;
    private String mdTitle;
    private String text;
    private LocalDateTime updated;
    private int commentCount;

    public FeedComment(Long id, Long userId, String text, LocalDateTime updated) {
        this.id = id;
        this.userId = userId;
        this.text = text;
        this.updated = updated;
    }

}
