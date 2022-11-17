package Moves.StatusMoves;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;

public class HealPulse extends StatusMove {
    public HealPulse(double pow, double acc){
        super(Type.PSYCHIC,pow,acc);
    }

    protected String describe(){
        return "использует Heal Pulse";
    }

    protected void applySelfEffects(Pokemon p) {

    }
}
