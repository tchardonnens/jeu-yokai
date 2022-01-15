package com.example.yokai.rules;

import javafx.scene.image.ImageView;

public class YokaiCard {
    private YokaiNameEnum.YokaiName name;
    private Position position;
    private ImageView imageView;

    public void init(YokaiNameEnum.YokaiName name, Position position){
        this.name = name;
        this.position = position;
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

    public void setImageView(ImageView imageView){
        this.imageView = imageView;
    }

    public ImageView getImageView() {
        return imageView;
    }
}
