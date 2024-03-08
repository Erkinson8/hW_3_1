package com.example.hw_3_1;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.material.button.MaterialButton;


public class MainActivity extends AppCompatActivity {

    MaterialButton button;
    EditText mail, theme, text;


    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mail = findViewById(R.id.text1);
        theme = findViewById(R.id.text2);
        text = findViewById(R.id.text3);
        button = findViewById(R.id.button);

        button.setOnClickListener(view -> {
            String subject, body, toEmail;
            subject = theme.getText().toString();
            body = text.getText().toString();
            toEmail = mail.getText().toString();
            if (subject.equals("") && toEmail.equals("")) {
                Toast.makeText(MainActivity.this, "Введите данные ", Toast.LENGTH_SHORT).show();
            } else {
                sendEmail(subject, body, toEmail);
            }
        });
    }

    public void sendEmail (String subject,String body,String toEmail){

        Intent intent = new Intent(Intent.ACTION_SEND);

        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{toEmail});
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, body);

        intent.setType("message/rfc822");

        startActivity(Intent.createChooser(intent, "Choose an Email client:"));


    }
}