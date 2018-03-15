package com.example.inventorymvp.ui.dependency;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;



import com.example.inventorymvp.R;
import com.example.inventorymvp.ui.base.BaseActivity;
import com.example.inventorymvp.ui.dependency.presenter.AddEditPresenter;
import com.example.inventorymvp.ui.dependency.presenter.ListPresenter;
import com.example.inventorymvp.ui.dependency.view.AddEditView;
import com.example.inventorymvp.ui.dependency.view.ListView;


public class DependencyActivity extends BaseActivity implements ListView.ListDependencyListener {

    private ListView listDependency;
    private ListPresenter listPresenter;
    private AddEditView addeditView;
    private AddEditPresenter addEditPresenter;
    private Fragment detailDependency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dependency);
        FragmentManager fragmentManager = getFragmentManager();

        // 1- Se crea la vista
        listDependency = (ListView) fragmentManager.findFragmentByTag(ListView.TAG);
        if (listDependency == null) {
            listDependency = (ListView) ListView.newInstance(null);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(android.R.id.content, listDependency, ListView.TAG);
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

        addeditView = (AddEditView) fragmentManager.findFragmentByTag(AddEditView.TAG);
        if(addeditView == null){
            addeditView = (AddEditView) AddEditView.newInstance(null);
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(android.R.id.content, addeditView, AddEditView.TAG);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }

        addEditPresenter = new AddEditPresenter(addeditView);
        addeditView.setPresenter(addEditPresenter);
    }

    @Override
    public void editDependency(Bundle bundle) {
        FragmentManager fragmentManager = getFragmentManager();
        addeditView = (AddEditView) fragmentManager.
                findFragmentByTag(AddEditView.TAG);

        if (addeditView == null) {
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            addeditView = (AddEditView) AddEditView.newInstance(bundle);
            transaction.addToBackStack(null);
            transaction.replace(android.R.id.content, addeditView, AddEditView.TAG).commit();
        }

        addEditPresenter = new AddEditPresenter(addeditView);
        addeditView.setPresenter(addEditPresenter);
    }
}
