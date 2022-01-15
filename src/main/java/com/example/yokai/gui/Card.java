package com.example.yokai.gui;

import com.example.yokai.rules.Position;
import com.example.yokai.rules.YokaiCard;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Card extends Rectangle {
    private YokaiCard yokaiCard;
    private Image image;
    private boolean draggable = true;
    private String imageLocation;
    private String id;

    public Card(YokaiCard yokaiCard, String id){
        super(150,150);
        this.id = id;
        this.yokaiCard = yokaiCard;
        imageLocation = "/ressources/com/example/yokai/images"+yokaiCard.getName().toString().toLowerCase()+".png";
        super.setArcHeight(15);
        super.setArcWidth(15);
        super.setStyle("-fx-background-image: url(" + imageLocation +"); -fx-background-repeat: no-repeat;-fx-background-size: contain;");
        image = new Image(imageLocation);
        super.setFill(new ImagePattern(image));
        super.setStroke(Color.BLACK);
        super.setManaged(false);
        super.setId(id);
    }

    public boolean getDraggable() {
        return this.draggable;
    }

    public void setDraggable(boolean value) {
        this.draggable = value;
    }

}
