package com.example.yokai.rules;

import java.io.File;
import java.util.*;

public class Board {

    private YokaiCard[] yokaiCards = new YokaiCard[16];
    private List<File> yokaiClues1Color = new ArrayList<>();
    private List<File> yokaiClues2Colors = new ArrayList<>();
    private List<File> yokaiClues3Colors = new ArrayList<>();
    private List<File> yokaiCluesAllColors = new ArrayList<>();
    private Stack<YokaiClue> yokaiCluesStack = new Stack<>();
    private Optional<AffinityCard> affinityCard;
    private final ArrayList<YokaiNameEnum.YokaiName> cardsPoolNames = new ArrayList<>();
    private final ArrayList<Position> cardsPoolPositions = new ArrayList<>();
    File directory1Color = new File("src/main/resources/com/example/yokai/images/clues/1_color");
    File directory2Colors = new File("src/main/resources/com/example/yokai/images/clues/2_colors");
    File directory3Colors = new File("src/main/resources/com/example/yokai/images/clues/3_colors");

    public void initYokaiCards(){
        for (int i = 0; i < 4; i++) {
            cardsPoolNames.add(YokaiNameEnum.YokaiName.KITSUNE);
            cardsPoolNames.add(YokaiNameEnum.YokaiName.ROKUROKUBI);
            cardsPoolNames.add(YokaiNameEnum.YokaiName.KAPPA);
            cardsPoolNames.add(YokaiNameEnum.YokaiName.ONI);
        }
        Collections.shuffle(cardsPoolNames);
        Position[] positions = new Position[17];
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                int index = i * j;
                positions[index] = new Position();
                positions[index].init(j * 100, i * 100);
                cardsPoolPositions.add(positions[index]);
            }
        }
        for (int i = 0; i < yokaiCards.length; i++) {
            yokaiCards[i] = new YokaiCard(cardsPoolNames.get(i), cardsPoolPositions.get(i));
        }
    }

    public void setYokaiCards(YokaiCard[] yokaiCards){
        this.yokaiCards = yokaiCards;
    }

    public YokaiCard[] getYokaiCards() {
        return yokaiCards;
    }

    public void initYokaiClues(int numberOfPlayers){
        yokaiClues1Color = Arrays.asList(directory1Color.listFiles());
        yokaiClues2Colors = Arrays.asList(directory2Colors.listFiles());
        yokaiClues3Colors = Arrays.asList(directory3Colors.listFiles());

        Collections.shuffle(yokaiClues1Color);
        Collections.shuffle(yokaiClues2Colors);
        Collections.shuffle(yokaiClues3Colors);

        switch (numberOfPlayers){
            case 2:
                // 1 color : 2 cards, 2:3, 3:2
                pickFromColorList(yokaiClues1Color, 2);
                pickFromColorList(yokaiClues2Colors, 3);
                pickFromColorList(yokaiClues3Colors, 2);
                Collections.shuffle(yokaiCluesAllColors);
                break;
            case 3:
                // 1 color : 2 cards, 2:4, 3:3
                pickFromColorList(yokaiClues1Color, 2);
                pickFromColorList(yokaiClues2Colors, 4);
                pickFromColorList(yokaiClues3Colors, 3);
                Collections.shuffle(yokaiCluesAllColors);
                break;
            case 4:
                // 1 color : 3 cards, 2:4, 3:3
                pickFromColorList(yokaiClues1Color, 3);
                pickFromColorList(yokaiClues2Colors, 4);
                pickFromColorList(yokaiClues3Colors, 3);
                Collections.shuffle(yokaiCluesAllColors);
                break;
        }

        YokaiClue[] yokaiClues = new YokaiClue[yokaiCluesAllColors.size()];

        for (int i=0; i<yokaiCluesAllColors.size();i++){
            String filename = yokaiCluesAllColors.get(i).getName();
            filename = filename.substring(0, filename.lastIndexOf('.'));
            yokaiClues[i] = new YokaiClue(filename);
        }
        yokaiCluesStack.addAll(List.of(yokaiClues));
    }

    public YokaiCard createTempCard(YokaiCard cardToDuplicate){
        YokaiCard tempCard = new YokaiCard(cardToDuplicate.getName(), cardToDuplicate.getPosition());
        return tempCard;
    }

    private List<File> pickFromColorList(List<File> yokaiCluesXColors, int numberOfCardsToPick){
        for (int i=0; i<numberOfCardsToPick+1; i++){
            yokaiCluesAllColors.add(yokaiCluesXColors.get(i));
        }
        return this.yokaiCluesAllColors;
    }

    public void setYokaiCluesStack(Stack<YokaiClue> yokaiCluesStack) {
        this.yokaiCluesStack = yokaiCluesStack;
    }

    public Stack<YokaiClue> getYokaiCluesStack() {
        return yokaiCluesStack;
    }

    public void display() {
    }
}
