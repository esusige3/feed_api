package com.esusige.feed_api.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.util.Lazy;

import javax.persistence.*;
import java.lang.reflect.Member;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Table(name = "liked")
public class Like {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(targetEntity = Feed.class)
    @JoinColumn(name = "feeds_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Feed feed;

    @Column(nullable = false)
    @NonNull
    private Long feedId;

    @Column(nullable = false)
    @NonNull
    private Long userId;
}
