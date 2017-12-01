package com.example.inventorymvp.ui.dependency.interactor;

import com.example.inventorymvp.pojo.Dependency;

import java.util.List;

/**
 * Created by usuario on 24/11/17.
 */

public interface ListDependencyInteractor {

    interface OnLoadFinishedListener{
        void onSucess(List<Dependency> dependencies);
    }

    void loadDependency();
    void deleteDependency(Dependency dependency);
}
