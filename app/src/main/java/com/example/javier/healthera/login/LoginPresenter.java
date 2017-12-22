package com.example.javier.healthera.login;

import android.support.annotation.NonNull;

import com.example.javier.healthera.model.RemoteDataSource;
import com.example.javier.healthera.model.remedy.Remedy;
import com.example.javier.healthera.model.token.Token;
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

public class LoginPresenter implements LoginContract.Presenter {

    @NonNull
    private LoginContract.View mView;

    @NonNull
    private BaseSchedulerProvider mSchedulerProvider;

    @NonNull
    private CompositeSubscription mSubscriptions;

    @NonNull
    private RemoteDataSource mRemoteDataSource;

    public LoginPresenter(@NonNull LoginContract.View view, @NonNull BaseSchedulerProvider provider) {

        this.mView = checkNotNull(view, "view cannot be null!");
        this.mSchedulerProvider = checkNotNull(provider, "schedulerProvider cannot be null");

        this.mRemoteDataSource = new RemoteDataSource(new Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build());
        mSubscriptions = new CompositeSubscription();

        mView.setPresenter(this);
    }

    @Override
    public void subscribe() {
        fetch("","");
    }

    @Override
    public void unSubscribe() {

    }

    @Override
    public void fetch(String userName, String password) {
        mView.setLoadingIndicator(true);
        Subscription subscription = mRemoteDataSource.getToken(userName,password)
                .subscribeOn(mSchedulerProvider.computation())
                .observeOn(mSchedulerProvider.ui())
                .subscribe((Token token) -> {
                            mView.setLoadingIndicator(false);
                            //mView.showtoken);
                        },
                        (Throwable error) -> {
                            try {
                                mView.showError();
                                mView.setLoadingIndicator(false);
                            } catch (Throwable t) {
                                throw new IllegalThreadStateException();
                            }

                        },
                        () -> {
                        });

        mSubscriptions.add(subscription);
    }
}
