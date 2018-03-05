package com.romanov.stack.exchange.consumer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Owner {
    @JsonProperty("user_id")
    private long userID;
    @JsonProperty("user_type")
    private String userType;
    @JsonProperty("accept_rate")
    private String acceptRate;
    @JsonProperty("profile_image")
    private String profileImage;
    @JsonProperty("display_name")
    private String displayName;
    private String link;
    private int reputation;
}
