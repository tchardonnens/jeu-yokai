package com.example.yokai.rules;

public class YokaiCard {
    private YokaiNameEnum.YokaiName name;
    private Position position;
    private boolean draggable;

    public YokaiCard(YokaiNameEnum.YokaiName name, Position position){
        this.name = name;
        this.position = position;
        this.draggable = true;
    }

    public void setName(YokaiNameEnum.YokaiName name) {
        this.name = name;
    }

    public YokaiNameEnum.YokaiName getName() {
        return name;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setDraggable(boolean draggable) {
        this.draggable = false;
    }

    public boolean isDraggable() {
        return draggable;
    }
}
