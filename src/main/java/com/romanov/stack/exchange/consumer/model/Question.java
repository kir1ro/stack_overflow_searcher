package com.romanov.stack.exchange.consumer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Question {
    @JsonProperty("is_answered")
    private boolean isAnswered;
    @JsonProperty("view_count")
    private int viewCount;
    @JsonProperty("creation_date")
    private Date creationDate;
    @JsonProperty("last_activity_date")
    private Date lastActivityDate;
    private List<String> tags;
    private Owner owner;
    private String link;
    private String title;
}
