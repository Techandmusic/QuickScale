package com.example.quickscale;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String rootNote;
    String testRoot = "D";
    int scaleType;
    String viewScale;
    Button btn;
    Chromatic mChromatic;
    Scale mScale;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Spinners for root note and scale type
        Spinner noteSpinner = findViewById(R.id.note_spinner);
        Spinner scaleSpinner = findViewById(R.id.scale_spinner);
        //Creating spinner menus from ArrayAdapter
        ArrayAdapter<CharSequence> noteAdapter = ArrayAdapter.createFromResource(this, R.array.keys, android.R.layout.simple_spinner_item);
        noteAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<CharSequence> scaleAdapter = ArrayAdapter.createFromResource(this, R.array.scales, android.R.layout.simple_spinner_item);
        scaleAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting adapters and onItemSelectedListeners to spinners
        noteSpinner.setAdapter(noteAdapter);
        noteSpinner.setOnItemSelectedListener(this);
        scaleSpinner.setAdapter(scaleAdapter);
        scaleSpinner.setOnItemSelectedListener(this);

        //Button assignment and onCLickListener
        btn = findViewById(R.id.scale_button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //clearScale();
                mChromatic = new Chromatic(testRoot);
                mScale = new Scale(mChromatic, scaleType);
                viewScale = mScale.getScaleString();
                displayScale(viewScale);
            }
        });




    }

    public void displayScale(String scale) {
        TextView noteView = findViewById(R.id.noteView);
        noteView.setText(scale);
    }

    public void clearScale() {
        TextView noteView = findViewById(R.id.noteView);
        noteView.setText("");
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        rootNote = (String) parent.getItemAtPosition(position);
        scaleType = position;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        rootNote = "C";
        scaleType = 1;
    }
}
