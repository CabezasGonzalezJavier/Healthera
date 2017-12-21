package com.example.javier.healthera.adherence;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.javier.healthera.HealtheraApplication;
import com.example.javier.healthera.R;
import com.example.javier.healthera.model.RemoteDataSource;
import com.example.javier.healthera.utils.scheduler.BaseSchedulerProvider;

import javax.inject.Inject;

import static com.example.javier.healthera.utils.Utils.addFragmentToActivity;

public class AdherenceActivity extends AppCompatActivity {
    @Inject
    RemoteDataSource mRemoteDataSource;

    @Inject
    BaseSchedulerProvider mSchedulerProvider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adherence_activity);
        initializeDagger();
        initFragment();
    }

    private void initializeDagger() {
        HealtheraApplication app = (HealtheraApplication) getApplication();
        app.getAppComponent().inject(this);
    }

    private void initFragment () {
        AdherenceFragment photoFragment = (AdherenceFragment) getSupportFragmentManager().
                findFragmentById(R.id.adherence_activity_contentFrame);

        if (photoFragment == null) {
            photoFragment = photoFragment.newInstance();
            addFragmentToActivity(getSupportFragmentManager(),
                    photoFragment, R.id.adherence_activity_contentFrame);
        }

        new AdherencePresenter(mRemoteDataSource, photoFragment, mSchedulerProvider);

    }
}
