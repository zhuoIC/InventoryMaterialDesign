package com.example.inventorymvp.ui.dependency;

/**
 * Created by usuario on 23/11/17.
 */

public class AddEditPresenter implements AddEditContract.Presenter{
    private AddEditContract.View view;
    public AddEditPresenter(AddEditContract.View view) {
        this.view = view;
    }
}
