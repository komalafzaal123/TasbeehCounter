package com.example.tasbeehcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    EditText kalmaInput, daroodInput, astagfarInput;
    Button btnSave, btnCommit,btnShow;
    DbHelper db;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kalmaInput = findViewById(R.id.Kalma);
        daroodInput = findViewById(R.id.Darood);
        astagfarInput = findViewById(R.id.Astgafar);
        btnSave = findViewById(R.id.btn_save);

        db = new DbHelper(this);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kalma = kalmaInput.getText().toString();
                String darood = daroodInput.getText().toString();
                String astagfar = astagfarInput.getText().toString();
                String date = String.valueOf(new Date());
                if (kalma.isEmpty() || darood.isEmpty() || astagfar.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter 0 for null", Toast.LENGTH_SHORT).show();
                    return;
                }

                boolean recited;
                if (kalma == "0" && astagfar == "0" && darood == "0") {
                    recited = false;

                } else {
                    recited = true;
                }
                Counter c = new Counter(kalma, darood, astagfar, recited, date);
                db.saveData(c);
            }
        });
        btnCommit = findViewById(R.id.btn_commit);
        btnCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToUrl("https://github.com/komalafzaal123/QuizApp/commits/main");
            }

            private void goToUrl(String url) {
                Uri uriUrl = Uri.parse(url);
                Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                startActivity(launchBrowser);
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(this, show.class);
                startActivity(intent);
            }
        });
    }
}