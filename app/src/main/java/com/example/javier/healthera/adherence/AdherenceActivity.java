package com.example.javier.healthera.adherence;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.javier.healthera.HealtheraApplication;
import com.example.javier.healthera.R;
import com.example.javier.healthera.model.Generic;
import com.example.javier.healthera.model.RemoteDataSource;
import com.example.javier.healthera.remedy.RemedyActivity;
import com.example.javier.healthera.utils.InteractionListener;
import com.example.javier.healthera.utils.scheduler.BaseSchedulerProvider;

import javax.inject.Inject;

import static com.example.javier.healthera.utils.Constants.SERIALIZABLE_GENERIC;
import static com.example.javier.healthera.utils.Utils.addFragmentToActivity;

public class AdherenceActivity extends AppCompatActivity implements InteractionListener {

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

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("patients/");
        stringBuilder.append("99863cb0-e001-11e7-a8d8-010d4f584d4e/");

        new AdherencePresenter(photoFragment, mSchedulerProvider, stringBuilder.toString());

    }

    @Override
    public void onFragmentInteraction(Generic generic) {

        Intent intent = new Intent(this, RemedyActivity.class);
        Bundle mBundle = new Bundle();
        mBundle.putSerializable(SERIALIZABLE_GENERIC, generic);
        intent.putExtras(mBundle);
        startActivity(intent);

    }
}
