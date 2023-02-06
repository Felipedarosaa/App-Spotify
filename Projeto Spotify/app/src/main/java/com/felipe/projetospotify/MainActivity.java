package com.felipe.projetospotify;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Removendo a barra de cima
        getSupportActionBar().hide();

        Button bt_inscrever;
        bt_inscrever = findViewById(R.id.bt_inscrever);

        bt_inscrever.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), InscreverActivity.class);
                startActivity(intent);
            }
        });


        Button logar;
        logar = findViewById(R.id.entrar);

        logar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });





    }
}