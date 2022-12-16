package Abstract;

import Creatures.SomeCreature;
import Objects.Breach;
import Objects.River;
import Objects.SomeObj;



public class ObjCreatureInteract{
    public static void ThrowingIntoRiver(SomeObj t, SomeCreature c, River r){
        c.deleteInventory(t);
        System.out.println(c.getName()+" бросил " + t.getName().substring(0,t.getName().length()-1)+"у  в " + r.getName()+".");
        r.newTrash(t,c);
    }

    public static void getCloserTo(SomeCreature c, SomeObj o){
        System.out.println(c.getName()+" приближается к "+ o.getName());
        if(c.getIntellect()==Intellect.Stupid){
            System.out.println(c.getName()+" споткнулся!");
            if(o instanceof Breach){
                dropObj(c,((Breach) o).getRiver());
            }
            else{
                dropObj(c,null);
            }
        }
    }

    public static void dropObj(SomeCreature c, River river) {
        SomeObj l = c.getLArm();
        SomeObj r = c.getRArm();
        if (l != null) {
            c.setLArm(null);
            System.out.println(c.getName() + " выронил " + l.getName());
            if (river != null) {
                river.newTrash(l, c);
            }
        }
        if (r != null) {
            c.setRArm(null);
            System.out.println(c.getName() + " выронил " + r.getName());
            if (river != null) {
                river.newTrash(r, c);
            }
        }
    }
}
