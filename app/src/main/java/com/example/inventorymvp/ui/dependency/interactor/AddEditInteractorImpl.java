package com.example.inventorymvp.ui.dependency.interactor;

import android.text.TextUtils;

import com.example.inventorymvp.pojo.Dependency;
import com.example.inventorymvp.repository.DependencyRepository;

/**
 * Created by usuario on 27/11/17.
 */

public class AddEditInteractorImpl implements AddEditInteractor{

    public AddEditInteractor.OnConfirmedListener onConfirmedListener;

    public AddEditInteractorImpl(AddEditInteractor.OnConfirmedListener listener){
        this.onConfirmedListener = listener;
    }

    public void validatedependency(String name, String shortName, String description) {
        if(TextUtils.isEmpty(name)){
            onConfirmedListener.onNameEmptyError();
        }
        else if(TextUtils.isEmpty(shortName)){
            onConfirmedListener.onShortNameEmptyError();
        }
        else if(TextUtils.isEmpty(description)){
            onConfirmedListener.onDescriptionEmptyError();
        }
        else if (DependencyRepository.getInstance().validateCredentials(name, shortName, description)){
            onConfirmedListener.onDependencyExistsError();
        }
        else{
            DependencyRepository.getInstance().addDependency(new Dependency(
                    DependencyRepository.getInstance().getDependencies().size() + 1,
                    name,
                    shortName,
                    description));
            onConfirmedListener.onSucess();
        }
    }
}
