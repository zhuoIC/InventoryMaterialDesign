package com.example.inventorymvp.ui.dependency;

import android.text.TextUtils;

import com.example.inventorymvp.pojo.Dependency;
import com.example.inventorymvp.repository.DependencyRepository;

/**
 * Created by usuario on 24/11/17.
 */

public class AddEditInteractor{

    public void validatedependency(String name, String shortName, String description, AddEditContract.Presenter.OnConfirmedListener onConfirmedListener) {
        if(TextUtils.isEmpty(name)){
            onConfirmedListener.onNameEmptyError();
        }
        else if(TextUtils.isEmpty(shortName)){
            onConfirmedListener.onShortNameEmptyError();
        }
        else if(TextUtils.isEmpty(description)){
            onConfirmedListener.onDescriptionEmptyError();
        }
        else if (!DependencyRepository.getInstance().validateCredentials(name, shortName, description)){
            onConfirmedListener.onDpenedencyExistsError();
        }
        else{
            onConfirmedListener.onSucess();
        }
    }


}
