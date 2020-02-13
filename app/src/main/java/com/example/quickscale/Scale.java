package com.example.quickscale;

import java.util.ArrayList;
import java.util.Map;


public class Scale {
    private Map<String, String> scaleMap;
    private ArrayList<String> newScale = new ArrayList<>();
    private String scaleString = "";


    public Scale(Chromatic chromatic, String tonality) {

        scaleMap = chromatic.getChromatic();
        makeScale(tonality);


    }

    public ArrayList<String> makeScale(String scaleType) {
        switch (scaleType) {
            case "Major":
                //Major scale
                newScale.add(scaleMap.get("root"));
                newScale.add(scaleMap.get("majorSecond"));
                newScale.add(scaleMap.get("majorThird"));
                newScale.add(scaleMap.get("perfectFourth"));
                newScale.add(scaleMap.get("perfectFifth"));
                newScale.add(scaleMap.get("majorSixth"));
                newScale.add(scaleMap.get("majorSeventh"));
                break;
            case "Minor":
                //Minor scale
                newScale.add(scaleMap.get("root"));
                newScale.add(scaleMap.get("majorSecond"));
                newScale.add(scaleMap.get("minorThird"));
                newScale.add(scaleMap.get("perfectFourth"));
                newScale.add(scaleMap.get("perfectFifth"));
                newScale.add(scaleMap.get("minorSixth"));
                newScale.add(scaleMap.get("minorSeventh"));
                break;
            case "Blues":
                //Blues scale
                newScale.add(scaleMap.get("root"));
                newScale.add(scaleMap.get("minorThird"));
                newScale.add(scaleMap.get("perfectFourth"));
                newScale.add(scaleMap.get("flatFifth"));
                newScale.add(scaleMap.get("perfectFifth"));
                newScale.add(scaleMap.get("minorSeventh"));
                break;
            case "Major Pentatonic":
                //Major Pentatonic scale
                newScale.add(scaleMap.get("root"));
                newScale.add(scaleMap.get("majorSecond"));
                newScale.add(scaleMap.get("majorThird"));
                newScale.add(scaleMap.get("perfectFifth"));
                newScale.add(scaleMap.get("majorSixth"));
                break;
            case "Minor Pentatonic":
                //Minor Pentatonic scale
                newScale.add(scaleMap.get("root"));
                newScale.add(scaleMap.get("minorThird"));
                newScale.add(scaleMap.get("perfectFourth"));
                newScale.add(scaleMap.get("perfectFifth"));
                newScale.add(scaleMap.get("minorSeventh"));
                break;
            case "Mixolydian":
                //Mixolydian mode
                newScale.add(scaleMap.get("root"));
                newScale.add(scaleMap.get("majorSecond"));
                newScale.add(scaleMap.get("majorThird"));
                newScale.add(scaleMap.get("perfectFourth"));
                newScale.add(scaleMap.get("perfectFifth"));
                newScale.add(scaleMap.get("majorSixth"));
                newScale.add(scaleMap.get("minorSeventh"));
                break;


            default:
                newScale.add(scaleMap.get("root"));
                break;

        }


        scaleToString(newScale);
        return newScale;


    }

    public String scaleToString(ArrayList<String> scale) {
        for (int i = 0; i < newScale.size(); ++i) {
            scaleString += newScale.get(i) + ", ";
        }

        return scaleString;
    }

    public String getScaleString() {
        return scaleString;
    }
}
