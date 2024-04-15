package com.example.mesuredeniveauglycmie.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mesuredeniveauglycmie.R;

public class HomeActivity extends AppCompatActivity {
    private Button btnConsultation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        init();

        btnConsultation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this ,MainActivity.class);
                //page d'acceuil sans retoure
                startActivity(intent);
                //distriction mode de processus
                finish();
            }
        });
    }

    private void init() {
        btnConsultation = findViewById(R.id.btnConsultation);
    }
}