package com.example.inventorymvp.ui.dependency;

/**
 * Created by usuario on 23/11/17.
 */

public interface AddEditContract {
    interface View{
        void setPresenter(AddEditContract.Presenter presenter);

    }

    interface Presenter{
    }
}
