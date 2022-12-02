package Objects;

import Abstract.AliveType;
import Abstract.State;
import Creatures.SomeCreature;

public class RiverTrash extends SomeObj {
    private double h;

    public RiverTrash(String name, double weight, SomeCreature owner) {
        super(weight, name, AliveType.Lifeless, State.Swim, owner);
        this.h = weight * owner.getWeight();
        System.out.println("Теперь в реке " + name + " от " + owner.getName() + " на глубине " + this.h + ".");
    }

    public double getH() {
        return this.h;
    }

    public void setPop() {
        this.h = 0;
        System.out.println(this.getName() + " всплыл, хозяин: " + this.getOwner().getName() + ".");
    }
}
