package com.example.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    EditText edtText;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        edtText = findViewById(R.id.edtText);
        btnSave = findViewById(R.id.btnSave);

        // Change title bar text
        getSupportActionBar().setTitle("Edit item");

        // Finds the intent established in MainActivity and uses the key of the item we named prior
        // Then it applies that string to the field in the EditActivity
        edtText.setText(getIntent().getStringExtra(MainActivity.KEY_ITEM_TEXT));

        // Clicked when the user is done editing
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent which will contain the results
                Intent intent = new Intent(); // Empty to act as a shell to pass data

                // Pass the results
                intent.putExtra(MainActivity.KEY_ITEM_TEXT, edtText.getText().toString()); // Use the previously established key to pass data to the original intent
                intent.putExtra(MainActivity.KEY_ITEM_POSITION, getIntent().getExtras().getInt(MainActivity.KEY_ITEM_POSITION)); // Pass using the position stored via the position key

                // Set the result of the intent
                setResult(RESULT_OK, intent); // Tells the system that the process was successful

                // End activity
                finish(); // Closes activity and returns to the original intent
            }
        });
    }
}