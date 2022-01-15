package com.example.yokai.controllers;

import com.example.yokai.Main;
import com.example.yokai.rules.YokaiCard;
import com.example.yokai.rules.YokaiGame;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

import java.io.IOException;

public class GameBoardController {

    private static YokaiGame yokaiGame;
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

    public static void setYokaiGame(YokaiGame yokaiGameFromMain){
        yokaiGame = yokaiGameFromMain;
    }

    public void addCards(YokaiCard yokaiCard) {
        boardPane.getChildren().add(yokaiCard.getImageView());
    }

    public void hidePlayers(Text textPlayer, Circle iconPlayer) {
        textPlayer.setVisible(false);
        iconPlayer.setVisible(false);
    }

    @FXML
    public void initialize() throws IOException {
        setYokaiGame(Main.yokaiGame);
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
        yokaiGame.initGame();


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