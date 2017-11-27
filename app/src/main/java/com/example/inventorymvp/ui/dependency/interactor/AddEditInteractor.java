package com.example.inventorymvp.ui.dependency.interactor;

import android.text.TextUtils;

import com.example.inventorymvp.pojo.Dependency;
import com.example.inventorymvp.repository.DependencyRepository;

/**
 * Created by usuario on 24/11/17.
 */

public interface AddEditInteractor {
    interface OnConfirmedListener {
        void onNameEmptyError();

        void onShortNameEmptyError();

        void onSucess();

        void onDescriptionEmptyError();

        void onDependencyExistsError();
    };
    void validatedependency(String name, String shortName, String description);
}
