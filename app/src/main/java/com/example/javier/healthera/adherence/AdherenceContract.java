package com.example.javier.healthera.adherence;

import com.example.javier.healthera.model.adherence.Datum;
import com.example.javier.healthera.utils.BasePresenter;
import com.example.javier.healthera.utils.BaseView;

import java.util.List;

/**
 * Created by Javier on 21/12/2017.
 */

public interface AdherenceContract {

    interface Presenter extends BasePresenter {
        void fetch();
    }

    interface View extends BaseView<Presenter> {

        void showAdherence  (List<Datum> datums);

        void showError();

        void setLoadingIndicator(boolean active);

    }
}
