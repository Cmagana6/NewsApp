package com.m00061016.gamenews.Objects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginAuth {
    @SerializedName("token")
    @Expose
    private String token;

    public LoginAuth(){
        this.token=null;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
