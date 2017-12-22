package com.example.javier.healthera.model.logout;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Javier on 22/12/2017.
 */

public class Datum {

    @SerializedName("token_id")
    @Expose
    private String tokenId;

    public Datum(String tokenId) {
        this.tokenId = tokenId;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }
}
