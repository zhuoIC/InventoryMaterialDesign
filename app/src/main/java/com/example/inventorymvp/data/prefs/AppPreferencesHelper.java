package com.example.inventorymvp.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.inventorymvp.ui.inventory.InventoryApplication;
import com.example.inventorymvp.ui.utils.AppConstants;

/**
 * Created by usuario on 4/12/17.
 */

public class AppPreferencesHelper implements AccountPreferencesHelper, GeneralPreferencesHelper {

    public interface AppPreferencesHelperListener{
        void onSharedPreferencesChanged();
    }

    // 2. Objeto para editar las preferencias
    private final SharedPreferences preferences;
    private static AppPreferencesHelper instance;
    private SharedPreferences.OnSharedPreferenceChangeListener listener;
    private String TAG = "AppPreferencesHelper";

    private AppPreferencesHelper() {
        // Si es el fichero por defecto de las preferencias
        this.preferences = (InventoryApplication.getContext()).getSharedPreferences(AppConstants.PREF_NAME, Context.MODE_PRIVATE);
        listener = new SharedPreferences.OnSharedPreferenceChangeListener() {
            @Override
            public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

                Log.i(TAG, "onSharedPreferencesHelper: Se ha cambiado la key: " + key);
            }
        };
    }

    /**
     * Método de acceso a la instancia de la clase AppPreferencesHelper
     * @return
     */
    public static AppPreferencesHelper getInstance(){
        if(instance == null){
            instance = new AppPreferencesHelper();
        }
        return instance;
    }

    /**
     * ID SQLite
     * @return
     */
    public long getCurrentUserId() {
        return preferences.getLong(PREF_KEY_CURRENT_USER_ID, AppConstants.NULL_INDEX);
    }

    public String getCurrentUserName() {
        return preferences.getString(PREF_KEY_CURRENT_USER_NAME, null);
    }

    public String getCurrentUserPassword() {
        return preferences.getString(PREF_KEY_CURRENT_USER_PASSWORD, null);
    }

    public Boolean getCurrentUserRemember() {
        return preferences.getBoolean(PREF_KEY_CURRENT_USER_REMEMBER, false);
    }

    public void setCurrentUserId(long id) {
        preferences.edit().putLong(PREF_KEY_CURRENT_USER_ID, id).apply();
    }

    public void setCurrentUserName(String name) {
        preferences.edit().putString(PREF_KEY_CURRENT_USER_NAME, name).apply();
    }

    public void setCurrentUserPassword(String password) {
        preferences.edit().putString(PREF_KEY_CURRENT_USER_PASSWORD, password).apply();
    }

    public void setCurrentUserRemember(Boolean remember) {
        preferences.edit().putBoolean(PREF_KEY_CURRENT_USER_REMEMBER, remember).apply();
    }
}
