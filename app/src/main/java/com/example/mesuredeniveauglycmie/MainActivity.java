package com.example.mesuredeniveauglycmie;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.EditText;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tvAge, tvResult;
    private SeekBar sbAge;
    private RadioButton rbIsFasting, rbIsNotFasting;
    private Button btnConsulter;
    private EditText etValeur;

    private void init() {
        tvAge= findViewById(R.id.tvAge);
        tvResult= findViewById(R.id.tvReponse);
        sbAge= findViewById(R.id.sbAge);
        btnConsulter= findViewById(R.id.btnConsulter);
        rbIsFasting= findViewById(R.id.rbtOui);
        rbIsNotFasting= findViewById(R.id.rbtNon);
        etValeur= findViewById(R.id.etValeur);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        sbAge.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                // affichage dans le console de Android studio pour voir les changements détectés sur le SeekBar ..
                Log.i("Information", "onProgressChanged "+progress);

                // Mise à jour du TextView par la valeur : progress à chaque changement.
                tvAge.setText("Votre age:"+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
x
        btnConsulter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i("Information", "button cliquée");
                boolean verifAge = false, verifValeur = false;
                if(sbAge.getProgress()!=0)
                    verifAge = true;
                else
                    Toast.makeText(MainActivity.this, "Veuillez saisir votre age ?", Toast.LENGTH_SHORT).show();

                if(!etValeur.getText().toString().isEmpty())
                    verifValeur = true;
                else
                    Toast.makeText(MainActivity.this, "Veuillez saisir votre valeur mesurée !", Toast.LENGTH_LONG).show();
                if(verifAge && verifValeur)
                {
                    calculer();
                }
            }
        });
    }


    public void calculer ()
    {
        int age = Integer.valueOf(sbAge.getProgress());
        float valeurMesuree = Float.valueOf(etValeur.getText().toString());
        boolean isFasting = rbIsFasting.isChecked();
        if(isFasting) {
            if (age >= 13) {
                if (valeurMesuree < 5.0)
                    tvResult.setText("Niveau de glycémie est trop bas");
                else if (valeurMesuree >= 5.0 && valeurMesuree <= 7.2)
                    tvResult.setText("Niveau de glycémie est normale");
                else
                    tvResult.setText("Niveau de glycémie est trop élevé");
            } else if (age >= 6 && age <= 12) {
                if (valeurMesuree < 5.0)
                    tvResult.setText("Niveau de glycémie est trop bas");
                else if (valeurMesuree >= 5.0 && valeurMesuree <= 10.0)
                    tvResult.setText("Niveau de glycémie est normale");
                else
                    tvResult.setText("Niveau de glycémie est trop élevé");
            } else if (age < 6) {
                if (valeurMesuree < 5.5)
                    tvResult.setText("Niveau de glycémie est trop bas");
                else if (valeurMesuree >= 5.5 && valeurMesuree <= 10.0)
                    tvResult.setText("Niveau de glycémie est normale");

                else
                    tvResult.setText("Niveau de glycémie est trop élevé");
            }
        } else {
            if (valeurMesuree > 10.5)
                tvResult.setText("Niveau de glycémie est trop élevé");
            else
                tvResult.setText("Niveau de glycémie est normale");
        }
    }
}
