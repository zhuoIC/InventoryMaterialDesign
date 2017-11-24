package com.example.inventorymvp.ui.dependency;

/**
 * Created by usuario on 23/11/17.
 */

public class AddEditPresenter implements AddEditContract.Presenter, AddEditContract.Presenter.OnConfirmedListener{
    private AddEditContract.View view;
    private AddEditInteractor addEditInteractor;
    public AddEditPresenter(AddEditContract.View view) {
        this.view = view;
        addEditInteractor = new AddEditInteractor();
    }

    @Override
    public void validatedependency(String name, String shortName, String description) {
        addEditInteractor.validatedependency(name, shortName, description, this);
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
    public void onDpenedencyExistsError() {
        view.showDependecyExistsError();
    }

    @Override
    public void onSucess() {
        view.showListDependency();
    }
}
