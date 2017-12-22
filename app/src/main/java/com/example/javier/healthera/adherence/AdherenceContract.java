package com.example.javier.healthera.adherence;

import com.example.javier.healthera.model.Generic;
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
        void createGeneric(List<Datum> datums, String tablet, String tablets, String noFound);
        void fetchLogout();
    }

    interface View extends BaseView<Presenter> {

        void logout();

        void successfulLogout();

        void getDatum(List<Datum> datums);

        void showAdherence  (List<Generic> generics);

        void showError();

        void setLoadingIndicator(boolean active);

    }
}
