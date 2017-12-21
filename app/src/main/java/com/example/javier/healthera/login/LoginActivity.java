package com.example.javier.healthera.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.javier.healthera.HealtheraApplication;
import com.example.javier.healthera.R;
import com.example.javier.healthera.adherence.AdherenceFragment;
import com.example.javier.healthera.adherence.AdherencePresenter;
import com.example.javier.healthera.model.token.Token;
import com.example.javier.healthera.utils.LoginListener;
import com.example.javier.healthera.utils.scheduler.BaseSchedulerProvider;

import javax.inject.Inject;

import static com.example.javier.healthera.utils.Utils.addFragmentToActivity;

/**
 * Created by Javier on 21/12/2017.
 */

public class LoginActivity extends AppCompatActivity implements LoginListener{

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

        LoginFragment loginFragment = (LoginFragment) getSupportFragmentManager().
                findFragmentById(R.id.login_activity_contentFrame);
        if (loginFragment == null) {
            loginFragment = loginFragment.newInstance();
            addFragmentToActivity(getSupportFragmentManager(), loginFragment,
            R.id.login_activity_contentFrame);

        }
        String url = "tokens";
        new LoginPresenter(loginFragment, mSchedulerProvider, url);

    }

    @Override
    public void onFragmentInteraction(Token token) {

    }
}
