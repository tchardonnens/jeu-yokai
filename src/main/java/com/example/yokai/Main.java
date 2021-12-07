package com.example.yokai;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public Stage gameWindow = new Stage();
    public Stage lobbyWindow = new Stage();
    public YokaiGame yokaiGame = new YokaiGame();
    @Override
    public void start(Stage stage) throws IOException {
        //Afficher le Lobby
        FXMLLoader lobbyLoader = new FXMLLoader();
        lobbyLoader.setLocation(getClass().getResource("game_lobby.fxml"));
        Parent lobbyRoot = lobbyLoader.load();
        GameLobbyController gameLobbyController = lobbyLoader.getController();
        gameLobbyController.setYokaiGame(yokaiGame);
        Scene lobbyScene = new Scene(lobbyRoot);
        lobbyWindow.setResizable(false);
        lobbyWindow.setScene(lobbyScene);
        lobbyWindow.showAndWait();
        //Afficher la fenêtre du jeu
        FXMLLoader gameLoader = new FXMLLoader();
        gameLoader.setLocation(getClass().getResource("game_board.fxml"));
        Parent gameRoot = gameLoader.load();
        GameBoardController.setYokaiGame(yokaiGame);
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