package com.example.javier.healthera.adherence;

import android.support.annotation.NonNull;

import com.example.javier.healthera.model.RemoteDataSource;
import com.example.javier.healthera.model.adherence.Adherence;
import com.example.javier.healthera.utils.scheduler.BaseSchedulerProvider;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Javier on 21/12/2017.
 */

public class AdherencePresenter implements AdherenceContract.Presenter {

    @NonNull
    private AdherenceContract.View mView;

    @NonNull
    private BaseSchedulerProvider mSchedulerProvider;

    @NonNull
    private CompositeSubscription mSubscriptions;

    @NonNull
    private RemoteDataSource mRemoteDataSource;

    public AdherencePresenter(@NonNull RemoteDataSource remoteDataSource, @NonNull AdherenceContract.View view, @NonNull BaseSchedulerProvider provider) {
        this.mRemoteDataSource = checkNotNull(remoteDataSource, "remoteDataSource");
        this.mView = checkNotNull(view, "view cannot be null!");
        this.mSchedulerProvider = checkNotNull(provider, "schedulerProvider cannot be null");

        mSubscriptions = new CompositeSubscription();

        mView.setPresenter(this);
    }


    @Override
    public void subscribe() {
        fetch();
    }

    @Override
    public void unSubscribe() {

    }

    @Override
    public void fetch() {
        mView.setLoadingIndicator(true);
        Subscription subscription = mRemoteDataSource.getAdherence()
                .subscribeOn(mSchedulerProvider.computation())
                .observeOn(mSchedulerProvider.ui())
                .subscribe((Adherence adherence) -> {
                            mView.setLoadingIndicator(false);
                            mView.showAdherence(adherence.getData());
                        },
                        (Throwable error) -> {
                            try {
                                mView.showError();
                            } catch (Throwable t) {
                                throw new IllegalThreadStateException();
                            }

                        },
                        () -> {
                        });

        mSubscriptions.add(subscription);
    }
}
