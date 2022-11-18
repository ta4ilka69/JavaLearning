package Moves.StatusMoves;

import ru.ifmo.se.pokemon.*;

public class Swagger extends StatusMove {
    public Swagger(double pow, double acc) {
        super(Type.NORMAL, pow, acc);
    }

    protected void applyOppEffects(Pokemon p) {
        p.confuse();
        p.setMod(Stat.ATTACK, 2);
    }

    protected String describe() {
        return "использует Swagger";
    }
}
