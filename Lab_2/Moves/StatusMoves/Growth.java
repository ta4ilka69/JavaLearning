package Moves.StatusMoves;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.StatusMove;

public class Growth extends StatusMove {
    public Growth() {
        super();
    }

    protected void applySelfEffects(Pokemon pokemon) {
        pokemon.setMod(Stat.ATTACK, 1);
        pokemon.setMod(Stat.SPECIAL_ATTACK, 1);
    }

    protected String describe() {
        return "использует Growth";
    }
}
