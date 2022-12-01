package Creatures;

import State.AliveType;
import State.Intellect;

public abstract class SomeCreature {
    private final String name;
    private final double weight;
    private final Intellect intellect;
    private final AliveType type;

    public SomeCreature(String name, double weight, Intellect intellect, AliveType type) throws InstantiationException{
        if(AliveType.Alive != type){
            throw new InstantiationException("Создание должно быть живым!");
        }
        else {
            this.name = name;
            this.intellect = intellect;
            this.type = type;
            this.weight = weight;
        }
    }
}
