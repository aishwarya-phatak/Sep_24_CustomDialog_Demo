package com.bitcode.sep_24_customdialog_demo;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnWay1,btnLogin, btnWay2,btnWay3;
    EditText edtUsername, edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initListeners();
    }

    private void initViews(){
        btnWay1 = findViewById(R.id.btnWay1);
        btnWay2 = findViewById(R.id.btnWay2);
        btnWay3 = findViewById(R.id.btnWay3);
    }

    private void initListeners() {
        //way 3
        btnWay3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginDialog loginDialog = new LoginDialog(MainActivity.this);
                loginDialog.setOnLoginListener(new MyBtnLoginListener());
                loginDialog.show();
            }
        });

        //way 2
        btnWay2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginDialog loginDialog = new LoginDialog(MainActivity.this);
                loginDialog.show();
            }
        });

        //way 1
        btnWay1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.dialog_layout);

                edtUsername = dialog.findViewById(R.id.edtUsername);
                edtPassword = dialog.findViewById(R.id.edtPassword);
                btnLogin = dialog.findViewById(R.id.btnLogin);

                btnLogin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "Login", Toast.LENGTH_LONG).show();
                    }
                });
                dialog.show();
            }
        });
    }

    class MyBtnLoginListener implements OnLoginListener{
        @Override
        public void onSuccess() {
            Intent intent = new Intent(MainActivity.this,
                                                    SecondActivity.class);
            startActivity(intent);
        }

        @Override
        public void onFailure() {
            Toast.makeText(MainActivity.this,"onFailure() method of doialog called",Toast.LENGTH_LONG).show();
        }
    }
}