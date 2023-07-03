package com.nopearino.libraryapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import com.nopearino.libraryapp.databinding.FragmentStartPageBinding;

public class StartPage extends AppCompatActivity {
    private FragmentStartPageBinding binding;
    private Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentStartPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        this.btn_login = findViewById(R.id.button_login);

        btn_login.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity2.class);
            startActivity(intent);
            //onDestroy();
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