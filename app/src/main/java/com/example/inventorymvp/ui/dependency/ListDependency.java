package com.example.inventorymvp.ui.dependency;

import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.inventorymvp.R;
import com.example.inventorymvp.adapter.DependencyAdapter;

/**
 * Created by usuario on 23/11/17.
 */

public class ListDependency extends ListFragment {
    public static final String TAG = "listdependency";

    public static Fragment newInstance(Bundle arguments) {
        ListDependency listDependency = new ListDependency();
        if(arguments != null){
            listDependency.setArguments(arguments);
        }
        return listDependency;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setListAdapter(new DependencyAdapter(getActivity()));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_listdependency, container, false);
        return rootView;
    }
}
