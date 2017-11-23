package com.example.inventorymvp.ui.dependency;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.inventorymvp.R;


/**
 * Created by usuario on 3/11/17.
 */

public class AddEditDependency extends Fragment implements AddEditContract.View{
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
        if(getArguments() != null){ // Se trata de la opcion editar

        }
        return rootView;
    }

    @Override
    public void setPresenter(AddEditContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
