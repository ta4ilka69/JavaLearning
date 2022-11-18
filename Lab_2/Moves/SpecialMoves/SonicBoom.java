package Moves.SpecialMoves;

import ru.ifmo.se.pokemon.DamageMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;


public class SonicBoom extends DamageMove {
    public SonicBoom(double pow, double acc) {
        super(Type.NORMAL, pow, acc);
    }

    public final double calcAttDefFactor(Pokemon p1, Pokemon p2) {
        if (p2.hasType(Type.GHOST)) {
            return 20.0;
        } else {
            return 0.0;
        }
    }

    protected String describe() {
        return "использует Sonic Boom";
    }
}
