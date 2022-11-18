package Moves.PhysicalMoves;

import ru.ifmo.se.pokemon.*;

public class Slash extends DamageMove {
    public Slash(double pow, double acc) {
        super(Type.NORMAL, pow, acc);
    }

    protected double calcCriticalHit(Pokemon var1, Pokemon var2) {
        if (3 * var1.getStat(Stat.SPEED) / 512.0 > Math.random()) {
            return 2.0;
        } else {
            return 1.0;
        }
    }

    protected final double calcAttDefFactor(Pokemon var1, Pokemon var2) {
        return var1.getStat(Stat.ATTACK) / var2.getStat(Stat.DEFENSE);
    }
}
