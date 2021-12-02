package com.example.yokai;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class GameLobbyController {

    public TextField nameTextField;
    public ListView playersList;

    @FXML
    private void getPlayerName() {
        nameTextField.getText();

    }
}
