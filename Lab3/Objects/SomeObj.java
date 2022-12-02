package Objects;

import Abstract.AliveType;
import Abstract.State;
import Creatures.SomeCreature;
import World.Thing;

import java.util.Objects;

public abstract class SomeObj implements Thing {
    private final Double weight;
    final private String def;
    private final AliveType type;

    private State state;

    private SomeCreature owner;

    public SomeObj(Double weight, String name, AliveType type, State state, SomeCreature owner) {
        this.weight = weight;
        this.def = name;
        this.type = type;
        this.state = state;
        this.owner = owner;
        if (type == AliveType.Alive) {
            System.out.println("Ошибка: полностью живого объекта без магии невозможно!");
            System.exit(1);
        }
    }

    public SomeObj(double weight, String name, AliveType type, State state) {
        this.weight = weight;
        this.def = name;
        this.type = type;
        this.state = state;
        if (type == AliveType.Alive) {
            System.out.println("Ошибка: полностью живого объекта без магии невозможно!");
            System.exit(1);
        }
    }

    public SomeCreature getOwner() {
        return owner;
    }

    public double getWeight() {
        return weight;
    }

    public String getName() {
        return def;
    }

    public AliveType getType() {
        return this.type;
    }

    public void setState(State state) {
        this.state = state;
        System.out.println(this.getName() + " " + state.getState() + ".");
    }

    public State getState() {
        return this.state;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof SomeObj && o.hashCode() == this.hashCode();
    }

    @Override
    public int hashCode() {
        return this.getName().hashCode() + weight.hashCode() + state.getState().hashCode() + type.hashCode();
    }

    @Override
    public String toString() {
        return "Объект с именем: "+this.def+"; с весом: "+this.weight+"; с состоянием: "+this.state+"; с типом: "+this.type;
    }
}
