package com.example.quickscale;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Chromatic {
    private ArrayList<String> octave = new ArrayList<String>() {
        {
            add("C");
            add("C#");
            add("D");
            add("D#");
            add("E");
            add("F");
            add("G");
            add("G#");
            add("A");
            add("Bb");
            add("B");
            add("B#");
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

    private String key;
    private String note;
    private Map<String, String> chromatic = new HashMap<String, String>();

    public Chromatic(String key) {
        this.key = key;
        buildOctave(key);
        buildChromatic(scalePositions, octave);
    }

    public ArrayList<String> buildOctave(String key) {
        while (octave.get(0) != key) {
            toEnd();
        }
        return octave;
    }

    public void toEnd() {
        String temp = octave.get(0);
        octave.remove(0);
        octave.add(temp);

    }

    public String getNote(int position) {
        note = octave.get(position);
        return note;
    }

    public void buildChromatic(ArrayList<String> notes, ArrayList<String> positions) {
        for (int i = 0; i < octave.size(); ++i) {
            chromatic.put(notes.get(i), positions.get(i));
        }
    }

    public Map<String, String> getChromatic() {
        return chromatic;
    }


}
