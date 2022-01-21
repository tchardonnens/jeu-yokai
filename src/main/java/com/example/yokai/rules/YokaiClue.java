package com.example.yokai.rules;

import java.util.ArrayList;
import java.util.List;

public class YokaiClue {
    private YokaiNameEnum.YokaiName[] allFamilies = YokaiNameEnum.YokaiName.values();
    private List<YokaiNameEnum.YokaiName> similarFamilies = new ArrayList<>();
    private Position position;
    private boolean draggable;
    private String name;

    public YokaiClue(String name) {
        this.draggable = true;
        this.name = name;
        setSimilarFamilies();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSimilarFamilies() {
        for (int i=0; i<this.name.length(); i++){
            if (Integer.parseInt(String.valueOf(name.charAt(i)))==1){
                similarFamilies.add(allFamilies[i]);
            }
        }
    }

    public List<YokaiNameEnum.YokaiName> getSimilarFamilies() {
        return similarFamilies;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public boolean isDraggable() {
        return draggable;
    }

    public void setDraggable(boolean draggable) {
        this.draggable = draggable;
    }

    public Position getPosition() {
        return this.position;
    }
}
