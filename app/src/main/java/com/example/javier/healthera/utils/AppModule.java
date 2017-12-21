package com.example.javier.healthera.utils;

import com.example.javier.healthera.HealtheraApplication;
import com.example.javier.healthera.model.RemoteDataSource;
import com.example.javier.healthera.utils.scheduler.BaseSchedulerProvider;
import com.example.javier.healthera.utils.scheduler.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.javier.healthera.utils.Constants.URL_BASE;

/**
 * Created by Javier on 21/12/2017.
 */
@Module
public class AppModule {

    HealtheraApplication mHealtheraApplication;

    public AppModule(HealtheraApplication photosApplication) {
        mHealtheraApplication = photosApplication;
    }

    @Singleton
    @Provides
    BaseSchedulerProvider provideSchedulerProvider() {
        return new SchedulerProvider();
    }

}
