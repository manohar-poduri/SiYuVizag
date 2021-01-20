/*
Updated by Sirisha Balireddy on 20-05-2019
 */
/*
this entirely takes care of the change in the app language
 */
package com.alcove.partners.siyu;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.res.Configuration;

import java.util.Locale;

public class locale extends Application {
    public void setLocale(String lang)
    {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale=locale;
        getBaseContext().getResources().updateConfiguration(config,getBaseContext().getResources().getDisplayMetrics());
        SharedPreferences.Editor editor =getSharedPreferences("Settings",MODE_PRIVATE).edit();
        editor.putString("MyLanguage",lang);
        editor.apply();

    }
    public void loadLocale()
    {
        SharedPreferences pref = getSharedPreferences("Settings",MODE_PRIVATE);
        String language =pref.getString("MyLanguage","");
        setLocale(language);
    }
}
