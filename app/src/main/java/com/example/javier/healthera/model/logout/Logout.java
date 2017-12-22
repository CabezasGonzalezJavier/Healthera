package com.example.javier.healthera.model.logout;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Javier on 22/12/2017.
 */

public class Logout {

    @SerializedName("data")
    @Expose
    private List<Datum> data = null;

    public Logout(List<Datum> data) {
        this.data = data;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }
}
