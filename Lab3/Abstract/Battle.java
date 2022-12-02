package Abstract;

import Creatures.SomeCreature;
import World.Entartainments;

import java.util.ArrayList;

public class Battle implements Entartainments {
    private final Game game;
    private final ArrayList<SomeCreature> players;
    private SomeCreature winner;
    private final String rules;

    private Boolean active;
    public Battle(Game g, ArrayList<SomeCreature> players){
        this.game = g;
        this.players = players;
        this.rules = g.getDescription();
        this.active = true;
    }

    public void setWinner(SomeCreature winner) {
        this.winner = winner;
        this.active = false;
    }

    public String getRules(){
        return this.rules;
    }

    public SomeCreature getWinner(){
        return this.winner;
    }
}