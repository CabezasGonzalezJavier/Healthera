package com.example.javier.healthera;

import android.app.Application;

import com.example.javier.healthera.utils.AppComponent;
import com.example.javier.healthera.utils.AppModule;
import com.example.javier.healthera.utils.DaggerAppComponent;

/**
 * Created by Javier on 21/12/2017.
 */

public class HealtheraApplication extends Application {
    AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

}
