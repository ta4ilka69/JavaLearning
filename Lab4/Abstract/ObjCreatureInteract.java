package Abstract;

import Creatures.SomeCreature;
import Objects.River;
import Objects.SomeObj;
import Objects.StickStageTwo;


public class ObjCreatureInteract{
    public static void ThrowingStickIntoRiver(StickStageTwo t, SomeCreature c, River r){
        c.deleteInventory(t);
        System.out.println(c.getName()+" бросил палку в " + r.getName()+".");
        r.newTrash(t,c);
    }

    public static void getCloserTo(SomeCreature c, SomeObj o){
        System.out.println(c.getName()+" приближается к "+ o.getName());
    }
}
