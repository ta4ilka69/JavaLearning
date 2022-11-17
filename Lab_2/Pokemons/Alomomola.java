package Pokemons;

import Moves.PhysicalMoves.Pound;
import Moves.StatusMoves.Tickle;
import ru.ifmo.se.pokemon.*;


public final class Alomomola extends Pokemon {
    public Alomomola(String name, int level) {
        super(name, level);
        this.setStats(165.0, 75.0, 80.0, 40.0, 45.0, 65.0);
        this.setType(Type.WATER);
        this.addMove(new Pound(40.0, 100.0));
        this.addMove(new Tickle(0.0,100));
    }
}
