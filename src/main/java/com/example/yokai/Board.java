package com.example.yokai;

import java.util.*;

public class Board {
    private YokaiCard[] yokaiCards = new YokaiCard[16];
    private Stack<YokaiClue> yokaiClues;
    private Optional<AffinityCard> affinityCard;
    private ArrayList<YokaiNameEnum.YokaiName> cardsPoolNames = new ArrayList<>();
    private ArrayList<Position> cardsPoolPositions = new ArrayList<>();

    private YokaiCard[] createCardsSquare() {
        for (int i = 0; i < 4; i++) {
            cardsPoolNames.add(YokaiNameEnum.YokaiName.KITSUNE);
            cardsPoolNames.add(YokaiNameEnum.YokaiName.ROKUROKUBI);
            cardsPoolNames.add(YokaiNameEnum.YokaiName.KAPPA);
            cardsPoolNames.add(YokaiNameEnum.YokaiName.ONI);
        }
        Collections.shuffle(cardsPoolNames);
        Position[] positions = new Position[16];
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                int index = i * j;
                positions[index] = new Position();
                positions[index].init(j * 60, i * 60);
                cardsPoolPositions.add(positions[index]);
            }
        }

        for (int i = 0; i < yokaiCards.length; i++) {
            yokaiCards[i] = new YokaiCard();
            yokaiCards[i].init(cardsPoolNames.get(i), cardsPoolPositions.get(i));
        }
        return yokaiCards;
    }

    public void display() {

    }
}
