package com.example.javier.healthera.utils;

import com.example.javier.healthera.MainActivity;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;

/**
 * Created by Javier on 21/12/2017.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    void inject(MainActivity mainActivity);
}
