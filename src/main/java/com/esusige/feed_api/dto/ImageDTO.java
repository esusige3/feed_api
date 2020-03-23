package com.esusige.feed_api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;


public class ImageDTO {
    private Long id;
    private String url;

    public ImageDTO(Long id, String url){
        this.id = id;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }
}
