package com.example.yokai.rules;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Player {
    private String name;
    private Optional<AffinityCard> affinityCard;
    private List<YokaiClue> yokaiClues = new ArrayList<>();

    public void init(String name, Optional<AffinityCard> affinityCard){
        this.name = name;
        try {
            this.affinityCard = affinityCard;
        }
        catch (Exception e){
            this.affinityCard = null;
        }
    }

    public List<YokaiClue> getYokaiClues() {
        return yokaiClues;
    }

    public void addYokaiClue(YokaiClue yokaiClue){
        this.yokaiClues.add(yokaiClue);
    }

    public String getName() {
        return this.name;
    }

    public String askMove(YokaiGame yokaiGame){

        return "OK";
    }
}
