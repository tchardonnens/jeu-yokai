package com.example.yokai.rules;

import java.util.Optional;

public class Player {
    private String name;
    private Optional<AffinityCard> affinityCard;
    private YokaiClue[] yokaiClues;

    public void init(String name, Optional<AffinityCard> affinityCard){
        this.name = name;
        try {
            this.affinityCard = affinityCard;
        }
        catch (Exception e){
            this.affinityCard = null;
        }
    }

    public void setYokaiClues(YokaiClue[] yokaiClues) {
        this.yokaiClues = yokaiClues;
    }

    public YokaiClue[] getYokaiClues() {
        return yokaiClues;
    }

    public String getName() {
        return this.name;
    }

    public String askMove(YokaiGame yokaiGame){

        return "OK";
    }
}
