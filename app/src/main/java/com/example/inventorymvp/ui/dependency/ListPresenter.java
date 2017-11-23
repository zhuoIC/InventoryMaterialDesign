package com.example.inventorymvp.ui.dependency;

/**
 * Created by usuario on 23/11/17.
 */

public class ListPresenter implements ListDependencyContract.Presenter{
    private ListDependencyContract.View view;
    public ListPresenter(ListDependencyContract.View view) {
        this.view = view;
    }

}
