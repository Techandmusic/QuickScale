package com.example.quickscale;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    String rootNote;
    public NoteViewModel mViewModel;
    Button btn;
    TextView noteView;
    Chromatic mChromatic;
    Scale mScale;
    //This is pre testing

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ViewModel instance
        mViewModel = new ViewModelProvider(this, new ViewModelProvider.Factory() {
            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                return null;
            }
        }).get(NoteViewModel.class);
        //Displays data from mViewModel
        displayScale(mViewModel.selectedScale);
        //Button onCLick listener
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mChromatic = new Chromatic(rootNote);
                mScale = new Scale(mChromatic, 1);
                mViewModel.selectedScale = mScale.getScaleString();
                displayScale(mViewModel.selectedScale);
            }
        });




    }

    public void displayScale(String scale) {
        TextView noteView = findViewById(R.id.noteView);
        noteView.setText(scale);
    }


}
