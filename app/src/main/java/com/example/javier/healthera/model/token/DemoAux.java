package com.example.javier.healthera.model.token;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Javier on 21/12/2017.
 */

public class DemoAux {

    @SerializedName("tokenPayload")
    @Expose
    private TokenPayload tokenPayload;

    public TokenPayload getTokenPayload() {
        return tokenPayload;
    }

    public void setTokenPayload(TokenPayload tokenPayload) {
        this.tokenPayload = tokenPayload;
    }

}
