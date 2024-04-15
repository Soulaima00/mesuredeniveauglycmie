package com.example.mesuredeniveauglycmie.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.mesuredeniveauglycmie.R;

public class ConsultActivity extends AppCompatActivity {
    private TextView tvReponse ;
    private Button btnRetour;
    private String reponse ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consult);

        init();
    }
    private void init() {
        tvReponse = findViewById(R.id.tvReponse);
        btnRetour = findViewById(R.id.btnRetour);
    }
}