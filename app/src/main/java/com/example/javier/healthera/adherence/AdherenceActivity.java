package com.example.javier.healthera.adherence;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.javier.healthera.HealtheraApplication;
import com.example.javier.healthera.R;
import com.example.javier.healthera.model.Generic;
import com.example.javier.healthera.remedy.RemedyActivity;
import com.example.javier.healthera.utils.InteractionListener;
import com.example.javier.healthera.utils.SuccessfulLogoutListener;
import com.example.javier.healthera.utils.scheduler.BaseSchedulerProvider;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.javier.healthera.utils.Constants.SERIALIZABLE_GENERIC;
import static com.example.javier.healthera.utils.Utils.addFragmentToActivity;

public class AdherenceActivity extends AppCompatActivity implements InteractionListener, SuccessfulLogoutListener {

    @Inject
    BaseSchedulerProvider mSchedulerProvider;

    @BindView(R.id.adherence_activity_toolbar_title)
    TextView mToolBarTextView;

    AdherenceFragment mAdherenceFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adherence_activity);

        ButterKnife.bind(this);

        mToolBarTextView.setText(getResources().getString(R.string.schedule));
        initializeDagger();
        initFragment();
    }

    private void initializeDagger() {
        HealtheraApplication app = (HealtheraApplication) getApplication();
        app.getAppComponent().inject(this);
    }

    private void initFragment () {
        mAdherenceFragment = (AdherenceFragment) getSupportFragmentManager().
                findFragmentById(R.id.adherence_activity_contentFrame);

        if (mAdherenceFragment == null) {
            mAdherenceFragment = mAdherenceFragment.newInstance();
            addFragmentToActivity(getSupportFragmentManager(),
                    mAdherenceFragment, R.id.adherence_activity_contentFrame);
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("patients/");
        stringBuilder.append("99863cb0-e001-11e7-a8d8-010d4f584d4e/");

        new AdherencePresenter(mAdherenceFragment, mSchedulerProvider, stringBuilder.toString());

    }

    @Override
    public void onFragmentInteraction(Generic generic) {

        Intent intent = new Intent(this, RemedyActivity.class);
        Bundle mBundle = new Bundle();
        mBundle.putSerializable(SERIALIZABLE_GENERIC, generic);
        intent.putExtras(mBundle);
        startActivity(intent);

    }

    @OnClick(R.id.adherence_activity_toolbar_imageView)
    public void cameBackToLogin() {
        mAdherenceFragment.logout();
    }

    @Override
    public void successfulLogout() {
        finish();
    }
}
