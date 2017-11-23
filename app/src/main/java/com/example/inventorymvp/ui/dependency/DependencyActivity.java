package com.example.inventorymvp.ui.dependency;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;


import com.example.inventorymvp.R;
import com.example.inventorymvp.adapter.DependencyAdapter;


public class DependencyActivity extends AppCompatActivity {

    private Fragment listDependency;
    private Fragment addeditDependency;
    private Fragment detailDependency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dependency);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        listDependency = fragmentManager.findFragmentByTag(ListDependency.TAG);
        if (listDependency == null){
            listDependency = ListDependency.newInstance(null);
            fragmentTransaction.add(android.R.id.content, listDependency);
            fragmentTransaction.commit();
        }
    }
}
