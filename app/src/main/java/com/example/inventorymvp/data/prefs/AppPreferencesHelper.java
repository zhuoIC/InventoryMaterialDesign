package com.example.inventorymvp.data.prefs;

import android.content.SharedPreferences;

import com.example.inventorymvp.ui.inventory.InventoryApplication;
import com.example.inventorymvp.ui.utils.AppConstants;

import static com.example.inventorymvp.ui.inventory.InventoryApplication.getContext;
import static java.security.AccessController.getContext;

/**
 * Created by usuario on 4/12/17.
 */

public class AppPreferencesHelper implements AccountPreferencesHelper, GeneralPreferencesHelper {
    /**
     * 1) Se define todas las KEY posibles del fichero de preferencias
     */
    private  static final String PREF_KEY_CURRENT_USER_ID = "pref_key_current_user_id";
    private  static final String PREF_KEY_CURRENT_USER_NAME = "pref_key_current_user_name";
    private  static final String PREF_KEY_CURRENT_USER_PASSWORD = "pref_key_current_user_password";
    private  static final String PREF_KEY_CURRENT_USER_REMEMBER = "pref_key_current_user_remember";

    // 2. Objeto para editar las preferencias
    private final SharedPreferences preferences;
    private static AppPreferencesHelper instance;

    private AppPreferencesHelper() {
        // Si es el fichero por defecto de las preferencias
        preferences = (SharedPreferences) InventoryApplication.getContext();
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
