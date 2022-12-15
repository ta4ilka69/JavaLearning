package Abstract;

import Creatures.SomeCreature;
import Objects.River;
import Objects.SomeObj;
import Objects.Stick;

import java.util.ArrayList;

public class ObjCreatureInteract implements Interactions{
    public static void ThrowingStickIntoRiver(Stick t, SomeCreature c, River r){
        c.deleteInventory(t);
        r.newTrash(t,c);
        System.out.println(c.getName()+" бросил палку в " + r.getName()+".");
    }

    public static void getCloserTo(SomeCreature c, SomeObj o){
        System.out.println(c.getName()+" приближается к "+ o.getName());
    }
}
