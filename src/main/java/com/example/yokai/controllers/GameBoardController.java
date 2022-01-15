package com.example.yokai.controllers;

import com.example.yokai.gui.Card;
import com.example.yokai.rules.Board;
import com.example.yokai.rules.YokaiCard;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

import java.io.FileNotFoundException;
import java.io.IOException;

import static com.example.yokai.Main.yokaiGame;

public class GameBoardController {

    public Pane boardPane;
    public Button playTurnButton;
    public Button calmedDownButton;
    public Text textPlayer1;
    public Text textPlayer2;
    public Text textPlayer3;
    public Text textPlayer4;
    public Circle iconPlayer1;
    public Circle iconPlayer2;
    public Circle iconPlayer3;
    public Circle iconPlayer4;

    private YokaiCard tempCard;

    private double oldX;
    private double oldY;

    private double mouseX;
    private double mouseY;

    private Group group = new Group();
    private Card[] cards = new Card[16];
    private Board board = new Board();

    public void addCardsToBoard() throws FileNotFoundException {
        YokaiCard[] yokaiCards = board.setYokaiCards();
        int i = 0;
        for (YokaiCard yokaiCard : yokaiCards){
            String cardID = "card"+i;
            cards[i] = new Card(yokaiCard, cardID);
            boardPane.setVisible(true);
            boardPane.getChildren().add(cards[i]);
            i+=1;
        }
        boardPane.setTranslateX(boardPane.getPrefWidth()/8);
        boardPane.setTranslateY(boardPane.getPrefHeight()/1200);
    }

    public void hidePlayers(Text textPlayer, Circle iconPlayer) {
        textPlayer.setVisible(false);
        iconPlayer.setVisible(false);
    }

    @FXML
    public void initialize() throws IOException {
        switch (yokaiGame.getNumberOfPlayersInGame()) {
            case 2 -> {
                textPlayer1.setText((yokaiGame.getPlayers()[0].getName()));
                textPlayer2.setText((yokaiGame.getPlayers()[1].getName()));
                hidePlayers(textPlayer3, iconPlayer3);
                hidePlayers(textPlayer4, iconPlayer4);
            }
            case 3 -> {
                textPlayer1.setText((yokaiGame.getPlayers()[0].getName()));
                textPlayer2.setText((yokaiGame.getPlayers()[1].getName()));
                textPlayer3.setText((yokaiGame.getPlayers()[2].getName()));
                hidePlayers(textPlayer4, iconPlayer4);
            }
            case 4 -> {
                textPlayer1.setText((yokaiGame.getPlayers()[0].getName()));
                textPlayer2.setText((yokaiGame.getPlayers()[1].getName()));
                textPlayer3.setText((yokaiGame.getPlayers()[2].getName()));
                textPlayer4.setText((yokaiGame.getPlayers()[3].getName()));
            }
        }
        addCardsToBoard();
        yokaiGame.playGame();

    }

    @FXML
    private void playTurn() {
        yokaiGame.playTurn();
    }

    @FXML
    private void calmDown() {
        yokaiGame.askIfYokaiCalmDown();
    }

}