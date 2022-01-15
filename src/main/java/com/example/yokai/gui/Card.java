package com.example.yokai.gui;

import com.example.yokai.rules.Position;
import com.example.yokai.rules.YokaiCard;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Card extends Rectangle {
    private YokaiCard yokaiCard;
    private Image visibleImage;
    private Image hiddenImage;
    private boolean draggable;
    private String id;

    public Card(YokaiCard yokaiCard, String id) throws FileNotFoundException {
        super(80,80);
        super.setTranslateX(yokaiCard.getPosition().getX());
        super.setTranslateY(yokaiCard.getPosition().getY());
        this.id = id;
        this.yokaiCard = yokaiCard;
        this.draggable = yokaiCard.isDraggable();

        FileInputStream visibleImageLocation = new FileInputStream("src/main/resources/com/example/yokai/images/"+yokaiCard.getName().toString().toLowerCase()+".png");
        //super.setStyle("-fx-background-image: url(" + visibleImageLocation +"); -fx-background-repeat: no-repeat;-fx-background-size: contain;");
        visibleImage = new Image(visibleImageLocation);

        FileInputStream hiddenImageLocation = new FileInputStream("src/main/resources/com/example/yokai/images/dos_carte.png");
        //super.setStyle("-fx-background-image: url(" + hiddenImageLocation +"); -fx-background-repeat: no-repeat;-fx-background-size: contain;");
        hiddenImage = new Image(hiddenImageLocation);

        super.setFill(new ImagePattern(hiddenImage));
        super.setArcHeight(15);
        super.setArcWidth(15);
        super.setStroke(Color.BLACK);
        super.setId(id);
    }

    public boolean getDraggable() {
        return this.draggable;
    }

    public void setDraggable(boolean value) {
        this.draggable = value;
    }

}
