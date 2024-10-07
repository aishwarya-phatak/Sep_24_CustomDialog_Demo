package com.bitcode.sep_24_customdialog_demo;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

public class LoginDialog extends Dialog {

    EditText edtUsername,edtPassword;
    Button btnLogin;

//    interface OnLoginListener{
//        void onSuccess();
//        void onFailure();
//    }

    public OnLoginListener onLoginListener;

    public void setOnLoginListener(OnLoginListener onLoginListener){
        this.onLoginListener = onLoginListener;
    }

    public LoginDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.dialog_layout);
        initViews();
        initListeners();
    }

    private void initViews(){
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
    }

    private void initListeners(){
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtUsername.getText().toString().equals("Bitcode") &&
                        (edtPassword.getText().toString().equals("Bitcode@1234"))) {
                    //way 3
                    onLoginListener.onSuccess();

                    //way 2
//                    Log.e("tag", "Login Success");
//                    dismiss();
                } else {
                    //way 3
                    onLoginListener.onFailure();

                    //way 2
//                    Log.e("tag", "login Failure");
//                    cancel();
                }
            }
        });
    }
}
