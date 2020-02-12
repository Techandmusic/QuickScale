package com.example.quickscale;

import androidx.lifecycle.ViewModel;

public class ScaleViewModel extends ViewModel {
    public String scaleNotes;

    public String getScaleNotes() {
        return scaleNotes;
    }

    public void setScaleNotes(String scaleNotes) {
        this.scaleNotes = scaleNotes;
    }
}
