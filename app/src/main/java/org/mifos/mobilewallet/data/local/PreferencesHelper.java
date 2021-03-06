package org.mifos.mobilewallet.data.local;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import org.mifos.mobilewallet.injection.ApplicationContext;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by naman on 17/6/17.
 */

@Singleton
public class PreferencesHelper {

    private static final String TOKEN = "preferences_token";
    private static final String NAME = "preferences_name";
    private static final String USERNAME = "preferences_user_name";
    private static final String EMAIL = "preferences_email";
    private static final String CLIENT_ID = "preferences_client";
    private static final String USER_ID = "preferences_user_id";


    private SharedPreferences sharedPreferences;

    @Inject
    public PreferencesHelper(@ApplicationContext Context context) {
        this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public void clear() {
        sharedPreferences.edit().clear().apply();
    }


    public int getInt(String preferenceKey, int preferenceDefaultValue) {
        return sharedPreferences.getInt(preferenceKey, preferenceDefaultValue);
    }

    public void putInt(String preferenceKey, int preferenceValue) {
        sharedPreferences.edit().putInt(preferenceKey, preferenceValue).apply();
    }

    public long getLong(String preferenceKey, long preferenceDefaultValue) {
        return sharedPreferences.getLong(preferenceKey, preferenceDefaultValue);
    }

    public void putLong(String preferenceKey, long preferenceValue) {
        sharedPreferences.edit().putLong(preferenceKey, preferenceValue).apply();
    }

    public String getString(String preferenceKey, String preferenceDefaultValue) {
        return sharedPreferences.getString(preferenceKey, preferenceDefaultValue);
    }

    public void putString(String preferenceKey, String preferenceValue) {
        sharedPreferences.edit().putString(preferenceKey, preferenceValue).apply();
    }

    public void saveToken(String token) {
        putString(TOKEN, token);
    }

    public void clearToken() {
        putString(TOKEN, "");
    }

    public String getToken() {
        return getString(TOKEN, "");
    }

    public void saveFullName(String name) {
        putString(NAME, name);
    }

    public String getFullName() {
        return getString(NAME, "");
    }

    public void saveUsername(String name) {
        putString(USERNAME, name);
    }

    public String getUsername() {
        return getString(USERNAME, "");
    }

    public void saveEmail(String email) {
        putString(EMAIL, email);
    }

    public String getEmail() {
        return getString(EMAIL, "");
    }

    public long getUserId() {
        return getLong(USER_ID, -1);
    }

    public void setUserId(long id) {
        putLong(USER_ID, id);
    }

    public void setClientId(long clientId) {
        putLong(CLIENT_ID, clientId);
    }

    public long getClientId() {
        return getLong(CLIENT_ID, 1);
    }


}