package com.example.javier.healthera.model.logout;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Javier on 22/12/2017.
 */

public class Logout {

    @SerializedName("data")
    @Expose
    private Data data;

    public Logout(Data data) {
        this.data = data;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
