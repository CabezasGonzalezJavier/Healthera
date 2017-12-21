package com.example.javier.healthera.remedy;

import com.example.javier.healthera.adherence.AdherenceContract;
import com.example.javier.healthera.model.Generic;
import com.example.javier.healthera.model.adherence.Datum;
import com.example.javier.healthera.model.remedy.Remedy;
import com.example.javier.healthera.utils.BasePresenter;
import com.example.javier.healthera.utils.BaseView;

import java.util.List;

/**
 * Created by Javier on 21/12/2017.
 */

public class RemedyContract {

    interface Presenter extends BasePresenter {
        void fetch();
    }

    interface View extends BaseView<RemedyContract.Presenter> {

        void showRemedy(Remedy remedy);

        void showError();

        void setLoadingIndicator(boolean active);

    }
}
