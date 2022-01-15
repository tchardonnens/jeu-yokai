package com.example.yokai;

import com.example.yokai.controllers.GameBoardController;
import com.example.yokai.controllers.GameLobbyController;
import com.example.yokai.rules.YokaiGame;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public Stage gameWindow = new Stage();
    public Stage lobbyWindow = new Stage();
    public static YokaiGame yokaiGame = new YokaiGame();


    @Override
    public void start(Stage stage) throws IOException {
        //Afficher le Lobby
        FXMLLoader lobbyLoader = new FXMLLoader();
        lobbyLoader.setLocation(getClass().getResource("game_lobby.fxml"));
        Parent lobbyRoot = lobbyLoader.load();
        GameLobbyController gameLobbyController = lobbyLoader.getController();
        Scene lobbyScene = new Scene(lobbyRoot);
        lobbyWindow.setResizable(false);
        lobbyWindow.setScene(lobbyScene);
        lobbyWindow.showAndWait();

        //Afficher la fenêtre du jeu
        FXMLLoader gameLoader = new FXMLLoader();
        gameLoader.setLocation(getClass().getResource("game_board.fxml"));
        Parent gameRoot = gameLoader.load();
        GameBoardController gameBoardController = gameLoader.getController();
        yokaiGame.setGameBoardController(gameBoardController);
        Scene gameScene = new Scene(gameRoot);
        gameWindow.setResizable(false);
        gameWindow.setScene(gameScene);
        gameWindow.show();

    }

    public static void main(String[] args) {
        launch();
    }
}