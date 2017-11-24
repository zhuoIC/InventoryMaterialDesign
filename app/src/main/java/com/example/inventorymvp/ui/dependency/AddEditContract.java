package com.example.inventorymvp.ui.dependency;

import com.example.inventorymvp.ui.base.BasePresenter;
import com.example.inventorymvp.ui.base.BaseView;

/**
 * Created by usuario on 23/11/17.
 */

public interface AddEditContract {
    interface View extends BaseView{

        void showShortNameError();

        void showNameError();

        void showDependecyExistsError();

        void showListDependency();

        void showDescriptionError();
    }

    interface Presenter extends BasePresenter{

        interface OnConfirmedListener {
            void onNameEmptyError();

            void onShortNameEmptyError();

            void onSucess();

            void onDescriptionEmptyError();

            void onDpenedencyExistsError();
        };
        void validatedependency(String name, String shortName, String description);
    }
}
