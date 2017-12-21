package com.example.inventorymvp.ui.dependency;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;



import com.example.inventorymvp.R;
import com.example.inventorymvp.ui.base.BaseActivity;
import com.example.inventorymvp.ui.dependency.presenter.AddEditPresenter;
import com.example.inventorymvp.ui.dependency.presenter.ListPresenter;


public class DependencyActivity extends BaseActivity implements ListDependency.ListDependencyListener{

    private ListDependency listDependency;
    private ListPresenter listPresenter;
    private AddEditDependency addeditDependency;
    private AddEditPresenter addEditPresenter;
    private Fragment detailDependency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dependency);
        FragmentManager fragmentManager = getFragmentManager();

        // 1- Se crea la vista
        listDependency = (ListDependency) fragmentManager.findFragmentByTag(ListDependency.TAG);
        if (listDependency == null) {
            listDependency = (ListDependency) ListDependency.newInstance(null);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(android.R.id.content, listDependency, ListDependency.TAG);
            fragmentTransaction.commit();
        }

        // 2- Se crea el presentador y se le pasa en el constructor la vista correspondiente
        //listPresenter = new ListPresenter(listDependency);

        // 3- Si necesitamos se asigna el presentador a su fragment
        listDependency.setPresenter(listPresenter);
    }

    /**
     * Método que se ejecuta cuando se añade una dependencia
     */
    @Override
    public void addNewDependency() {
        FragmentManager fragmentManager = getFragmentManager();

        addeditDependency = (AddEditDependency) fragmentManager.findFragmentByTag(AddEditDependency.TAG);
        if(addeditDependency == null){
            addeditDependency = (AddEditDependency) AddEditDependency.newInstance(null);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(android.R.id.content, addeditDependency, AddEditDependency.TAG);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }

        addEditPresenter = new AddEditPresenter(addeditDependency);
        addeditDependency.setPresenter(addEditPresenter);
    }

    @Override
    public void editDependency(Bundle bundle) {
        FragmentManager fragmentManager = getFragmentManager();
        addeditDependency = (AddEditDependency) fragmentManager.
                findFragmentByTag(AddEditDependency.TAG);

        if (addeditDependency == null) {
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            addeditDependency = (AddEditDependency) AddEditDependency.newInstance(bundle);
            transaction.addToBackStack(null);
            transaction.replace(android.R.id.content, addeditDependency, AddEditDependency.TAG).commit();
        }

        addEditPresenter = new AddEditPresenter(addeditDependency);
        addeditDependency.setPresenter(addEditPresenter);
    }
}
