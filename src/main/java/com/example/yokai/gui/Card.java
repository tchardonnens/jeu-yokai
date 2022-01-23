package com.example.yokai.gui;

import com.example.yokai.rules.Position;
import com.example.yokai.rules.YokaiCard;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
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
    private boolean isHidden = true;
    private boolean isStuck = false;

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
        /*//Creating the mouse event handler
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                System.out.println(id + " card clicked, position is : " + yokaiCard.getPosition().getX()+ ", " + yokaiCard.getPosition().getY());
            }
        };
        //Registering the event filter
        super.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);*/
    }

    public boolean getDraggable() {
        return this.draggable;
    }

    public void setDraggable(boolean value) {
        this.draggable = value;
    }

    public void flipCard(){
        if (isHidden){
            super.setFill(new ImagePattern(visibleImage));
            isHidden = false;
        }
        else {
            super.setFill(new ImagePattern(hiddenImage));
            isHidden = true;
        }
    }

    public YokaiCard getYokaiCard() {
        return yokaiCard;
    }



}
