package com.nopearino.libraryapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.nopearino.libraryapp.databinding.ActivityLoginBinding;

public class MainActivity2 extends AppCompatActivity {
    private ActivityLoginBinding binding;
    private Button btn_login;
    private EditText username;
    private EditText passwd;
    private ImageButton btn_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        this.btn_login = findViewById(R.id.btn_login);

        btn_login.setOnClickListener(v -> {
            this.username = findViewById(R.id.editTextTextEmailAddress);
            this.passwd = findViewById(R.id.editTextTextPassword);

            if(this.username.getText().toString().equals("") && this.passwd.getText().toString().equals("")) {
                Toast toast = new Toast(this);
                toast.makeText(this, "Username and password cannot be empty", Toast.LENGTH_SHORT).show();
            }else{
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                //onDestroy();
            }

        });
        
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}