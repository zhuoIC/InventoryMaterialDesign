package com.example.inventorymvp.ui.dependency;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AbsListView;

import com.example.inventorymvp.R;
import com.example.inventorymvp.ui.dependency.contract.ListDependencyContract;
import com.example.inventorymvp.ui.dependency.presenter.ListPresenter;

/**
 * Created by usuario on 18/12/17.
 */

public class DependencyMultiChoiceModeListener implements AbsListView.MultiChoiceModeListener {
    private ListDependencyContract.Presenter presenter;
    private int count;

    public DependencyMultiChoiceModeListener(ListDependencyContract.Presenter presenter){
        this.presenter = presenter;
    }

    @Override
    public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
        if(checked){
            count++;
            presenter.setNewSelection(position);
        }
        else {
            count--;
            presenter.removeSelection(position);
        }
        mode.setTitle(count+ " seleccionados");
    }

    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        MenuInflater inflater = mode.getMenuInflater();
        inflater.inflate(R.menu.menu_listdependency, menu);
        mode.setTitle("Iniciando AtionMode");
        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.action_listdependency_delete:
                presenter.deleteSelection();
                presenter.loadDependency();
                break;
        }
        mode.finish();
        return true;
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {

    }
}
