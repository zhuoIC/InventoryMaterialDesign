package com.example.inventorymvp.ui.utils;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;

import com.example.inventorymvp.R;
import com.example.inventorymvp.pojo.Dependency;
import com.example.inventorymvp.ui.dependency.contract.ListDependencyContract;

/**
 * Created by usuario on 1/12/17.
 */

public class CommonDialog {
    public static final String MESSAGE = "message";
    public static final String TITTLE = "tittle";
    public static final String DEPENDENCY = "dependency";
    public final static int DELETE = 1;

    public static Dialog showConfirmDialog(final Bundle bundle, Context context, final ListDependencyContract.Presenter presenter, final int action) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(bundle.getString(MESSAGE))
                .setTitle(bundle.getString(TITTLE))
                .setPositiveButton(R.string.btnOk, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (action) {
                            case DELETE:
                                presenter.deleteDependency((Dependency) bundle.getParcelable(DEPENDENCY));
                                break;
                        }
                    }
                })
                .setNegativeButton(R.string.btnCancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

        return builder.create();
    }
}
