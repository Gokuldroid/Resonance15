package com.ecea.resonance15.Utlis;

/**
 * Created by goku on 27-08-2015.
 */
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by ashokkumar on 29/07/15.
 */
public class PreferenceHelper {
    private static final String PREF_NAME = "daimaler";


    private static PreferenceHelper sInstance;
    private final SharedPreferences mPref;

    public PreferenceHelper(Context context) {
        mPref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public static synchronized void initializeInstance(Context context) {
        if (sInstance == null) {
            sInstance = new PreferenceHelper(context);
        }
    }

    public static synchronized PreferenceHelper getInstance() {
        if (sInstance == null) {
            throw new IllegalStateException(PreferenceHelper.class.getSimpleName() +
                    " is not initialized, call initializeInstance(..) method first.");
        }
        return sInstance;
    }

    public void setLong(String KEY_VALUE,long value) {
        mPref.edit()
                .putLong(KEY_VALUE, value)
                .commit();
    }

    public long getLong(String KEY_VALUE) {
        return mPref.getLong(KEY_VALUE, 0);
    }

    public void setString(String KEY_VALUE,String value) {
        mPref.edit()
                .putString(KEY_VALUE, value)
                .commit();
    }

    public String getString(String KEY_VALUE) {
        return mPref.getString(KEY_VALUE+"","");
    }

    public void setBoolean(String KEY_VALUE,boolean value) {
        mPref.edit()
                .putBoolean(KEY_VALUE, value)
                .commit();
    }

    public boolean getBoolean(String KEY_VALUE) {
        return mPref.getBoolean(KEY_VALUE, false);
    }
    public void remove(String key) {
        mPref.edit()
                .remove(key)
                .commit();
    }

    public boolean clear() {
        return mPref.edit()
                .clear()
                .commit();
    }


}

