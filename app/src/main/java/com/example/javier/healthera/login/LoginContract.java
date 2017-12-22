package com.example.javier.healthera.login;

import com.example.javier.healthera.model.remedy.Remedy;
import com.example.javier.healthera.model.token.Token;
import com.example.javier.healthera.remedy.RemedyContract;
import com.example.javier.healthera.utils.BasePresenter;
import com.example.javier.healthera.utils.BaseView;

/**
 * Created by Javier on 21/12/2017.
 */

public interface LoginContract {

    interface Presenter extends BasePresenter {
        void fetch(String userName, String password);
    }

    interface View extends BaseView<LoginContract.Presenter> {

        void showRemedy(Token token);

        void showError();

        void setLoadingIndicator(boolean active);

    }
}
