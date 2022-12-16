package Creatures;

import Abstract.*;
import Objects.SomeObj;
import World.Thing;
import World.World;

import java.util.ArrayList;

public class SomeCreature implements Thing, Goal {
    private final String name;
    private final Double weight;
    private final Intellect intellect;
    private final AliveType type;
    private State state;

    private final ArrayList<Game> knownGames;

    private final ArrayList<SomeObj> inventory;

    public SomeCreature(String name, Double weight, Intellect intellect, AliveType type, State state) {
        this.name = name;
        this.intellect = intellect;
        this.type = type;
        this.weight = weight;
        this.knownGames = new ArrayList<>();
        this.state = state;
        this.inventory = new ArrayList<>();
        if (AliveType.Alive != type) {
            System.out.println("Ошибка: Невозможно создать неживое существо. (Воспользуйтесь магией и классом Someobj)");
            System.exit(1);
        }
        printCreate();
    }

    @Override
    public double getWeight() {
        return weight;
    }

    public Intellect getIntellect() {
        return intellect;
    }

    @Override
    public AliveType getType() {
        return type;
    }

    @Override
    public String getName() {
        return name;
    }

    public void addKnownGame(Game game) {
        this.knownGames.add(game);
    }

    public ArrayList<Game> getKnownGames() {
        return this.knownGames;
    }

    public State getState() {
        return this.state;
    }

    public void setState(State t) {
        this.state = t;
        System.out.println(this.getName() + " " + t.getState() + ".");
    }

    public String toString() {
        return "Создание с именем: " + this.getName() + ", с весом: " + this.getWeight() + ", с интеллектом: " + this.getIntellect() + ". Находится в состоянии: " + this.getState() + ". Знает игры: " + this.getKnownGames().toString();
    }

    private void printCreate() {
        System.out.println("Создан(-а,о) создание с именем: " + this.getName());
    }

    public void selfLearn(Game g) {
        this.addKnownGame(g);
        System.out.println(this.name + " теперь знает игру " + g.getName());
    }

    public void Teaching(Game g, SomeCreature learner) {
        if (this.getKnownGames().contains(g) && learner.getIntellect().getIntellect() >= g.getIQMinimum().getIntellect()) {
            learner.addKnownGame(g);
        }
    }

    public ArrayList<SomeObj> getInventory() {
        return this.inventory;
    }

    public void addInventory(SomeObj o) {
        if (o.getType() == AliveType.Lifeless) {
            this.inventory.add(o);
        } else {
            System.out.println("Невозможно добавить объект с сознанием в инвентарь: это противоречит международной конвенции ООН!!!");
        }
    }

    public void deleteInventory(SomeObj o) {
        this.inventory.remove(o);
    }

    public void search(SomeObj o, World world) {
        System.out.println(this.name + " ищет " + o.getName() + ".");
        if (world.getObjects().contains(o)) {
            ArrayList<SomeObj> items = new ArrayList<>();
            for(SomeObj c: world.getObjects()){
                if(o.equals(c)){
                    items.add(c);
                }
            }
            if(items.size()==1) {
                o = items.get((int) (Math.random() * items.size()));
            }
            else{
                o = items.get(0);
            }
            if (Math.random() <= o.getVisibility()) {
                System.out.println(this.name + " нашёл " + o.getName() + "!!!");
                this.addInventory(world.getObjects().get(world.getObjects().indexOf(o)));
                world.deleteObj(o);
            }
        }
    }

    @Override
    public int hashCode() {
        return weight.hashCode() + name.hashCode() + intellect.hashCode() + type.hashCode() + state.hashCode();
    }

    public boolean equals(Object o) {
        return o instanceof SomeObj && o.hashCode() == this.hashCode();
    }
}
