package com.example.android1.devicelocation;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class PrefsActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.prefs);


///////to get data from shared preference
//        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(PrefsActivity.this);
//        String username = prefs.getString("username", "Default NickName");
//        String passw = prefs.getString("password", "Default Password");
//        boolean checkBox = prefs.getBoolean("checkBox", false);
//        String listPrefs = prefs.getString("listpref", "Default list prefs");

    }
}
