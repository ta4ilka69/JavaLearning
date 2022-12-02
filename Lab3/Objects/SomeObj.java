package Objects;

import Abstract.AliveType;
import Abstract.State;
import Creatures.SomeCreature;
import World.Thing;

public abstract class SomeObj implements Thing {
    final private double weight;
    final private String def;
    final private AliveType type;

    private State state;

    private SomeCreature owner;

    public SomeObj(double weight, String name, AliveType type, State state, SomeCreature owner) {
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
        System.out.println(this.getName()+" "+state.getState()+".");
    }

    public State getState() {
        return this.state;
    }

    public boolean equals(SomeObj o){
        if(o.getName().equals(this.getName())&&o.getState().equals(this.state)&&o.getType()==this.type && o.getWeight()==this.getWeight()){
            return true;
        }
        else{
            return false;
        }
    }
}
