package com.example.quickscale;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    String rootNote = "C";
    String testRoot = "F";
    String scaleType;
    String viewScale;
    Button btn;
    Chromatic mChromatic;
    Scale mScale;
    String clicked = "Button was clicked";
    String report;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Spinners for root note and scale type
        final Spinner noteSpinner = findViewById(R.id.note_spinner);
        Spinner scaleSpinner = findViewById(R.id.scale_spinner);
        //Creating spinner menus from ArrayAdapter
        //ArrayAdapter for notes
        ArrayAdapter<CharSequence> noteAdapter = ArrayAdapter.createFromResource(this, R.array.keys, android.R.layout.simple_spinner_item);
        noteAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //ArrayAdapter for scales
        ArrayAdapter<CharSequence> scaleAdapter = ArrayAdapter.createFromResource(this, R.array.scales, android.R.layout.simple_spinner_item);
        scaleAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting separate onItemSelectedListeners for each adapter
        //Problem is most likely in one of these
        AdapterView.OnItemSelectedListener noteListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                rootNote = (String) parent.getItemAtPosition(position);
                //mChromatic = new Chromatic(rootNote);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                rootNote = (String) parent.getItemAtPosition(0);
                //mChromatic = new Chromatic(rootNote);
            }
        };
        AdapterView.OnItemSelectedListener scaleListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //scaleType = (String) parent.getItemAtPosition(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //scaleType = (String) parent.getItemAtPosition(0);

            }
        };
        //Setting adapters and onItemSelectedListeners to spinners
        noteSpinner.setAdapter(noteAdapter);
        noteSpinner.setOnItemSelectedListener(noteListener);
        scaleSpinner.setAdapter(scaleAdapter);
        scaleSpinner.setOnItemSelectedListener(scaleListener);

        //Button assignment and onCLickListener
        btn = findViewById(R.id.scale_button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mChromatic = new Chromatic(rootNote);
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

    public String nullStringCheck(String test) {
        if (test == null) {
            report = "Scale string is null.";
        }

        else if (test == "") {
            report = "Scale string is empty";
        }

        else {
            report = "Scale string created successfully";
        }
         return report;


    }



}
