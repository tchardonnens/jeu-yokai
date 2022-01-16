package com.example.yokai.rules;

import java.util.*;

public class Board {

    private final YokaiCard[] yokaiCards = new YokaiCard[16];
    private Stack<YokaiClue> yokaiClues;
    private Optional<AffinityCard> affinityCard;
    private final ArrayList<YokaiNameEnum.YokaiName> cardsPoolNames = new ArrayList<>();
    private final ArrayList<Position> cardsPoolPositions = new ArrayList<>();

    public YokaiCard[] setYokaiCards(){
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
        return yokaiCards;
    }

    public

    public void display() {

    }
}
