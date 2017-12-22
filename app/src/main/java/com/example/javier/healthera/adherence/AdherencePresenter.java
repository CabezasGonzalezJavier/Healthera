package com.example.javier.healthera.adherence;

import android.support.annotation.NonNull;

import com.example.javier.healthera.R;
import com.example.javier.healthera.model.RemoteDataSource;
import com.example.javier.healthera.model.adherence.Adherence;
import com.example.javier.healthera.model.adherence.Datum;
import com.example.javier.healthera.model.logout.Logout;
import com.example.javier.healthera.utils.scheduler.BaseSchedulerProvider;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

import static com.example.javier.healthera.model.CreateGenericList.getGenericList;
import static com.example.javier.healthera.utils.Constants.URL_BASE;
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

    public AdherencePresenter(@NonNull AdherenceContract.View view, @NonNull BaseSchedulerProvider provider, String url) {
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
        Subscription subscription = mRemoteDataSource.getAdherence()
                .subscribeOn(mSchedulerProvider.computation())
                .observeOn(mSchedulerProvider.ui())
                .subscribe((Adherence adherence) -> {
                            mView.setLoadingIndicator(false);
                            mView.getDatum(adherence.getData());
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

    @Override
    public void createGeneric(List<Datum> datums, String tablet, String tablets, String noFound) {
        mView.showAdherence(getGenericList(datums, tablet, tablets, noFound));
    }

    @Override
    public void fetchLogout() {
        mView.setLoadingIndicator(true);
        Subscription subscription = mRemoteDataSource.logout()
        .subscribeOn(mSchedulerProvider.computation())
                .observeOn(mSchedulerProvider.ui())
                .subscribe((Logout logout) -> {
                            mView.setLoadingIndicator(false);
                            mView.successfulLogout();
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
