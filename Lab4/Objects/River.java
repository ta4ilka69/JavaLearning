package Objects;

import Abstract.AliveType;
import Abstract.Goal;
import Abstract.State;
import Creatures.SomeCreature;

import java.util.ArrayList;
import java.util.Comparator;

public class River extends SomeObj implements Goal {
    private final ArrayList<RiverTrash> trashInRiver;
    private final String goal;
    private final double flowRate;
    private static final int stateDependency = 3;

    public River(String name, double flowRate, State state, String goal) {
        super(Double.POSITIVE_INFINITY, 1000.0, name, AliveType.MagicAlive, state);
        this.goal = goal;
        this.flowRate = flowRate;
        this.trashInRiver = new ArrayList<>();
    }

    public class RiverTrash extends SomeObj {
        private double h;
        private Double timeToUp;
        private final River river;

        public RiverTrash(String name, double weight, double density, SomeCreature owner, River r) {
            super(weight, density, name, AliveType.Lifeless, State.Swim, owner);
            this.h = weight * owner.getWeight();
            this.river = r;
            this.timeToUp = timeToUpCalc(this);
            System.out.println("Теперь в реке " + name + " от " + owner.getName() + " на глубине " + this.h + ".");
        }

        private Double timeToUpCalc(RiverTrash o) {
            if(o.getDensity()>=this.river.getDensity()){
                return Double.NEGATIVE_INFINITY;
            }
            else{
                return (Math.sqrt(Math.pow(this.h,2)+Math.pow(this.river.getFlowRate(),2)))/(this.river.getDensity()/o.getDensity());
            }
        }

        public double getH() {
            return this.h;
        }

        public void setPop() {
            if(this.timeToUp>=0) {
                this.h = 0;
                System.out.println(this.getName() + " всплыл через " + this.timeToUp.toString() + ", хозяин: " + this.getOwner().getName() + ".");
            }
            else {
                System.out.println(this.getName() + " у " +this.getOwner().getName() + " никогда не всплывёт...");
            }
        }


    }

    public void newTrash(SomeObj o, SomeCreature whoseTrash) {
        if (this.getState() == State.Lazy) {
            this.trashInRiver.add(new RiverTrash(o.getName(), o.getWeight() * stateDependency, o.getDensity(), whoseTrash, this));
        } else {
            this.trashInRiver.add(new RiverTrash(o.getName(), o.getWeight(), o.getDensity(), whoseTrash,this));
        }
    }

    public ArrayList<RiverTrash> getTrashInRiver() {
        return this.trashInRiver;
    }

    public String getGoal() {
        return this.goal;
    }

    public double getFlowRate(){
        return this.flowRate;
    }

    public void popup() {
        this.trashInRiver.sort(Comparator.comparing(RiverTrash::getH));
        for (RiverTrash t : this.trashInRiver) {
            if(t.getType() == AliveType.Lifeless) {
                t.setPop();
            }
        }
    }
}
