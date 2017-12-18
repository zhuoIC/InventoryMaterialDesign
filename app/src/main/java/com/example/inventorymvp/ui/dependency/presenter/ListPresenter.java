package com.example.inventorymvp.ui.dependency.presenter;

import android.os.Bundle;

import com.example.inventorymvp.pojo.Dependency;
import com.example.inventorymvp.ui.dependency.contract.ListDependencyContract;
import com.example.inventorymvp.ui.dependency.interactor.ListDependencyInteractor;
import com.example.inventorymvp.ui.dependency.interactor.ListDependencyInteractorImpl;
import com.example.inventorymvp.ui.utils.CommonDialog;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created by usuario on 23/11/17.
 */

public class ListPresenter implements ListDependencyContract.Presenter, ListDependencyInteractor.OnLoadFinishedListener {
    private ListDependencyContract.View view;
    private ListDependencyInteractor listDependencyInteractor;

    public ListPresenter(ListDependencyContract.View view) {
        this.view = view;
        this.listDependencyInteractor = new ListDependencyInteractorImpl(this);
    }

    @Override
    public void loadDependency() {
        listDependencyInteractor.loadDependency();
    }

    /**
     * Este metodo es llamado por el interactor cuando los datos/listado  se dependencias esté lista
     * Se avisa a la vista
     * @param list
     */
    @Override
    public void onSucess(List<Dependency> list) {
        view.showDependency(list);
    }

    /**
     * Metodo que se ejecuta cuando se borra una dependencia
     */

    @Override
    public void deleteDependency(Dependency dependency){
        listDependencyInteractor.deleteDependency(dependency);
        view.updateAdapter();
        view.showDeleteMessage();

    }

    @Override
    public void onDestroy() {
        view = null;
        listDependencyInteractor = null;
    }

    @Override
    public void onAcceptDialog(Bundle bundle){
        switch (bundle.getInt(CommonDialog.TITTLE)){
            case CommonDialog.DELETE:
                deleteDependency((Dependency) bundle.getParcelable(bundle.getString()));
                break;
        }
    }

    /**
     *    Métodos que gestionan la selección mútiple de una vista
     */
    HashMap<Integer, Boolean> selection = new HashMap<>();
    @Override
    public void setNewSelection(int position) {
        selection.put(position, true);
    }

    @Override
    public void removeSelection(int position) {
        selection.remove(position);
    }

    /**
     * Método que elimina los elementos seleccionados en el mapa
     */
    @Override
    public void deleteSelection() {
    }

    @Override
    public void clearSelection() {
        selection.clear();
    }

    /**
     * Si un elemento del mapa está a true
     * @param position
     * @return
     */
    @Override
    public boolean isPositionChecked(int position) {
        return selection.get(position) != null ? true : false;
    }
}
