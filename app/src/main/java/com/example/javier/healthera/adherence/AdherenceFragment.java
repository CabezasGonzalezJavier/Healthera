package com.example.javier.healthera.adherence;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.javier.healthera.R;
import com.example.javier.healthera.model.Generic;
import com.example.javier.healthera.model.adherence.Datum;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.support.design.widget.Snackbar.LENGTH_LONG;

/**
 * Created by Javier on 21/12/2017.
 */

public class AdherenceFragment extends Fragment implements AdherenceContract.View {

    @BindView(R.id.adherence_fragment_progress)
    ProgressBar mProgressBar;

    @BindView(R.id.adherence_fragment_retry_button)
    Button mRetry;

    @BindView(R.id.adherence_fragment_constraintLayout)
    ConstraintLayout mRelativeLayout;

    @BindView(R.id.adherence_fragment_recycler_view)
    RecyclerView mRecyclerView;

    AdherenceAdapter mAdapter;

    AdherenceContract.Presenter mPresenter;

    public static AdherenceFragment newInstance() {
        return new AdherenceFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.adherence_fragment, container, false);
        ButterKnife.bind(this, view);
        mPresenter.subscribe();
        return view;
    }

    @Override
    public void setPresenter(AdherenceContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void getDatum(List<Datum> datums) {
        mPresenter.createGeneric(datums, getString(R.string.tablet), getString(R.string.tablets), getString(R.string.no_found));
    }

    @Override
    public void showAdherence(List<Generic> generics) {
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new AdherenceAdapter(getActivity(), generics);
        mRecyclerView.setAdapter(mAdapter);
        //mAdapter.setOnItemClickListener(this);

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

    @OnClick(R.id.adherence_fragment_retry_button)
    public void onClick() {
        setLoadingIndicator(false);
        mPresenter.fetch();
    }
}
