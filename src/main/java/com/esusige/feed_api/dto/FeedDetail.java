package com.esusige.feed_api.dto;



import com.esusige.feed_api.domain.Image;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeedDetail {

    private Long id;
    private String MDtitle;
    private String MDImage;

    private List<Image> images;
    private String text;

    private Boolean liked;

    private int commentCount;
    private int sharedCount;
    private int likeCount;

    private LocalDateTime updated;
    private LocalDateTime created;






}
