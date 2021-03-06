package com.example.javier.healthera.model.token;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Javier on 21/12/2017.
 */

public class Token implements Serializable {

    @SerializedName("data")
    @Expose
    private List<Datum> data = null;
    @SerializedName("aux")
    @Expose
    private Aux aux;

    public Token(List<Datum> data) {
        this.data = data;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public Aux getAux() {
        return aux;
    }

    public void setAux(Aux aux) {
        this.aux = aux;
    }

}
