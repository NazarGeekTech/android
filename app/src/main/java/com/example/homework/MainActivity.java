package com.example.homework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private EditText etName;
    private EditText etPassword;
    private Button etLogin;
    private TextView eAttemptsInfo;
    private String UserName = "Admin";
    private String Password = "987";



    boolean isValid = true;
    boolean isValid1 = true;
    private int counter = 5;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etPassword = findViewById(R.id.etPassword);
        etLogin = findViewById(R.id.ftlogin);
        eAttemptsInfo = findViewById(R.id.tneAttimplis);

        etLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String imputName = etName.getText().toString();
                String imputPassword = etPassword.getText().toString();

                if (imputName.isEmpty() || imputPassword.isEmpty()){
                    Toast.makeText(MainActivity.this, "Ведите данные", Toast.LENGTH_SHORT).show();

               }else {
                    isValid = validate(imputName);
                    isValid1 = validate1(imputPassword);
                    if (!isValid) {
                        counter--;
                        Toast.makeText(MainActivity.this,"Вы вели не правильно логин ", Toast.LENGTH_SHORT).show();
                        eAttemptsInfo.setText("Кол во остовшехся попыток " + counter);
                        if (counter == 0) {
                            etLogin.setEnabled(false);
                        }
                    }else if (!isValid1) {
                        counter --;
                        Toast.makeText(MainActivity.this, "Вы вели не правильно пароль ", Toast.LENGTH_SHORT).show();
                        eAttemptsInfo.setText("Кол во остовшехся попыток " + counter);
                        if (counter == 0) {
                            etLogin.setEnabled(false);
                        }
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Автаризация успешно ", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(MainActivity.this,tipmupActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });



    }

    private boolean validate(String name) {
        if (name.equals(UserName)) {
            return true;
        }

        return false;


    }
    private boolean validate1(String Password) {
        if (Password.equals(Password)) {
            return true;
        }

        return false;


    }


}

