package Objects;

import Abstract.AliveType;
import Abstract.State;
import Creatures.SomeCreature;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
//parametrs of Stick
//lenght
//diametr
//могла тонуть
//могла плыть по течение
//скорость течения речки
//plotnost

public class River extends SomeObj{
    private final ArrayList<RiverTrash> trashInRiver;
    private final String goal;

    //make 3 const

    public River(String name, State state, String goal){
        super(Double.POSITIVE_INFINITY, name, AliveType.MagicAlive, state);
        this.goal = goal;
        this.trashInRiver = new ArrayList<>();
    }

    public void newTrash(SomeObj o, SomeCreature whoseTrash){
        if(this.getState()==State.Lazy) {
            this.trashInRiver.add(new RiverTrash(o.getName(), o.getWeight()*3, whoseTrash));
        }
        else{
            this.trashInRiver.add(new RiverTrash(o.getName(), o.getWeight(), whoseTrash));
        }
    }

    public ArrayList<RiverTrash> getTrashInRiver(){
        return this.trashInRiver;
    }

    public String getGoal(){
        return this.goal;
    }

    public void popup(){
        this.trashInRiver.sort(Comparator.comparing(RiverTrash::getH));
        for(RiverTrash t:this.trashInRiver){
            t.setPop();
        }
    }
}
