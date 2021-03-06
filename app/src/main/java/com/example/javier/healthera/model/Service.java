package com.example.javier.healthera.model;

import com.example.javier.healthera.model.adherence.Adherence;
import com.example.javier.healthera.model.logout.Logout;
import com.example.javier.healthera.model.remedy.Remedy;
import com.example.javier.healthera.model.token.Token;

import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;
import retrofit2.http.Headers;

/**
 * Created by Javier on 21/12/2017.
 */

public interface Service {


    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
            "client-id: a4c7fdd994b14c0758e91dc997426f043868d4305702f4484220df51d56497b3"
    })
    @POST("tokens/")
    Observable<Token> getToken(@Body String username, @Body String userPassword);
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
            "Token: eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0b2tlbl9pZCI6IjdhN2VmMjcwLWU2MzMtMTFlNy1hODM0LWIwZGE2OTNiOTBjNiIsImV4cCI6MTUyMjQ4OTQ0MywiaWF0IjoxNTEzODQ5NDQzLCJ1c2VyX2lkIjoiOTk4NjNjYjAtZTAwMS0xMWU3LWE4ZDgtMDEwZDRmNTg0ZDRlIn0.DdLSI5IWyf2xc8yvC8N8sUYOx6_LG5_nAc-khcvWsW4",
            "client-id: a4c7fdd994b14c0758e91dc997426f043868d4305702f4484220df51d56497b3",
            "app-platform: ios",
            "app-version: 1.4"
    })
    @GET("adherences/")
    Observable<Adherence> getAdherence();

    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
            "Token: eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0b2tlbl9pZCI6IjdhN2VmMjcwLWU2MzMtMTFlNy1hODM0LWIwZGE2OTNiOTBjNiIsImV4cCI6MTUyMjQ4OTQ0MywiaWF0IjoxNTEzODQ5NDQzLCJ1c2VyX2lkIjoiOTk4NjNjYjAtZTAwMS0xMWU3LWE4ZDgtMDEwZDRmNTg0ZDRlIn0.DdLSI5IWyf2xc8yvC8N8sUYOx6_LG5_nAc-khcvWsW4",
            "client-id: a4c7fdd994b14c0758e91dc997426f043868d4305702f4484220df51d56497b3",
            "app-platform: ios",
            "app-version: 1.4"
    })
    @GET("/")
    Observable<Remedy> getRemedy();

    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
            "Token: eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0b2tlbl9pZCI6IjMyMWM3MzYwLWU2ZjktMTFlNy04ZjQyLTc1NWYxNDBmZTk5MiIsImV4cCI6MTUyMjU3NDM2MiwiaWF0IjoxNTEzOTM0MzYyLCJ1c2VyX2lkIjoiOTk4NjNjYjAtZTAwMS0xMWU3LWE4ZDgtMDEwZDRmNTg0ZDRlIn0.ZjAzAQGsCj1whZEmJuKOaLv2ceYKxBk0rnmTxy4bd7Y",
            "client-id: a4c7fdd994b14c0758e91dc997426f043868d4305702f4484220df51d56497b3",
            "app-platform: ios",
            "app-version: 1.4"
    })
    @DELETE("tokens/")
    Observable<Logout> logout();

}
