package Objects;

import Abstract.AliveType;
import Abstract.State;
import Creatures.SomeCreature;
import Exceptions.AliveTypeException;
import World.Thing;


public abstract class SomeObj implements Thing {
    private final Double density;
    private final Double weight;
    final private String def;
    private final AliveType type;

    private State state;

    private SomeCreature owner;

    public SomeObj(Double weight, Double density, String name, AliveType type, State state, SomeCreature owner) {
        this.weight = weight;
        this.density = density;
        this.def = name;
        this.type = type;
        this.state = state;
        this.owner = owner;
        if (type == AliveType.Alive) {
            throw new AliveTypeException("Невозможно создать полностью живой объект без магии!");
        }
    }

    public SomeObj(Double weight,Double density, String name, AliveType type, State state) throws AliveTypeException {
        this.weight = weight;
        this.density = density;
        this.def = name;
        this.type = type;
        this.state = state;
        if (type == AliveType.Alive) {
            throw new AliveTypeException("Невозможно создать полностью живой объект без магии!");
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

    public Double getDensity(){
        return this.density;
    }

    @Override
    public int hashCode() {
        return this.getName().hashCode() + weight.hashCode() + state.getState().hashCode() + type.hashCode();
    }

    @Override
    public String toString() {
        return "Объект с именем: "+this.def+"; с весом: "+this.weight+"; с состоянием: "+this.state+"; с типом: "+this.type;
    }

    public Double getVisibility(){
        if(this.weight>=100.0){
            return 0.95;
        }
        if(40.0<=this.weight){
            return 0.93;
        }
        if(this.weight>=10){
            return 0.91;
        }
        else{
            return this.weight/10;
        }
    }
}
