package com.example.yokai.rules;

import javafx.geometry.Pos;

import java.io.IOException;
import java.util.HashMap;
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

    public boolean isValidMove(YokaiCard[] yokaiCards, YokaiCard sourceCard, Position tempPosition){
        boolean isValid = true;

        HashMap<Integer, YokaiCard> cardsOnBoardX = new HashMap<>();
        HashMap<Integer, YokaiCard> cardsOnBoardY = new HashMap<>();

        sourceCard.setPosition(tempPosition);

        for (YokaiCard yokaiCard : yokaiCards){
            cardsOnBoardX.put(yokaiCard.getPosition().getX(), yokaiCard);
            cardsOnBoardY.put(yokaiCard.getPosition().getX(), yokaiCard);
        }

        // Test the new spot
        Position alignedPosition = alignOnGrid(tempPosition);
        int cardTestedX = tempPosition.getX();
        int cardTestedY = tempPosition.getY();
        boolean isCardAlreadyOnBoard = (cardsOnBoardX.containsKey(cardTestedX) && cardsOnBoardY.containsKey(cardTestedY));
        boolean isSameSpot = (sourceCard.getPosition().getX() == cardTestedX && sourceCard.getPosition().getY() == cardTestedY);

        for (YokaiCard yokaiCard : yokaiCards){
            System.out.println("X : " + yokaiCard.getPosition().getX() + " and Y : " + yokaiCard.getPosition().getY());

        }
        System.out.println("========================");

        if (!isCardAlreadyOnBoard && !isSameSpot) {
            for (YokaiCard yokaiCard : yokaiCards){
                boolean right = cardsOnBoardX.containsKey(yokaiCard.getPosition().getX()+100);
                boolean left = cardsOnBoardX.containsKey(yokaiCard.getPosition().getX()-100);
                boolean down = cardsOnBoardY.containsKey(yokaiCard.getPosition().getY()+100);
                boolean up = cardsOnBoardY.containsKey(yokaiCard.getPosition().getY()-100);
                if (!right && !left && !down && !up){
                    isValid = false;
                    //System.out.println("false for card at X: " + yokaiCard.getPosition().getX() + " and Y: " + yokaiCard.getPosition().getY());
                    break;
                }
            }
        }
        else {
            isValid = false;
        }
        return isValid;
    }

    public void useClueCard(YokaiClue yokaiClue, Position targetPosition){

    }

    public Position alignOnGrid(Position position){
        int cardTestedX = position.getX();
        int cardTestedY = position.getY();

        final int halfCardSize = 40;

        // Add half the size of the card image to get the center of the card
        cardTestedX += halfCardSize;
        cardTestedY += halfCardSize;

        // Get the closest alignment on the grid of cards
        cardTestedX -= cardTestedX%halfCardSize;
        cardTestedY -= cardTestedY%halfCardSize;

        // Get Top-left hand corner position of the card (default position stored) to compare with hashmaps
        cardTestedX -= halfCardSize;
        cardTestedY -= halfCardSize;

        Position alignedPosition = new Position();
        alignedPosition.init(cardTestedX, cardTestedY);

        return alignedPosition;

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
