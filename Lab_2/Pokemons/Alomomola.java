package Pokemons;

import Moves.PhysicalMoves.DoubleSlap;
import Moves.PhysicalMoves.Pound;
import Moves.StatusMoves.HealPulse;
import Moves.StatusMoves.Tickle;
import ru.ifmo.se.pokemon.*;


public class Alomomola extends Pokemon {
    public Alomomola(String name, int level) {
        super(name, level);
        this.setStats(165.0, 75.0, 80.0, 40.0, 45.0, 65.0);
        this.setType(Type.WATER);
        this.addMove(new Pound(40.0, 100.0));
        this.addMove(new Tickle(0.0, 100));
        this.addMove(new HealPulse(0.0, 0.0));
        this.addMove(new DoubleSlap(15.0, 85));
    }
}
