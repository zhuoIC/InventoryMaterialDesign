package com.example.inventorymvp.ui.dependency.interactor;

import com.example.inventorymvp.pojo.Dependency;
import com.example.inventorymvp.repository.DependencyRepository;

/**
 * Created by usuario on 27/11/17.
 */

public class ListDependencyInteractorImpl implements ListDependencyInteractor{

    private ListDependencyInteractor.OnLoadFinishedListener listener;

    public ListDependencyInteractorImpl(ListDependencyInteractor.OnLoadFinishedListener listener){
        this.listener = listener;
    }

    public void loadDependency() {
        listener.onSucess(DependencyRepository.getInstance().getDependencies());
    }

    @Override
    public void deleteDependency(Dependency dependency) {
        DependencyRepository.getInstance().deleteDependency(dependency);
    }
}
