package com.example.javier.healthera.remedy;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.javier.healthera.R;
import com.example.javier.healthera.adherence.AdherenceContract;
import com.example.javier.healthera.adherence.AdherenceFragment;
import com.example.javier.healthera.model.remedy.Remedy;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.support.design.widget.Snackbar.LENGTH_LONG;

/**
 * Created by Javier on 21/12/2017.
 */

public class RemedyFragment extends Fragment implements RemedyContract.View{

    @BindView(R.id.remedy_fragment_progress)
    ProgressBar mProgressBar;

    @BindView(R.id.remedy_fragment_retry_button)
    Button mRetry;

    @BindView(R.id.remedy_fragment_constraintLayout)
    ConstraintLayout mRelativeLayout;

    @BindView(R.id.remedy_fragment_textView)
    TextView mTextView;

    RemedyContract.Presenter mPresenter;

    public static RemedyFragment newInstance() {
        return new RemedyFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.remedy_fragment, container, false);
        ButterKnife.bind(this, view);
        mPresenter.subscribe();
        return view;
    }

    @Override
    public void setPresenter(RemedyContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showRemedy(Remedy remedy) {
        mTextView.setText(remedy.getData().get(0).getCourseQuantity());
    }

    @Override
    public void showError() {
        mProgressBar.setVisibility(View.GONE);
        mRetry.setVisibility(View.VISIBLE);
        Snackbar.make(mRelativeLayout, getActivity().getResources().getText(R.string.error_server).toString(), LENGTH_LONG).show();
        mRetry.setText(getString(R.string.retry));
    }

    @Override
    public void setLoadingIndicator(boolean active) {
        if (!active) {
            mRetry.setVisibility(View.GONE);
            mProgressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        mPresenter.unSubscribe();
    }
}
