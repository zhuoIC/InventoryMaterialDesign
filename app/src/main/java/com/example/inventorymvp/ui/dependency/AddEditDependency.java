package com.example.inventorymvp.ui.dependency;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.inventorymvp.R;
import com.example.inventorymvp.ui.base.BaseFragment;
import com.example.inventorymvp.ui.base.BasePresenter;


/**
 * Created by usuario on 3/11/17.
 */

public class AddEditDependency extends BaseFragment implements AddEditContract.View{
    private TextInputLayout tilName;
    private TextInputLayout tptShortName;
    private TextInputLayout tptDescription;
    public static final String TAG = "addeditdependency";
    private AddEditContract.Presenter presenter;

    public static Fragment newInstance(Bundle arguments) {
        AddEditDependency addEditDependency = new AddEditDependency();
        if(arguments != null){
            addEditDependency.setArguments(arguments);
        }
        return addEditDependency;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_addeditdependency, container, false);
        tilName = rootView.findViewById(R.id.tilName);
        tptShortName = rootView.findViewById(R.id.tilShorname);
        tptDescription = rootView.findViewById(R.id.tilDescription);
        FloatingActionButton fab = rootView.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.validatedependency(tilName.getEditText().getText().toString(),
                        tptShortName.getEditText().getText().toString(),
                        tptDescription.getEditText().getText().toString());
            }
        });
        if (getArguments() != null) { // Se trata de la opcion editar

        }
        return rootView;
    }

    @Override
    public void setPresenter(BasePresenter presenter) {
        this.presenter = (AddEditContract.Presenter) presenter;
    }

    @Override
    public void showDescriptionError() {
        tptDescription.setError(getResources().getString(R.string.errorDescriptionEmpty));
    }

    @Override
    public void showShortNameError() {
        tptShortName.setError(getResources().getString(R.string.errorShortNameEmpty));
    }

    @Override
    public void showNameError() {
        tilName.setError(getResources().getString(R.string.errorNameEmpty));
    }

    @Override
    public void showDependecyExistsError() {
        showMessage(getResources().getString(R.string.errorDependencyDuplicated));
    }


    // Si all esta correcto se muestra este mensaje
    @Override
    public void showListDependency() {
    }
}
