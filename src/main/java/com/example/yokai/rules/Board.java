package com.example.yokai.rules;

import com.example.yokai.Main;
import com.example.yokai.controllers.GameBoardController;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Board {

    FileInputStream kitsuneImageURL;
    {
        try {
            kitsuneImageURL = new FileInputStream("src/main/resources/com/example/yokai/images/kitsune.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    FileInputStream kappaImageURL;
    {
        try {
            kappaImageURL = new FileInputStream("src/main/resources/com/example/yokai/images/kappa.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    FileInputStream rokurokubiImageURL;
    {
        try {
            rokurokubiImageURL = new FileInputStream("src/main/resources/com/example/yokai/images/rokurokubi.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    FileInputStream oniImageURL;
    {
        try {
            oniImageURL = new FileInputStream("src/main/resources/com/example/yokai/images/oni.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private final Image kitsuneImage = new Image(kitsuneImageURL);
    private final Image kappaImage = new Image(kappaImageURL);
    private final Image rokurokubiImage = new Image(rokurokubiImageURL);
    private final Image oniImage = new Image(oniImageURL);

    private final YokaiCard[] yokaiCards = new YokaiCard[16];
    private Stack<YokaiClue> yokaiClues;
    private Optional<AffinityCard> affinityCard;
    private final ArrayList<YokaiNameEnum.YokaiName> cardsPoolNames = new ArrayList<>();
    private final ArrayList<Position> cardsPoolPositions = new ArrayList<>();
    private final ImageView[] cardImageViews = new ImageView[16];

    public void setCardImageViews(int i, Image image) {
        cardImageViews[i] = new ImageView(image);
        cardImageViews[i].setX(yokaiCards[i].getPosition().getX());
        cardImageViews[i].setY(yokaiCards[i].getPosition().getY());
        cardImageViews[i].setPreserveRatio(true);
        yokaiCards[i].setImageView(cardImageViews[i]);
    }

    public void init(){
        for (int i = 0; i < 4; i++) {
            cardsPoolNames.add(YokaiNameEnum.YokaiName.KITSUNE);
            cardsPoolNames.add(YokaiNameEnum.YokaiName.ROKUROKUBI);
            cardsPoolNames.add(YokaiNameEnum.YokaiName.KAPPA);
            cardsPoolNames.add(YokaiNameEnum.YokaiName.ONI);
        }
        Collections.shuffle(cardsPoolNames);
        Position[] positions = new Position[17];
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                int index = i * j;
                positions[index] = new Position();
                positions[index].init(j * 60, i * 60);
                cardsPoolPositions.add(positions[index]);
            }
        }

        for (int i = 0; i < yokaiCards.length; i++) {
            yokaiCards[i] = new YokaiCard();
            yokaiCards[i].init(cardsPoolNames.get(i), cardsPoolPositions.get(i));
            if (yokaiCards[i].getName() == YokaiNameEnum.YokaiName.KITSUNE){
                setCardImageViews(i, kitsuneImage);
            }
            else if (yokaiCards[i].getName() == YokaiNameEnum.YokaiName.KAPPA){
                setCardImageViews(i, kappaImage);
            }
            else if (yokaiCards[i].getName() == YokaiNameEnum.YokaiName.ROKUROKUBI){
                setCardImageViews(i, rokurokubiImage);
            }
            else if (yokaiCards[i].getName() == YokaiNameEnum.YokaiName.ONI){
                setCardImageViews(i, oniImage);
            }
        }
    }

    public void display() {

        for (YokaiCard yokaiCard: yokaiCards){
            Main.gameBoardController.addCards(yokaiCard);
            System.out.println(yokaiCard.getName());
        }
    }
}
