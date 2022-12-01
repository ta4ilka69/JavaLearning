package Objects;

import State.AliveType;

public abstract class SomeObj {
    final private double weight;
    final private String def;
    final private AliveType type;

    public SomeObj(double weight, String name, AliveType type) throws InstantiationException {

        if (type == AliveType.Alive) {
            throw new InstantiationException("Ошибка: полностью живого объекта без магии невозможно!");
        } else {
            this.weight = weight;
            this.def = name;
            this.type = type;
        }
    }

    public double getWeight() {
        return weight;
    }

    public String getDef() {
        return def;
    }

    public AliveType getType() {
        return this.type;
    }
}
