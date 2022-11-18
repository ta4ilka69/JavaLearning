package Moves.PhysicalMoves;

import ru.ifmo.se.pokemon.*;

public class Facade extends DamageMove {
    public Facade(double pow, double acc) {
        super(Type.NORMAL, pow, acc);
    }

    protected final double calcAttDefFactor(Pokemon p1, Pokemon p2) {
        if (p2.getCondition() == Status.BURN || p2.getCondition() == Status.POISON || p2.getCondition() == Status.PARALYZE) {
            return p1.getStat(Stat.ATTACK) * 2 / p2.getStat(Stat.DEFENSE);
        } else {
            return p1.getStat(Stat.ATTACK) / p2.getStat(Stat.DEFENSE);
        }
    }

    protected String describe(){
        return "использует Facade";
    }
}
