package Objects;

import Abstract.AliveType;
import Abstract.State;
import World.Thing;

public abstract class SomeObj implements Thing {
    final private double weight;
    final private String def;
    final private AliveType type;

    private State state;

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
}
