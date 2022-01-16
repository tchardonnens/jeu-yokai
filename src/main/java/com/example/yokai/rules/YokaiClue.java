package com.example.yokai.rules;

import java.util.List;

public class YokaiClue {
    private List<YokaiNameEnum> similarFamilies;
    private Position position;
    private boolean draggable;
    private String name;

    public YokaiClue() {
        this.draggable = true;

    }

    public List<YokaiNameEnum> getSimilarFamilies() {
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
