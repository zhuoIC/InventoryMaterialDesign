package com.example.inventorymvp.ui.dependency.contract;

import com.example.inventorymvp.pojo.Dependency;
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

        void setValidateDependencyError();
    }

    interface Presenter extends BasePresenter{
        void validatedependency(String name, String shortName, String description);

        void addDependency(String name, String shortName, String description);

        void editDependency(Dependency dependency);
    }
}
