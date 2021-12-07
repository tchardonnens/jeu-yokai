package com.example.yokai;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

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

    public static void setYokaiGame(YokaiGame yokaiGameParam){
        yokaiGame = yokaiGameParam;
    }

    public void addCards(YokaiCard yokaiCard) {
        boardPane.getChildren().add(yokaiCard.getImageView());
    }

    public void hidePlayers(Text textPlayer, Circle iconPlayer) {
        textPlayer.setVisible(false);
        iconPlayer.setVisible(false);
    }

    @FXML
    public void initialize() {
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