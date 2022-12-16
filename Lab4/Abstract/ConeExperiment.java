package Abstract;

import Creatures.SomeCreature;
import Exceptions.StageException;
import Objects.River;
import Objects.SomeObj;

import java.util.ArrayList;

public class ConeExperiment extends Battle {
    private final River r;
    public ConeExperiment(Game g, SomeCreature c, River r){
        super(g,c);
        this.r = r;
    }

    public int start(int stage) throws StageException {
        if(stage<1){
            throw new StageException("Стадия эксперимента должна быть хотя бы 1");
        }
        SomeCreature c = this.getPlayers().get(0);
        if(stage==1){
            c.setIntellect(Intellect.Clever);
        }
        return firstStep(c);
    }

    public SomeObj choice(SomeObj o1, SomeObj o2){
        if(Math.random()>0.5){
            return o1;
        }
        return o2;
    }

    private int firstStep(SomeCreature c){
        SomeObj o1 = c.getInventory().get(0);
        ObjCreatureInteract.ThrowingIntoRiver(o1,c,this.r);
        SomeObj o2 = c.getInventory().get(0);
        ObjCreatureInteract.ThrowingIntoRiver(o2,c,this.r);
        SomeObj ch = choice(o1,o2);
        ArrayList<River.RiverTrash> q = r.popup();
        if(Math.abs(o2.getWeight()/o1.getWeight()-1)<0.1) {
            System.out.println("Нельзя различить, какая шишка была выбрана");
            r.toOld(q);
            return 0;
        }
        else{
            if(ch==q.get(0)){
                System.out.println(c.getName()+" угадал выигрышную и проигрышную! +2 победы!");
                r.toOld(q);
                return 2;
            }
            else{
                System.out.println(c.getName()+" не угадал ни выигрышную, ни проигрышную! +2 поражения...");
                r.toOld(q);
                return -2;
            }
        }

    }
}
