package com.example.bkakran.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {

    EditText saveText;
    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        String text = getIntent().getStringExtra("value");
        position = getIntent().getIntExtra("position", 0);
        saveText = (EditText) findViewById(R.id.saveText);
        saveText.setText(text);
        saveText.setSelection(saveText.getText().length());
    }

    public void onSubmit(View v) {
        // closes the activity and returns to first screen
        // Prepare data intent
        Intent data = new Intent();
        // Pass relevant data back as a result
        data.putExtra("value", saveText.getText().toString());
        data.putExtra("position", position);
        setResult(RESULT_OK, data);
        finish();
    }
}
