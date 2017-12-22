package com.example.javier.healthera.login;

import android.content.Context;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.javier.healthera.R;
import com.example.javier.healthera.model.token.Datum;
import com.example.javier.healthera.model.token.Token;
import com.example.javier.healthera.utils.InteractionListener;
import com.example.javier.healthera.utils.LoginListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.http.Body;

import static android.support.design.widget.Snackbar.LENGTH_LONG;

/**
 * Created by Javier on 21/12/2017.
 */

public class LoginFragment extends Fragment implements LoginContract.View {

    @BindView(R.id.login_fragment_progress)
    ProgressBar mProgressBar;

    @BindView(R.id.login_fragment_retry_button)
    Button mRetry;

    @BindView(R.id.login_fragment_constraintLayout)
    ConstraintLayout mRelativeLayout;

    @BindView(R.id.login_fragment_username)
    EditText mUsername;

    @BindView(R.id.login_fragment_password)
            EditText mPassword;


    LoginContract.Presenter mPresenter;

    LoginListener mListener;

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.login_fragment, container, false);
        ButterKnife.bind(this, view);
        mUsername.setText("assessment@iosbr.com.br");
        mPassword.setText("Healthera01");
        return view;
    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showRemedy(Token token) {
        mListener.onFragmentInteraction(token);
    }

    @Override
    public void showError() {
        mProgressBar.setVisibility(View.GONE);
        Snackbar.make(mRelativeLayout, getActivity().getResources().getText(R.string.error_server).toString(), LENGTH_LONG).show();
    }

    @Override
    public void setLoadingIndicator(boolean active) {
        if (!active) {
            mProgressBar.setVisibility(View.GONE);
        } else {
            mProgressBar.setVisibility(View.VISIBLE);
        }
    }
    @OnClick(R.id.login_fragment_retry_button)
    public void login() {
        com.example.javier.healthera.model.token.Datum datumToken = new com.example.javier.healthera.model.token.Datum();
        List<Datum> listDatumToken = new ArrayList<>();
        listDatumToken.add(datumToken);
        mListener.onFragmentInteraction(new Token(listDatumToken));
        //mPresenter.fetch(mUsername.getText().toString(), mPassword.getText().toString());
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof LoginListener) {
            //init the listener
            mListener = (LoginListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement InteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}
