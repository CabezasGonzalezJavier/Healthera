package com.example.javier.healthera.utils;

import com.example.javier.healthera.adherence.AdherenceActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Javier on 21/12/2017.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    void inject(AdherenceActivity mainActivity);
}
