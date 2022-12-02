package Creatures;

import Abstract.AliveType;
import Abstract.Game;
import Abstract.Intellect;
import Abstract.State;
import Objects.SomeObj;
import World.Thing;
import World.World;

import java.util.ArrayList;

public abstract class SomeCreature implements Thing {
    private final String name;
    private final Double weight;
    private final Intellect intellect;
    private final AliveType type;
    private State state;

    private ArrayList<Game> knownGames;

    private ArrayList<SomeObj> inventory;

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

    public void deleteInventory(SomeObj o){
        if (this.inventory.contains(o)){
            this.inventory.remove(o);
        }
    }
    //PARAMetr of random
    public void search(SomeObj o, World world) {
        System.out.println(this.name+" ищет "+o.getName()+".");
        if (world.getObjects().contains(o)) {
            if(Math.random()<=0.8){
                System.out.println(this.name+" нашёл "+o.getName()+"!!!");
                this.addInventory(o);
                world.deleteObj(o);
            }
        }
    }

    @Override
    public int hashCode() {
        return weight.hashCode()+name.hashCode()+ intellect.hashCode()+type.hashCode()+ state.hashCode();
    }

    public boolean equals(Object o){
        return o instanceof SomeObj && o.hashCode()==this.hashCode();
    }
}
