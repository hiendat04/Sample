package com.demo.sample.util;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum UserType {
    @JsonProperty("owner")
    OWNER, 
    @JsonProperty("admin")
    ADMIN, 
    @JsonProperty("user")
    USER
}
