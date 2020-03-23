package com.esusige.feed_api.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;


@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RequiredArgsConstructor
@Getter

@Table(name = "comment")
public class Comment {

    //고유값
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //참조하는 피드 아이디값
    @Column(nullable = false)
    @NonNull
    private Long feedId;

    //작성자ID
    @Column(nullable = false)
    @NonNull
    private Long userId;

    @Column(columnDefinition = "TEXT",nullable = false)
    @NonNull
    private String text;

    @ManyToOne(targetEntity = Feed.class)
    @JoinColumn(name = "feeds_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Feed feed;

    @Column(nullable = false)
    @ColumnDefault("0")
    private int depth;

    @Column
    private Long parentId;

    @CreationTimestamp
    @Column(updatable = false,nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime created;

    @UpdateTimestamp
    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private  LocalDateTime modified;


    public void MakeMultiDepth(int depth,Long parentId){
        this.depth = depth;
        this.parentId = parentId;
    }

}
