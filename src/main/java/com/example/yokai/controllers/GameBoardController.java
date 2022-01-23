package com.example.yokai.controllers;

import com.example.yokai.gui.Card;
import com.example.yokai.gui.Clue;
import com.example.yokai.rules.*;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.Node;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import static com.example.yokai.Main.yokaiGame;

public class GameBoardController {

    public Pane boardPane;
    public Pane cluesPane;
    public Button playTurnButton;
    public Button calmedDownButton;
    public Text textPlayer1;
    public Text textPlayer2;
    public Text textPlayer3;
    public Text textPlayer4;
    public List<Text> textPlayers = new ArrayList<>();
    public HashMap<String, Text> playersLabel = new HashMap<>();
    public Circle iconPlayer1;
    public Circle iconPlayer2;
    public Circle iconPlayer3;
    public Circle iconPlayer4;
    public List<Circle> circlePlayers = new ArrayList<>();
    public HashMap<String, Circle> playersCircle = new HashMap<>();

    private Card tempCard;

    private double oldX;
    private double oldY;

    private double mouseAnchorX;
    private double mouseAnchorY;

    private boolean isValidMove;

    private ArrayList<Card> cardsSelected = new ArrayList<>();

    private Group group = new Group();
    private Card[] cards = new Card[16];
    private Board board = new Board();
    private Clue[] clues = new Clue[4];
    boolean isEndGame = false;
    boolean isPlayingTurn = false;
    boolean isAskingCalmedDown = false;

    public void addCardsToBoard() throws FileNotFoundException {
        board.initYokaiCards();
        YokaiCard[] yokaiCards = board.getYokaiCards();
        int i = 0;
        for (YokaiCard yokaiCard : yokaiCards){
            String cardID = "card"+i;
            cards[i] = new Card(yokaiCard, cardID);
            boardPane.setVisible(true);
            boardPane.getChildren().add(cards[i]);
            i+=1;
        }
        boardPane.setTranslateX(boardPane.getPrefWidth()/8);
        boardPane.setTranslateY(boardPane.getPrefHeight()/1200);
        int k = 0;
        for (Card card : cards){
            double X = boardPane.getChildren().get(k).getLayoutX();
            double Y = boardPane.getChildren().get(k).getLayoutY();
            System.out.println(k + " X : " + X + " Y : " + Y);
            k+=1;
        }
    }

    public void playerPicksNewClue(Player player){
        player.addYokaiClue(board.getYokaiCluesStack().pop());
    }

    public void addCluesToPlayerSidePanel(Player currentPlayer) throws FileNotFoundException {
        List<YokaiClue> yokaiClues = currentPlayer.getYokaiClues();
        int i =0;
        for (YokaiClue yokaiClue : yokaiClues){
            String clueID = "clue"+i;
            Position position = new Position();
            position.init(0, i*100);
            yokaiClue.setPosition(position);
            clues[i] = new Clue(yokaiClue, clueID);
            cluesPane.setVisible(true);
            cluesPane.getChildren().add(clues[i]);
            i+=1;
        }
        cluesPane.setTranslateX(cluesPane.getPrefWidth()/10);
        cluesPane.setTranslateY(cluesPane.getPrefHeight()/10);
    }

    public void hidePlayers(Text textPlayer, Circle iconPlayer) {
        textPlayer.setVisible(false);
        iconPlayer.setVisible(false);
    }

    @FXML
    public void initialize() throws IOException {
        playTurnButton.setVisible(false);
        playTurnButton.setDisable(true);
        calmedDownButton.setVisible(false);
        calmedDownButton.setDisable(true);
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
        circlePlayers = Arrays.asList(iconPlayer1, iconPlayer2, iconPlayer3, iconPlayer4);
        textPlayers = Arrays.asList(textPlayer1, textPlayer2, textPlayer3, textPlayer4);
        for (int i=0; i< yokaiGame.getNumberOfPlayersInGame(); i++){
            playersLabel.put(yokaiGame.getPlayers()[i].getName(), textPlayers.get(i));
            playersCircle.put(yokaiGame.getPlayers()[i].getName(), circlePlayers.get(i));
        }

        addCardsToBoard();
        board.initYokaiClues(yokaiGame.getNumberOfPlayersInGame());
        playGame();

        //playerPicksNewClue(yokaiGame.getPlayers()[0]);
        //playerPicksNewClue(yokaiGame.getPlayers()[0]);
        //addCluesToPlayerSidePanel(yokaiGame.getPlayers()[0]);
    }

    @FXML
    public void playGame() {
        yokaiGame.setCurrentPlayer();
        playersLabel.get(yokaiGame.getCurrentPlayer().getName()).setFill(Color.GREEN);
        playersCircle.get(yokaiGame.getCurrentPlayer().getName()).setFill(Color.GREEN);
        playTurnButton.setVisible(true);
        playTurnButton.setDisable(false);
        calmedDownButton.setVisible(true);
        calmedDownButton.setDisable(false);
    }

    @FXML
    private void playTurn() {
        playTurnButton.setVisible(false);
        playTurnButton.setDisable(true);
        calmedDownButton.setVisible(false);
        calmedDownButton.setDisable(true);
        for (Card card : cards) {
            card.setOnMouseEntered(e -> {
                if(card.getDraggable() && cardsSelected.size()<2) {
                    card.setCursor(Cursor.HAND);
                    card.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);");
                }
            });

            card.setOnMouseExited(e -> {
                if(card.getDraggable() && cardsSelected.size()<2) {
                    card.setStyle("-fx-effect: none;");
                }
            });

            card.setOnMousePressed(e -> {
                if(card.getDraggable() && cardsSelected.size()<2 && !cardsSelected.contains(card))  {
                    card.flipCard();
                    Timer showCardTimer = new Timer();
                    showCardTimer.schedule(new TimerTask(){
                        @Override
                        public void run() {
                            card.flipCard();
                        }
                    }, 2000);
                    if (!cardsSelected.contains(card)){
                        cardsSelected.add(card);
                    }
                    if (cardsSelected.size() == 2){
                        cardMove();
                    }
                    card.setStyle("-fx-effect: none;");
                }
            });
        }
    }

    @FXML
    private void cardMove(){
        System.out.println("Choose the card to move");
        for (Card card : cards) {
            card.setOnMouseEntered(e -> {
                if(card.getDraggable()) {
                    card.setCursor(Cursor.HAND);
                    card.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);");
                }
            });

            card.setOnMouseExited(e -> {
                if(card.getDraggable()) {
                    card.setStyle("-fx-effect: none;");
                }
            });

            card.setOnMousePressed(e -> {
                if(card.getDraggable())  {
                    moveTempCard(card);
                }
            });
        }
    }

    private void moveTempCard(Card card) {
        try {
            tempCard = new Card(board.createTempCard(card.getYokaiCard()), "tempCard");
            boardPane.getChildren().add(tempCard);
            tempCard.toFront();
            card.setVisible(false);
            tempCard.setVisible(true);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        tempCard.setCursor(Cursor.HAND);

        oldX = card.getLayoutX();
        oldY = card.getLayoutY();

        tempCard.setOnMousePressed(mouseEvent -> {
            tempCard.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(67,19,187,0.8), 10, 0, 0, 0);");
            mouseAnchorX = mouseEvent.getSceneX();
            mouseAnchorY = mouseEvent.getSceneY();

        });

        tempCard.setOnMouseDragged(mouseEvent -> {
            tempCard.setCursor(Cursor.CLOSED_HAND);
            tempCard.setLayoutX(mouseEvent.getSceneX() - mouseAnchorX + oldX);
            tempCard.setLayoutY(mouseEvent.getSceneY() - mouseAnchorY + oldY);

        });


        tempCard.setOnMouseReleased(b -> {
            double releasedX = tempCard.getLayoutX();
            double releasedY = tempCard.getLayoutY();

            Position tempPosition = new Position();
            tempPosition.init((int) releasedX, (int) releasedY);

            isValidMove = yokaiGame.isValidMove(board.getYokaiCards(), card.getYokaiCard(), tempPosition);

            if (isValidMove){
                Position newPosition = yokaiGame.alignOnGrid(tempPosition);
                card.getYokaiCard().setPosition(newPosition);

                // Update board
                YokaiCard[] newYokaiCards = new YokaiCard[16];
                int i = 0;
                for (Card card1 : cards){
                    newYokaiCards[i] = card1.getYokaiCard();
                    i += 1;
                }
                board.setYokaiCards(newYokaiCards);

                // Update GUI Board
                boardPane.getChildren().remove(tempCard);
                card.setLayoutX(newPosition.getX());
                card.setLayoutY(newPosition.getY());
                card.setVisible(true);

            }

            else {
                this.tempCard.setVisible(false);
                boardPane.getChildren().remove(tempCard);
                card.setVisible(true);
            }


        });
    }

    @FXML
    private void calmDown() {
        playTurnButton.setVisible(false);
        playTurnButton.setDisable(true);
        calmedDownButton.setVisible(false);
        calmedDownButton.setDisable(true);
        yokaiGame.askIfYokaiCalmDown();
    }



}