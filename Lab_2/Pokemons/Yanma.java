package Pokemons;

import Moves.SpesialMoves.SonicBoom;
import Moves.StatusMoves.AncientPower;
import Moves.StatusMoves.Roost;
import ru.ifmo.se.pokemon.*;

public class Yanma extends Pokemon {
    public Yanma(String name, int level) {
        super(name, level);
        this.setStats(65.0, 65.0, 45.0, 75.0, 45.0, 95.0);
        this.setType(Type.BUG, Type.FLYING);
        this.addMove(new Roost());
        this.addMove(new SonicBoom(0.0, 55.0));
        this.addMove(new AncientPower(60.0, 100.0));
    }
}
