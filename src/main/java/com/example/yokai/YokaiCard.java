package com.example.yokai;

public class YokaiCard {
    private YokaiNameEnum name;
    private Position position;

    public void init(YokaiNameEnum.YokaiName name, Position position){
        this.name = name;
        this.position = position;
    }

    public void setName(YokaiNameEnum.YokaiName name) {
        this.name = name;
    }

    public YokaiNameEnum getName() {
        return name;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }
}
