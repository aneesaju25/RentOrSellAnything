package com.example.rentorsellanything.pojo;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    private Boolean status;
    private String message;
    private Integer UID;

    public Integer getUid() {
        return UID;
    }

    public void setUid(Integer uid) {
        this.UID = uid;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
