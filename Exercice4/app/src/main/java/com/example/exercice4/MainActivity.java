package com.example.exercice4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editTextSearch;
    Button btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextSearch = findViewById(R.id.editTextSearch);
        btnSearch = findViewById(R.id.btnSearch);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performSearch();
            }
        });
    }

    private void performSearch() {
        String query = editTextSearch.getText().toString();

        if (query.isEmpty()) {
            // Display a message or alert that the search query is empty.
        } else {
            // You can open a web browser with the search query.
            Uri searchUri = Uri.parse("https://www.google.com/search?q=" + query);
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, searchUri);
            startActivity(browserIntent);
        }
    }
}
