package Moves.StatusMoves;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.StatusMove;


public class Roost extends StatusMove {
    public Roost() {
        super();
    }

    protected void applySelfEffects(Pokemon p) {
        p.setMod(Stat.HP, (int) (p.getHP() / 2 + p.getStat(Stat.HP)));
    }

    protected String describe() {
        return "использует Roost";
    }
}
