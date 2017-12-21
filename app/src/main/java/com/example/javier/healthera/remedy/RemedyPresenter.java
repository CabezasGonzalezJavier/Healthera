package com.example.javier.healthera.remedy;

import android.support.annotation.NonNull;

import com.example.javier.healthera.adherence.AdherenceContract;
import com.example.javier.healthera.model.RemoteDataSource;
import com.example.javier.healthera.model.adherence.Adherence;
import com.example.javier.healthera.model.remedy.Remedy;
import com.example.javier.healthera.utils.scheduler.BaseSchedulerProvider;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

import static com.example.javier.healthera.utils.Constants.URL_BASE;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Javier on 21/12/2017.
 */

public class RemedyPresenter implements RemedyContract.Presenter {


    @NonNull
    private RemedyContract.View mView;

    @NonNull
    private BaseSchedulerProvider mSchedulerProvider;

    @NonNull
    private CompositeSubscription mSubscriptions;

    @NonNull
    private RemoteDataSource mRemoteDataSource;

    public RemedyPresenter(@NonNull RemedyContract.View view, @NonNull BaseSchedulerProvider provider, String url) {

        this.mView = checkNotNull(view, "view cannot be null!");
        this.mSchedulerProvider = checkNotNull(provider, "schedulerProvider cannot be null");

        this.mRemoteDataSource = new RemoteDataSource(new Retrofit.Builder()
                .baseUrl(URL_BASE+url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build());
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
        Subscription subscription = mRemoteDataSource.getRemedy()
                .subscribeOn(mSchedulerProvider.computation())
                .observeOn(mSchedulerProvider.ui())
                .subscribe((Remedy remedy) -> {
                            mView.setLoadingIndicator(false);
                            mView.showRemedy(remedy);
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
