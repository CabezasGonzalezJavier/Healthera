package com.example.javier.healthera.remedy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import com.example.javier.healthera.HealtheraApplication;
import com.example.javier.healthera.R;
import com.example.javier.healthera.adherence.AdherenceFragment;
import com.example.javier.healthera.adherence.AdherencePresenter;
import com.example.javier.healthera.model.Generic;
import com.example.javier.healthera.model.RemoteDataSource;
import com.example.javier.healthera.utils.scheduler.BaseSchedulerProvider;

import javax.inject.Inject;

import static com.example.javier.healthera.utils.Constants.SERIALIZABLE_GENERIC;
import static com.example.javier.healthera.utils.Utils.addFragmentToActivity;

/**
 * Created by Javier on 21/12/2017.
 */

public class RemedyActivity extends AppCompatActivity {

    @Inject
    BaseSchedulerProvider mSchedulerProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.remedy_activity);
        overridePendingTransition(R.anim.appearance_go_in, R.anim.appearance_go_out);
        Generic genericTwo = (Generic) getIntent().getSerializableExtra(SERIALIZABLE_GENERIC);
        initializeDagger();
        initFragment(genericTwo);

    }

    public void back(View view) {
        finishMyActivity();
    }

    @Override
    public void onBackPressed() {
        finishMyActivity();
    }

    public void finishMyActivity() {
        finish();
        overridePendingTransition(R.anim.appearance_back_in, R.anim.appearance_back_out);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finishMyActivity();
                break;
        }
        return true;
    }


    private void initializeDagger() {
        HealtheraApplication app = (HealtheraApplication) getApplication();
        app.getAppComponent().inject(this);
    }

    private void initFragment(Generic generic) {

        RemedyFragment remedyFragment = (RemedyFragment) getSupportFragmentManager().
                findFragmentById(R.id.remedy_activity_contentFrame);
        if (remedyFragment == null) {
            remedyFragment = remedyFragment.newInstance();
            addFragmentToActivity(getSupportFragmentManager(), remedyFragment,
                    R.id.remedy_activity_contentFrame);
        }

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("patients/");
        stringBuilder.append(generic.getPatientId());
        stringBuilder.append("/remedies/");
        stringBuilder.append(generic.getRemedyId());
        stringBuilder.append("/");

        new RemedyPresenter(remedyFragment, mSchedulerProvider, stringBuilder.toString());

    }
}