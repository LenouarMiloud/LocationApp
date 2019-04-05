package com.societe.anonyme.locationsearch;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    //we declare a necessary variable
    EditText editText;
    Button btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //we relate the variable with XML File
        editText = findViewById(R.id.editSearch);
        btnSearch = findViewById(R.id.btnSearch);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //we get the input from the EditText and parse it in the Uri Variable
                Uri intentUri = Uri.parse("geo:0,0?q="+editText.getText().toString());
                //we create a intent varible for the map
                Intent mapIntent = new Intent(Intent.ACTION_VIEW,intentUri);
                // get the package from google
                mapIntent.setPackage("com.google.android.apps.maps");
                //we lunch the Activity
                startActivity(mapIntent);
            }
        });

    }
}
