package com.example.saqibandroidassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button explicitBtn;
    private EditText explicitBox;
    private TextView browserText;
    private EditText phoneBox;
    private Button phoneBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // change activity
        explicitBtn = findViewById(R.id.explicitBtn);
        explicitBox = findViewById(R.id.explicitBox);
        explicitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = explicitBox.getText().toString();

                Toast.makeText(MainActivity.this, "switching activity", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, Welcome.class);
                intent.putExtra("name", name);
                startActivity(intent);
            }
        });

        // open web browser
        browserText = findViewById(R.id.browserText);
        browserText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri webpage = Uri.parse("https://google.com");
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });


        // open dialer
        phoneBox = findViewById(R.id.phoneBox);
        phoneBtn = findViewById(R.id.phoneBtn);

        phoneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + phoneBox.getText().toString()));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
    }
}