package com.example.javier.healthera.model.adherence;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Javier on 21/12/2017.
 */

public class Adherence {

    @SerializedName("data")
    @Expose
    private List<Datum> data = null;

    public Adherence(List<Datum> data) {
        this.data = data;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

}
