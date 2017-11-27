package com.example.inventorymvp.ui.dependency.contract;

import com.example.inventorymvp.pojo.Dependency;
import com.example.inventorymvp.ui.base.BasePresenter;
import com.example.inventorymvp.ui.base.BaseView;

import java.util.List;

/**
 * Created by usuario on 23/11/17.
 */

public interface ListDependencyContract {
    interface View extends BaseView{
        void showDependency(List<Dependency> dependencies);

    }

    interface Presenter extends BasePresenter{
        void loadDependency();
    }
}
