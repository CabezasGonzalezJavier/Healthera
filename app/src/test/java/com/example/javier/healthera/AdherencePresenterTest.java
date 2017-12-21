package com.example.javier.healthera;

import com.example.javier.healthera.adherence.AdherenceContract;
import com.example.javier.healthera.adherence.AdherencePresenter;
import com.example.javier.healthera.model.RemoteDataSource;
import com.example.javier.healthera.model.adherence.Adherence;
import com.example.javier.healthera.model.adherence.Datum;
import com.example.javier.healthera.utils.scheduler.BaseSchedulerProvider;
import com.example.javier.healthera.utils.scheduler.ImmediateSchedulerProvider;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

import static org.mockito.Mockito.when;

/**
 * Created by Javier on 21/12/2017.
 */

public class AdherencePresenterTest {

    @Mock
    private AdherenceContract.View mView;

    @Mock
    private BaseSchedulerProvider mSchedulerProvider;

    @Mock
    private RemoteDataSource mRemoteDataSource;

    AdherencePresenter mPresenter;
    Adherence mResult;

    @Before
    public void setup() {

        Datum datum = new Datum("patiendId", "remedyId");
        List<Datum> list = new ArrayList<>();
        list.add(datum);
        mResult = new Adherence(list);


        MockitoAnnotations.initMocks(this);
        mSchedulerProvider = new ImmediateSchedulerProvider();
        mPresenter = new AdherencePresenter(mRemoteDataSource, mView, mSchedulerProvider);
    }

    @Test
    public void fetchData() {
        when(mRemoteDataSource.getAdherence())
                .thenReturn(rx.Observable.just(mResult));

        mPresenter.fetch();

        InOrder inOrder = Mockito.inOrder(mView);
        inOrder.verify(mView).setLoadingIndicator(true);
        inOrder.verify(mView).setLoadingIndicator(false);
        inOrder.verify(mView).showAdherence(mResult.getData());
    }

    @Test
    public void fetchError() {

        when(mRemoteDataSource.getAdherence())
                .thenReturn(Observable.error(new Throwable("An error has occurred!")));

        mPresenter.fetch();

        InOrder inOrder = Mockito.inOrder(mView);
        inOrder.verify(mView).setLoadingIndicator(true);
        inOrder.verify(mView).showError();
    }

}
