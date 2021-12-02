package com.example.yokai;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class GameBoardController {

    public Button playTurnButton;
    public Text textPlayer1;

    @FXML
    private void playTurn() {
        textPlayer1.setText("John");
    }
}