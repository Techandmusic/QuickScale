package com.example.quickscale;

import java.util.ArrayList;
import java.util.Map;


public class Scale {
    private Map<String, String> scaleMap;
    private ArrayList<String> newScale = new ArrayList<>();
    private String scaleString;
    private String scaleError;



    public Scale(Chromatic chromatic, int tonality) {

        scaleMap = chromatic.getChromatic();
        makeScale(tonality);
        //scaleString = "This scale is in " + scaleMap.get("root");

    }

    public String makeScale(int scaleType) {
        switch (scaleType) {
            case 0:
                //Major scale
                newScale.add(scaleMap.get("root"));
                newScale.add(scaleMap.get("majorSecond"));
                newScale.add(scaleMap.get("majorThird"));
                newScale.add(scaleMap.get("perfectFourth"));
                newScale.add(scaleMap.get("perfectFifth"));
                newScale.add(scaleMap.get("majorSixth"));
                newScale.add(scaleMap.get("majorSeventh"));
            case 1:
                //Minor scale
                newScale.add(scaleMap.get("root"));
                newScale.add(scaleMap.get("majorSecond"));
                newScale.add(scaleMap.get("minorThird"));
                newScale.add(scaleMap.get("perfectFourth"));
                newScale.add(scaleMap.get("perfectFifth"));
                newScale.add(scaleMap.get("minorSixth"));
                newScale.add(scaleMap.get("minorSeventh"));


            default:
                scaleString = "";
        }

        for (int i = 0; i < newScale.size(); ++i) {
            scaleString += newScale.get(i) +", ";
        }

        scaleString = "This is a test of the scale";


        return scaleString;
    }

    public String getScaleString() {
        return scaleString;
    }
}
