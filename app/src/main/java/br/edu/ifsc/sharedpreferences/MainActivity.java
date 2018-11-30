package br.edu.ifsc.sharedpreferences;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    Notes notes;
    EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.text = findViewById(R.id.inText);
        notes = new Notes(this.getApplicationContext());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                notes.noteSave(text.getText().toString());
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        text.setText(notes.noteREcouver());
    }
}
