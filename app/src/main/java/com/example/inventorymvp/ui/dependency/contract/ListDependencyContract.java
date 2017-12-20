package com.example.inventorymvp.ui.dependency.contract;

import android.os.Bundle;

import com.example.inventorymvp.pojo.Dependency;
import com.example.inventorymvp.ui.base.BasePresenter;
import com.example.inventorymvp.ui.base.BaseView;

import java.util.List;

/**
 * Created by usuario on 23/11/17.
 */

public interface ListDependencyContract {
    interface View extends BaseView{
        void showDependency(List<Dependency> dependencies);
        void showDeleteMessage();
        void updateAdapter();

        Dependency getDependency(int position);
    }

    interface Presenter extends BasePresenter{
        void loadDependency();
        void deleteDependency(Dependency dependency);

        void onAcceptDialog(Bundle bundle);

        void setNewSelection(int position);

        void removeSelection(int position);

        void deleteSelection();

        void clearSelection();

        boolean isPositionChecked(int position);

        void checkedActionMode();
    }
}
