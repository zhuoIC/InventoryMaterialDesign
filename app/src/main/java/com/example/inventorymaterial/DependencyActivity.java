package com.example.inventorymaterial;

import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;


import com.example.inventorymaterial.adapter.DependencyAdapter;



// Cuando hereda de ListActivity del layout tiene que contener sí o sí un ListView con el id "@android:id/list"
public class DependencyActivity extends AppCompatActivity {

    private DependencyAdapter adapter;
    private ListView listView;
    private FloatingActionButton fab;
    private CoordinatorLayout coordinatorLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dependency);
        // CASO 1: Adapter no personalizado
        //adapter = new ArrayAdapter<Dependency>(this, android.R.layout.simple_list_item_1,
        // DependencyRepository.getInstance().getSectors());
        // CASO 2: Adapter personalizado
        listView = (ListView) findViewById(android.R.id.list) ;
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator);
        setSupportActionBar(toolbar);
        adapter = new DependencyAdapter(this);
        listView.setAdapter(adapter);

        // Al pulsar sobre el botón se visualizará el SnackBar y FAB se desplazará hacia arriba.
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(coordinatorLayout, "Ejemplo Snackbar", Snackbar.LENGTH_LONG).show();
                startActivity(new Intent(DependencyActivity.this, AddDependencyActivity.class));
            }
        });
    }
}
