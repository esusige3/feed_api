package com.esusige.feed_api.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "image")
@NoArgsConstructor
@RequiredArgsConstructor
@Getter

public class Image {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;


    @Column
    @NonNull
    private String url;

    @Column(name = "feed_id")
    private Long feedId;


}
