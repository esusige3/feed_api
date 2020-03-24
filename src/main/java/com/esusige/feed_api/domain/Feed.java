package com.esusige.feed_api.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
@Getter
@Table(name = "feeds")
public class Feed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "md_image",nullable = false)
    @NonNull
    private String MD_image;

    @Column(name = "md_title")
    @NonNull
    private String MD_title;

    @Column(name = "text",columnDefinition = "TEXT",nullable = false)
    @NonNull
    private String text;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name="feed_id")
    private List<Image> imageList;

    @Column(name = "commentCount")
    @ColumnDefault("0")
    private int commentCount;

    @Column(name = "likeCount")
    @ColumnDefault("0")
    private int likeCount;


    @Column(name = "sharedCount")
    @ColumnDefault("0")
    private int sharedCount;

    //private List<String> tags;

    @CreationTimestamp
    @Column(updatable = false,nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    LocalDateTime created;

    @UpdateTimestamp
    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    LocalDateTime updated;




    public void addImage(Image image){
        if(imageList == null){
            imageList=new ArrayList<Image>();
        }
        imageList.add(image);
    }


}
