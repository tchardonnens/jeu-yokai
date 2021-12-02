package com.example.yokai;

public class YokaiGame {
    private int score = 0;
    private int level;
    private Board board;

    public void initGame(){
        board = new Board();

    }

    public void playGame(){

    }

    public void playTurn(){

    }

    public void show2Cards() {

    }

    public Position askCardToShow() {

        return null;
    }

    public void playCardMove() {

    }

    public YokaiCard askCardMove() {

        return null;
    }

    public boolean validateMove(YokaiCard sourceCard, Position targetPosition){

        return false;
    }

    public void useClueCard(YokaiClue yokaiClue, Position targetPosition){

    }

    public boolean askIfYokaiCalmDown(){

        return false;
    }

    public boolean isThereEnoughClueCardsLeft(){

        return false;
    }

    public void handleGameEnd() {

    }

    public int CountScore() {

        return 0;
    }

    public boolean isWinning() {

        return false;
    }

    public boolean doYouWantTORestartAnotherGame() {

        return false;
    }
}
