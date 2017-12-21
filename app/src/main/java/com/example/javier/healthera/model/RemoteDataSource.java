package com.example.javier.healthera.model;

import com.example.javier.healthera.model.adherence.Adherence;

import retrofit2.Retrofit;
import rx.Observable;

/**
 * Created by Javier on 21/12/2017.
 */

public class RemoteDataSource implements Service {

    private Service api;

    public RemoteDataSource(Retrofit retrofit) {


        this.api = retrofit.create(Service.class);
    }

    @Override
    public Observable<Adherence> getAdherence() {
        return api.getAdherence();
    }

}
