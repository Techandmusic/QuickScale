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
    String testRoot = "C";
    String viewScale;
    Button btn;
    TextView noteView;
    Chromatic mChromatic;
    Scale mScale;
    //This is pre testing

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.scale_button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mChromatic = new Chromatic(testRoot);
                mScale = new Scale(mChromatic, 1);
                viewScale = mScale.getScaleString();
                displayScale(viewScale);
            }
        });




    }

    public void displayScale(String scale) {
        TextView noteView = findViewById(R.id.noteView);
        noteView.setText(scale);
    }


}
