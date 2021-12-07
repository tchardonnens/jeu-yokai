package com.example.yokai;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class GameLobbyController {

    public YokaiGame yokaiGame;
    public Label player1Label;
    public Label player2Label;
    public Label player3Label;
    public Label player4Label;
    public TextField nameTextField1;
    public TextField nameTextField2;
    public TextField nameTextField3;
    public TextField nameTextField4;
    public ToggleGroup numberOfPlayersRadioGroup;
    int numberOfPlayers = 0;

    public void setYokaiGame(YokaiGame yokaiGame){
        this.yokaiGame = yokaiGame;
    }

    private void showEditable(Label playerLabel, TextField nameTextField) {
        playerLabel.setVisible(true);
        nameTextField.setVisible(true);
    }

    private void hideEditable(Label playerLabel, TextField nameTextField) {
        playerLabel.setVisible(false);
        nameTextField.setVisible(false);
    }

    @FXML
    private void getNumberOfPlayers() {
        RadioButton selectedRadioButton = (RadioButton) numberOfPlayersRadioGroup.getSelectedToggle();
        String toggleGroupValue = selectedRadioButton.getText();
        int toggleValue = Integer.parseInt(toggleGroupValue);
        switch (toggleValue) {
            case 2:
                hideEditable(player3Label, nameTextField3);
                hideEditable(player4Label, nameTextField4);
                numberOfPlayers = toggleValue;
                break;
            case 3:
                showEditable(player3Label, nameTextField3);
                hideEditable(player4Label, nameTextField4);
                numberOfPlayers = toggleValue;
                break;
            case 4:
                showEditable(player3Label, nameTextField3);
                showEditable(player4Label, nameTextField4);
                numberOfPlayers = toggleValue;
                break;
        }
    }

    @FXML
    private void startGame(ActionEvent actionEvent) throws IOException {
        ArrayList<String> playersName = new ArrayList<>();
        playersName.add(nameTextField1.getText());
        playersName.add(nameTextField2.getText());
        playersName.add(nameTextField3.getText());
        playersName.add(nameTextField4.getText());
        Player[] players = new Player[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++) {
            players[i] = new Player();
            players[i].init(playersName.get(i), null);
        }

        yokaiGame.setPlayers(players, numberOfPlayers);

        //Fermer la fenêtre du lobby
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
}
