package Abstract;

import Creatures.SomeCreature;
import World.Entartainments;

import java.util.ArrayList;

public class Battle implements Entartainments {
    private final Game game;
    private ArrayList<SomeCreature> players;
    private SomeCreature winner;
    private final String rules;

    private Boolean active;

    public Battle(Game g, ArrayList<SomeCreature> players) {
        this.game = g;
        this.players = players;
        this.rules = g.getDescription();
        this.active = true;
    }

    public void setWinner(SomeCreature winner) {
        this.winner = winner;
        this.active = false;
        System.out.println("Игра закончена!");
    }

    public String getRules() {
        return this.rules;
    }

    public SomeCreature getWinner() {
        return this.winner;
    }

    public ArrayList<SomeCreature> getPlayers() {
        return this.players;
    }

    public void setPlayers(ArrayList<SomeCreature> a) {
        this.players = a;
    }
    public int hashCode(){
        return game.hashCode()+players.hashCode()+winner.hashCode()+rules.hashCode()+active.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Battle && this.hashCode()==obj.hashCode();
    }
}
