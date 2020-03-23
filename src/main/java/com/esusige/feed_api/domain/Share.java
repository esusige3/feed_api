package com.esusige.feed_api.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Getter
public class Share {

    @Id
    Long id;

    @Column
    @NonNull
    Long feedId;

    @Column
    @NonNull
    Long userId;



}
