package com.example.inventorymaterial;

import android.app.Application;
import android.widget.ArrayAdapter;

import com.example.inventorymaterial.pojo.Dependency;
import com.example.inventorymaterial.repository.DependencyRepository;

import java.util.ArrayList;

/**
 * Created by usuario on 25/10/17.
 */

public class InventoryApplication extends Application{

    @Override
    public void onCreate(){
        super.onCreate();
        /*
        dependencies = new ArrayList<Dependency>();
        addSector(new Dependency(1, "1º Ciclo Formativo Grado Superior", "1CFGS",
                "1CFGS Desarrollo Aplicaciones Multiplataforma"));
        addSector(new Dependency(2, "2º Ciclo Formativo Grado Superior", "2CFGS",
                "2CFGS Desarrollo Aplicaciones Multiplataforma"));*/
    }

    public InventoryApplication(){

    }

}
