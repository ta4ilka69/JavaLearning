package Pokemons;


import Moves.PhysicalMoves.Slash;

public class Yanmega extends Yanma {
    public Yanmega(String name, int level) {
        super(name, level);
        this.addMove(new Slash(70.0, 100.0));
    }
}
