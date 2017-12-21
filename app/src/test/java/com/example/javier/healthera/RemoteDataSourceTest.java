package com.example.javier.healthera;

import com.example.javier.healthera.model.RemoteDataSource;
import com.example.javier.healthera.model.adherence.Adherence;
import com.example.javier.healthera.model.adherence.Datum;
import com.example.javier.healthera.model.remedy.Remedy;
import com.google.gson.Gson;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.observers.TestSubscriber;

import static com.example.javier.healthera.utils.Constants.URL_BASE;

/**
 * Created by Javier on 21/12/2017.
 */

public class RemoteDataSourceTest {

    Adherence mResult;
    MockWebServer mMockWebServer;
    TestSubscriber<Adherence> mSubscriber;
    TestSubscriber<Remedy> mSubscriberRemedy;

    @Before
    public void setUp() {

        Datum datum = new Datum("patiendId", "remedyId");
        List<Datum> list = new ArrayList<>();
        list.add(datum);
        mResult = new Adherence(list);

        mMockWebServer = new MockWebServer();
        mSubscriber = new TestSubscriber<>();
        mSubscriberRemedy = new TestSubscriber<>();
    }

    @Test
    public void serverCallAdherenceWithError() {
        //Given
        String url = "dfdf/";
        mMockWebServer.enqueue(new MockResponse().setBody(new Gson().toJson(mResult)));
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(mMockWebServer.url(url))
                .build();
        RemoteDataSource remoteDataSource = new RemoteDataSource(retrofit);

        //When
        remoteDataSource.getAdherence().subscribe(mSubscriber);

        //Then
        mSubscriber.assertNoErrors();
        mSubscriber.assertCompleted();
    }

    @Test
    public void severCallAdherenceWithSuccessful() {
        String url = URL_BASE + "99863cb0-e001-11e7-a8d8-010d4f584d4e/";

        //Given
        mMockWebServer.enqueue(new MockResponse().setBody(new Gson().toJson(mResult)));
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(mMockWebServer.url(url))
                .build();
        RemoteDataSource remoteDataSource = new RemoteDataSource(retrofit);

        //When
        remoteDataSource.getAdherence().subscribe(mSubscriber);

        //Then
        mSubscriber.assertNoErrors();
        mSubscriber.assertCompleted();
    }

    @Test
    public void serverCallRemedyWithError() {
        //Given
        String url = "dfdf/";
        mMockWebServer.enqueue(new MockResponse().setBody(new Gson().toJson(mResult)));
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(mMockWebServer.url(url))
                .build();
        RemoteDataSource remoteDataSource = new RemoteDataSource(retrofit);

        //When
        remoteDataSource.getRemedy().subscribe(mSubscriberRemedy);

        //Then
        mSubscriberRemedy.assertNoErrors();
        mSubscriberRemedy.assertCompleted();
    }

    @Test
    public void serverCallRemedyWithSuccessful() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("99863cb0-e001-11e7-a8d8-010d4f584d4e/");
        stringBuilder.append("remedies/");
        stringBuilder.append("62384cb0-e003-11e7-b96e-59e9d4c851ec/");
        String url = URL_BASE + stringBuilder.toString();
        mMockWebServer.enqueue(new MockResponse().setBody(new Gson().toJson(mResult)));
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(mMockWebServer.url(url))
                .build();
        RemoteDataSource remoteDataSource = new RemoteDataSource(retrofit);

        //When
        remoteDataSource.getRemedy().subscribe(mSubscriberRemedy);

        //Then
        mSubscriberRemedy.assertNoErrors();
        mSubscriberRemedy.assertCompleted();
    }
}
