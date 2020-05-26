package com.journaldev.androidmvvmbasics.model;

import androidx.annotation.NonNull;
import android.text.TextUtils;
import android.util.Patterns;
import com.journaldev.androidmvvmbasics.views.MainActivity;

import com.journaldev.androidmvvmbasics.views.MainActivity;

public class User {
    @NonNull
    private String mEmail;
    @NonNull
    private String mPassword;
    private static int failedAttempt = 0;
    private static int MAX_ATTEMPT = 5;

    public User(@NonNull final String email, @NonNull final String password) {
        mEmail = email;
        mPassword = password;
        failedAttempt = 0;
    }

    public static void setFailedAttempt() {
        failedAttempt++;
        if ( failedAttempt == MAX_ATTEMPT ) {
            MainActivity.DisableLogin();
        }
    }

    @NonNull
    public String getEmail() {
        return mEmail;
    }

    public void setEmail(@NonNull final String email) {
        mEmail = email;
    }

    @NonNull
    public String getPassword() {
        return mPassword;
    }

    public void setPassword(@NonNull final String password) {
        mPassword = password;
    }

    public boolean isInputDataValid() {
        return !TextUtils.isEmpty(getEmail()) && Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches() && getPassword().length() > 5;
    }
}