package com.example.quickscale;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Chromatic {
    private ArrayList<String> octave = new ArrayList<String>() {
        {
            add("C");
            add("C#/Db");
            add("D");
            add("D#/Eb");
            add("E");
            add("F");
            add("F#/Gb");
            add("G");
            add("G#/Ab");
            add("A");
            add("A#/Bb");
            add("B");
        }
    };

    private ArrayList<String> scalePositions = new ArrayList<String>() {
        {
            add("root");
            add("minorSecond");
            add("majorSecond");
            add("minorThird");
            add("majorThird");
            add("perfectFourth");
            add("flatFifth");
            add("perfectFifth");
            add("minorSixth");
            add("majorSixth");
            add("minorSeventh");
            add("majorSeventh");
        }
    };

    private ArrayList<String> newOctave;


    private Map<String, String> chromatic = new HashMap<String, String>();

    public Chromatic(String key) {
        buildOctave(key, octave);
        buildChromatic(scalePositions, newOctave);
    }

    public void buildOctave(String key, ArrayList<String> Octave) {
        while (Octave.get(0) != key) {
            toEnd();
        }
        setNewOctave(Octave);
    }

    public void toEnd() {
        String temp = octave.get(0);
        octave.remove(0);
        octave.add(temp);

    }


    public void buildChromatic(ArrayList<String> notes, ArrayList<String> positions) {
        for (int i = 0; i < newOctave.size(); ++i) {
            chromatic.put(notes.get(i), positions.get(i));
        }
    }

    public Map<String, String> getChromatic() {
        return chromatic;
    }


    public void setNewOctave(ArrayList<String> newOctave) {
        this.newOctave = newOctave;
    }
}
