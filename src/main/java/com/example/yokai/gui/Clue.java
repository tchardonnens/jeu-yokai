package com.example.yokai.gui;

import com.example.yokai.rules.Position;
import com.example.yokai.rules.YokaiClue;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Clue extends Rectangle {
    private YokaiClue yokaiClue;
    private Image visibleImage;
    private Image hiddenImage;
    private boolean draggable;
    private String id;

    public Clue(YokaiClue yokaiClue, String id) throws FileNotFoundException {
        super(80,80);
        super.setTranslateX(yokaiClue.getPosition().getX());
        super.setTranslateY(yokaiClue.getPosition().getY());
        this.id = id;
        this.yokaiClue = yokaiClue;
        this.draggable = yokaiClue.isDraggable();

        FileInputStream visibleImageLocation;

        switch (yokaiClue.getSimilarFamilies().size()){
            case 1:
                visibleImageLocation = new FileInputStream("src/main/resources/com/example/yokai/images/clues/1_color/"+yokaiClue.getName()+".png");
                break;
            case 2:
                visibleImageLocation = new FileInputStream("src/main/resources/com/example/yokai/images/clues/2_colors/"+yokaiClue.getName()+".png");
                break;
            case 3:
                visibleImageLocation = new FileInputStream("src/main/resources/com/example/yokai/images/clues/3_colors/"+yokaiClue.getName()+".png");
                break;
            default:
                visibleImageLocation = new FileInputStream("src/main/resources/com/example/yokai/images/dos_carte.png");
                break;
        }


        //super.setStyle("-fx-background-image: url(" + visibleImageLocation +"); -fx-background-repeat: no-repeat;-fx-background-size: contain;");
        visibleImage = new Image(visibleImageLocation);

        FileInputStream hiddenImageLocation = new FileInputStream("src/main/resources/com/example/yokai/images/dos_indice.png");
        //super.setStyle("-fx-background-image: url(" + hiddenImageLocation +"); -fx-background-repeat: no-repeat;-fx-background-size: contain;");
        hiddenImage = new Image(hiddenImageLocation);

        super.setFill(new ImagePattern(visibleImage));
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
