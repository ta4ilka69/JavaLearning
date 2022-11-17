package Moves;

import ru.ifmo.se.pokemon.*;

public class AncientPower extends SpecialMove{
    public AncientPower(double pow, double acc){
        super(Type.ROCK,pow,acc);
    }
    protected void applySelfEffects(Pokemon p){
        if (Math.random()<=0.1){
            Effect increaseAllStats = new Effect();
            for(Stat x: Stat.values()) {
                increaseAllStats.stat(x, 1);
            }
            p.addEffect(increaseAllStats);

        }
    }
    protected String describe(){
        return "использует Ancient Power";
    }
}
