package com.example.inventorymvp.ui.dependency.presenter;

import com.example.inventorymvp.ui.dependency.contract.AddEditContract;
import com.example.inventorymvp.ui.dependency.interactor.AddEditInteractor;
import com.example.inventorymvp.ui.dependency.interactor.AddEditInteractorImpl;

/**
 * Created by usuario on 23/11/17.
 */

public class AddEditPresenter implements AddEditContract.Presenter, AddEditInteractor.OnConfirmedListener {

    private AddEditContract.View view;
    private AddEditInteractorImpl addEditInteractor;

    public AddEditPresenter(AddEditContract.View view) {
        this.view = view;
        addEditInteractor = new AddEditInteractorImpl(this);
    }

    @Override
    public void validatedependency(String name, String shortName, String description) {
        addEditInteractor.validatedependency(name, shortName, description);
    }
    @Override
    public void onNameEmptyError() {
        view.showNameError();
    }

    @Override
    public void onShortNameEmptyError() {
        view.showShortNameError();
    }

    @Override
    public void onDescriptionEmptyError() {
        view.showDescriptionError();
    }

    @Override
    public void onDependencyExistsError() {
        view.showDependecyExistsError();
    }

    @Override
    public void onSucess() {
        view.showListDependency();
    }
}
