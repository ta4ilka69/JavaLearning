package Pokemons;

import Moves.StatusMoves.AncientPower;
import ru.ifmo.se.pokemon.*;

public class Yanmega extends Pokemon {
    public Yanmega(String name, int level) {
        super(name, level);
        this.setType(Type.BUG, Type.FLYING);
        this.setStats(86.0, 76.0, 86.0, 116.0, 56.0, 95.0);
        this.addMove(new AncientPower(60.0,100.0));
    }
}
