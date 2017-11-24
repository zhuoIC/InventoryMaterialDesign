package com.example.inventorymvp.ui.dependency;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.inventorymvp.R;
import com.example.inventorymvp.adapter.DependencyAdapter;
import com.example.inventorymvp.ui.base.BasePresenter;

/**
 * Created by usuario on 23/11/17.
 */

public class ListDependency extends ListFragment implements ListDependencyContract.View{
    public static final String TAG = "listdependency";
    private ListDependencyContract.Presenter presenter;
    private ListDependencyListener callback;

    interface ListDependencyListener{
        void addNewDependency();
    }

    public static ListFragment newInstance(Bundle arguments) {
        ListDependency listDependency = new ListDependency();
        if(arguments != null){
            listDependency.setArguments(arguments);
        }
        return listDependency;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            callback = (ListDependencyListener) activity;
        }
        catch (ClassCastException e){
            throw new ClassCastException(activity.toString() + " must be implements " +
                    "LisDependencyListener");
        }
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
        // Como se encuentra en el fragment usamos rootView
        FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.fab);
        // Si el floatingActionButton se encontrara en el xml de la activity
        //FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.addNewDependency();
            }
        });
        return rootView;
    }

    @Override
    public void setPresenter(BasePresenter presenter) {
        this.presenter = (ListDependencyContract.Presenter) presenter;
    }
}
