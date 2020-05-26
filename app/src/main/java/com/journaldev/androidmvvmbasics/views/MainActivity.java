package com.journaldev.androidmvvmbasics.views;


import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.os.Handler;


import com.journaldev.androidmvvmbasics.R;
import com.journaldev.androidmvvmbasics.databinding.ActivityMainBinding;
import com.journaldev.androidmvvmbasics.model.User;
import com.journaldev.androidmvvmbasics.viewmodels.LoginViewModel;


public class MainActivity extends AppCompatActivity {

    private static String success_m = "Login was successful";
    private static String error_m = "Email or Password not valid";
    private static String message_w = "MAX ATTEMPT reached!";
    public static Context baseContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setViewModel(new LoginViewModel());
        activityMainBinding.executePendingBindings();

        baseContext = getBaseContext();

        new Handler().postDelayed(new Runnable() {
            public void run() {
                // do something..
            }
        }, 100);

    }

    public static void DisableLogin() {
        Toast.makeText(baseContext, message_w, Toast.LENGTH_SHORT).show();
    }

    @BindingAdapter({"toastMessage"})
    public static void runMe(View view, String message) {
        if (message != null) {

            if ( message.equals(error_m)) {
                User.setFailedAttempt();
            }
            Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show();
        }
    }
}
