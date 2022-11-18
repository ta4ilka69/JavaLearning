package Moves.PhysicalMoves;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Type;

public class DoubleSlap extends PhysicalMove {
    public DoubleSlap(double pow, double acc) {

        super(Type.NORMAL, calcPower(pow), acc);
    }

    private static Double calcPower(double pow) {
        double chance = Math.random();
        if (chance <= 0.00219726562) {
            return pow * 5;
        } else if (chance <= 0.017578125) {
            return pow * 4;
        } else if (chance <= 0.140625) {
            return pow * 3;
        } else if (chance <= 0.375) {
            return pow * 2;
        } else {
            return pow;
        }
    }
    protected String describe(){
        return "использует Double Slap";
    }

}
