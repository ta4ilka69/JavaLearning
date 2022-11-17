package Moves;

import ru.ifmo.se.pokemon.*;

public class Tickle extends StatusMove {
    public Tickle(double pow, double acc) {
        super(Type.NORMAL,pow,acc);
    }

    protected void applyOppEffects(Pokemon p){
        Effect decreaseAttDefStats = new Effect();
        decreaseAttDefStats.stat(Stat.ATTACK,-1);
        decreaseAttDefStats.stat(Stat.DEFENSE,-1);
        p.addEffect(decreaseAttDefStats);
    }

    protected String describe(){
        return "использует Tickle";
    }
}
