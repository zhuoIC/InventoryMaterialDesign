package com.example.inventorymvp.ui.dependency;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.inventorymvp.R;
import com.example.inventorymvp.pojo.Dependency;
import com.example.inventorymvp.ui.base.BaseFragment;
import com.example.inventorymvp.ui.dependency.contract.AddEditContract;
import com.example.inventorymvp.ui.dependency.presenter.AddEditPresenter;
import com.example.inventorymvp.ui.utils.AddEdit;


/**
 * Created by usuario on 3/11/17.
 */

public class AddEditDependency extends BaseFragment implements AddEditContract.View{

    private TextInputLayout tilName;
    private TextInputLayout tilShortName;
    private TextInputLayout tilDescription;
    public static final String TAG = "addeditdependency";
    public static final String EDIT_KEY = "edit";
    private AddEditContract.Presenter presenter;
    private static AddEdit mode;
    private EditText edtName;
    private EditText edtSortname;
    private EditText edtDescription;
    private FloatingActionButton fabDependency;

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

        // como el fragment mantiene el estado (y sólo se elimina la vista) se debe reinicializar el presenter
        // cuando se cree la vista
        presenter = new AddEditPresenter(this);

        tilName = rootView.findViewById(R.id.tilName);
        tilShortName = rootView.findViewById(R.id.tilShorname);
        tilDescription = rootView.findViewById(R.id.tilDescription);
        edtName = rootView.findViewById(R.id.edtName);
        edtSortname = rootView.findViewById(R.id.edtShorname);
        edtDescription = rootView.findViewById(R.id.edtDescription);
        fabDependency= rootView.findViewById(R.id.fab);
        fabDependency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.validatedependency(tilName.getEditText().getText().toString(),
                        tilShortName.getEditText().getText().toString(),
                        tilDescription.getEditText().getText().toString());
            }
        });
        if (getArguments() != null) {
            mode = new AddEdit(AddEdit.EDIT_MODE);
        } else
            mode = new AddEdit();
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fabDependency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mode.getMode() == AddEdit.ADD_MODE) {
                    presenter.addDependency(
                            tilName.getEditText().getText().toString(),
                            tilShortName.getEditText().getText().toString(),
                            tilDescription.getEditText().getText().toString());

                } else if (mode.getMode() == AddEdit.EDIT_MODE) {
                    Dependency dependency = getArguments().getParcelable(EDIT_KEY);
                    dependency.setDescription(edtDescription.getText().toString());
                    presenter.editDependency(dependency);
                }
            }
        });

        if (mode.getMode() == AddEdit.EDIT_MODE) {
            Dependency dependency = getArguments().getParcelable(EDIT_KEY);

            edtName.setText(dependency.getName());
            edtName.setEnabled(false);

            edtSortname.setText(dependency.getShortname());
            edtSortname.setEnabled(false);

            edtDescription.setText(dependency.getDescription());
        }
    }


    /*@Override
    public void setPresenter(BasePresenter presenter) {
        this.presenter = (AddEditContract.Presenter) presenter;
    }*/

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void showDescriptionError() {
        tilDescription.setError(getResources().getString(R.string.errorDescriptionEmpty));
    }

    @Override
    public void setValidateDependencyError() {

    }

    @Override
    public void showShortNameError() {
        tilShortName.setError(getResources().getString(R.string.errorShortNameEmpty));
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
        showMessage(getResources().getString(R.string.sucessDependency));
    }

    @Override
    public void onDetach() {
        super.onDetach();
        callback = null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    public void setPresenter (AddEditPresenter presenter){
        this.presenter = presenter;
    }
}
