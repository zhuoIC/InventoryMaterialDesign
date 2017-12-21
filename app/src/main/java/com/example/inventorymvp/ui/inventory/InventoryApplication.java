package com.example.inventorymvp.ui.inventory;

import android.app.Application;
import android.content.Context;

import com.example.inventorymvp.data.prefs.AppPreferencesHelper;

/**
 * Created by usuario on 25/10/17.
 */

public class InventoryApplication extends Application{

    private AppPreferencesHelper appPreferencesHelper;
    private static Context context;

    public InventoryApplication(){
        context = this;
    }

    @Override
    public void onCreate(){
        super.onCreate();
        /*
        dependencies = new ArrayList<Dependency>();
        addUser(new Dependency(1, "1º Ciclo Formativo Grado Superior", "1CFGS",
                "1CFGS Desarrollo Aplicaciones Multiplataforma"));
        addUser(new Dependency(2, "2º Ciclo Formativo Grado Superior", "2CFGS",
                "2CFGS Desarrollo Aplicaciones Multiplataforma"));*/
        appPreferencesHelper = AppPreferencesHelper.getInstance();
    }

    public AppPreferencesHelper getAppPreferencesHelper(){
        return appPreferencesHelper;
    }

    public static Context getContext(){
        return context;
    }
}
