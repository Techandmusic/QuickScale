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

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {



    public ScaleViewModel mViewModel;
    public String rootNote;
    public String scaleType;
    public Spinner rootNoteSpinner;
    public Spinner scaleTypeSpinner;
    public Button button;
    public Chromatic mChromatic;
    public Scale mScale;
    public TextView scaleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scaleView = findViewById(R.id.noteView);
        //Setup viewModel
        mViewModel = new  ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(ScaleViewModel.class);
        //Initialize text in mViewModel
        mViewModel.setScaleNotes("Scale appears here");
        String scale = mViewModel.getScaleNotes();
        displayScale(scale);

        //Create spinner for root note
        rootNoteSpinner = (Spinner) findViewById(R.id.note_spinner);
        //Create ArrayAdapter for rootNoteSpinner
        ArrayAdapter<CharSequence> noteAdapter = ArrayAdapter.createFromResource(this, R.array.keys, android.R.layout.simple_spinner_item);
        //Create Spinner for scale type
        scaleTypeSpinner = (Spinner) findViewById(R.id.scale_spinner);
        //Create ArrayAdapter for scaleTypeSpinner
        ArrayAdapter<CharSequence>  scaleAdapter = ArrayAdapter.createFromResource(this, R.array.scales, android.R.layout.simple_spinner_item);
        //Specify layouts to use in Spinners
        noteAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        scaleAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting OnItemSelectedListener for each Spinner
        rootNoteSpinner.setOnItemSelectedListener(this);
        scaleTypeSpinner.setOnItemSelectedListener(this);
        //Set button resource ID
        button = findViewById(R.id.scale_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mChromatic = new Chromatic(rootNote);
                mScale = new Scale(mChromatic, scaleType);


            }
        });







    }

    public void displayScale(String scales) {
        scaleView.setText(scales);
    }









    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        rootNote = rootNoteSpinner.getSelectedItem().toString();
        scaleType = scaleTypeSpinner.getSelectedItem().toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {


    }


}
