package com.example.javier.healthera.model.token;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Javier on 21/12/2017.
 */

public class TokenPayload {

    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("url")
    @Expose
    private Object url;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Object getUrl() {
        return url;
    }

    public void setUrl(Object url) {
        this.url = url;
    }

}
