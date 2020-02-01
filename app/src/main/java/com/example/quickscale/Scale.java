package com.example.quickscale;

import java.util.ArrayList;
import java.util.Map;


public class Scale {
    private Map<String, String> scaleMap;
    private ArrayList<String> newScale = new ArrayList<>();
    private String scaleString;


    public Scale(Chromatic chromatic, int tonality) {

        scaleMap = chromatic.getChromatic();
        makeScale(tonality);

    }

    public String makeScale(int scaleType) {
        switch (scaleType) {
            case 1:
                //Major scale
                newScale.add(scaleMap.get("root"));
                newScale.add(scaleMap.get("majorSecond"));
                newScale.add(scaleMap.get("majorThird"));
                newScale.add(scaleMap.get("perfectFourth"));
                newScale.add(scaleMap.get("perfectFifth"));
                newScale.add(scaleMap.get("majorSixth"));
                newScale.add(scaleMap.get("majorSeventh"));

            default:
                scaleString = "";
        }

        for (int i = 0; i < newScale.size(); ++i) {
            scaleString += newScale.get(i) +", ";
        }




        return scaleString;
    }

    public String getScaleString() {
        return scaleString;
    }
}
