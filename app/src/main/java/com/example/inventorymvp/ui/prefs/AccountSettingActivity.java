package com.example.inventorymvp.ui.prefs;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import com.example.inventorymvp.R;

public class AccountSettingActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.account_setting);
    }
}
