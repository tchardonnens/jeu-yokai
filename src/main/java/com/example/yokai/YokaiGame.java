package com.example.yokai;

import java.io.IOException;

public class YokaiGame {
    private int score = 0;
    private int level;
    private Board board;
    private int numberOfPlayersInGame = 0;
    private Player[] playersInGame;

    private GameBoardController controller;

    public void setGameBoardController(GameBoardController gameBoardController) {
        this.controller = gameBoardController;
    }

    public void setPlayers(Player[] players, int numberOfPlayers) {
        this.playersInGame = players;
        this.numberOfPlayersInGame = numberOfPlayers;
    }

    public void initGame(){
        board = new Board();
        board.init(this.controller);
    }

    public Player[] getPlayers() {
        return playersInGame;
    }

    public int getNumberOfPlayersInGame() {
        return numberOfPlayersInGame;
    }

    public int getScore() {
        return score;
    }

    public void playGame() throws IOException {
        initGame();
        board.display();
        /*String saisie = null;
        do{
            if (saisie.equals("playTurn")){
                playTurn();
            }
            else if (saisie.equals("askIfYokaiCalmDown")){
                askIfYokaiCalmDown();
                break;
            }
        } while(isEnoughClueCardsLeft());
        handleGameEnd();*/
    }

    public void playTurn(){
        Position position1 = askCardToShow();
        Position position2 = askCardToShow();
        show2Cards(position1, position2);

        YokaiCard sourceCard = askCardMove();
        Position targetPosition = new Position();
        while (!isValidMove(sourceCard, targetPosition)){
            playCardMove();
        }
        //To continue with clues cards
    }

    public void show2Cards(Position position1, Position position2) {

    }

    public Position askCardToShow() {

        return null;
    }

    public void playCardMove() {

    }

    public YokaiCard askCardMove() {

        return null;
    }

    public boolean isValidMove(YokaiCard sourceCard, Position targetPosition){

        return false;
    }

    public void useClueCard(YokaiClue yokaiClue, Position targetPosition){

    }

    public boolean askIfYokaiCalmDown(){

        return false;
    }

    public boolean isEnoughClueCardsLeft(){

        return false;
    }

    public void handleGameEnd() {
        if (isWinning()){
            this.score = countScore();
        }
        doYouWantToRestartAnotherGame();
    }

    public int countScore() {

        return 0;
    }

    public boolean isWinning() {

        return true;
    }

    public boolean doYouWantToRestartAnotherGame() {

        return true;
    }
}
