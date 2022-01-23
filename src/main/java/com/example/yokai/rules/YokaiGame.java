package com.example.yokai.rules;

import javafx.geometry.Pos;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class YokaiGame {
    private int score = 0;
    private int level;
    private int numberOfPlayersInGame;
    private Player[] playersInGame;
    private Player currentPlayer;
    private Queue<Player> nextPlayer = new LinkedList<>();

    public void setPlayers(Player[] players) {
        this.playersInGame = players;
        nextPlayer.addAll(List.of(playersInGame));
    }

    public Player[] getPlayers() {
        return playersInGame;
    }

    public void setNumberOfPlayersInGame(int numberOfPlayersInGame){
        this.numberOfPlayersInGame = numberOfPlayersInGame;
    }

    public int getNumberOfPlayersInGame() {
        return numberOfPlayersInGame;
    }

    public void setCurrentPlayer() {
        currentPlayer = nextPlayer.poll();
        nextPlayer.add(currentPlayer);
    }

    public Player getCurrentPlayer(){
        return currentPlayer;
    }

    public int getScore() {
        return score;
    }

    public void playGame() throws IOException {



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
        System.out.println("Playing Turn");

        YokaiCard sourceCard = askCardMove();
        Position targetPosition = new Position();
        if (!isValidMove(sourceCard, targetPosition)){
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
