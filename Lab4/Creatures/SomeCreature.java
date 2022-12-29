package Creatures;

import Abstract.*;
import Objects.Cone;
import Objects.SomeObj;
import Objects.StickStageTwo;
import World.Thing;
import World.World;

import java.util.ArrayList;

public class SomeCreature implements Thing, Goal {
    private final String name;
    private final Double weight;
    private Intellect intellect;
    private final AliveType type;

    private String position;
    private State state;

    private Mood mood;
    private final ArrayList<Game> knownGames;
    private final Arms arms;

    private final ArrayList<SomeObj> inventory;

    public SomeCreature(String name, Double weight, Intellect intellect, AliveType type, State state, Mood m) {
        this.name = name;
        this.intellect = intellect;
        this.type = type;
        this.weight = weight;
        this.knownGames = new ArrayList<>();
        this.state = state;
        this.inventory = new ArrayList<>();
        this.mood = m;
        this.arms = new Arms(name);
        if (AliveType.Alive != type) {
            System.out.println("Ошибка: Невозможно создать неживое существо. (Воспользуйтесь магией и классом Someobj)");
            System.exit(1);
        }
        printCreate();
    }

    static class Arms {
        private SomeObj leftArm;
        private SomeObj rightArm;

        private final String name;

        public Arms(String head) {
            this.name = head;
        }

        public void setLeftArm(SomeObj leftArm) {
            this.leftArm = leftArm;
            if (rightArm != null) {
                System.out.println("У " + name + " в левой руке теперь " + rightArm.getName());
            } else {
                System.out.println("Левая рука пустая");
            }
        }

        public void setRightArm(SomeObj rightArm) {
            this.rightArm = rightArm;
            if (rightArm != null) {
                System.out.println("У " + name + " в правой руке теперь " + rightArm.getName());
            } else {
                System.out.println("Правая рука пустая");
            }
        }

        public SomeObj getLeftArm() {
            return leftArm;
        }

        public SomeObj getRightArm() {
            return rightArm;
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

    public void setPosition(String p){
        this.position = p;
        System.out.println(this.name+" "+p);
    }

    public String getPosition(){
        return this.position;
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

    public void setMood(Mood m) {
        this.mood = m;
        System.out.println(this.name+" стал "+m.getMood());
    }

    public Mood getMood() {
        return this.mood;
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
        if (!(o instanceof StickStageTwo || o instanceof Cone)) {
            //Don`t want to print all 100 messages with searching...
            System.out.println(this.name + " ищет " + o.getName() + ".");
        }
        if (world.getObjects().contains(o)) {
            ArrayList<SomeObj> items = new ArrayList<>();
            for (SomeObj c : world.getObjects()) {
                if (o.equals(c)) {
                    items.add(c);
                }
            }
            if (items.size() != 1) {
                o = items.get((int) (Math.random() * items.size()));
            } else {
                o = items.get(0);
            }
            if (Math.random() <= o.getVisibility()) {
                if (!(o instanceof StickStageTwo || o instanceof Cone)) {
                    System.out.println(this.name + " нашёл " + o.getName() + "!!!");
                }
                this.addInventory(world.getObjects().get(world.getObjects().indexOf(o)));
                world.deleteObj(o);
            }
        }
    }

    public void say(String s, Mood m){
        this.setMood(m);
        System.out.println(this.name+" говорит: \""+s+"\"");
    }

    public SomeObj getRArm() {
        return arms.getRightArm();
    }

    public SomeObj getLArm() {
        return arms.getLeftArm();
    }

    public void setLArm(SomeObj o) {
        arms.setLeftArm(o);
    }

    public void setRArm(SomeObj o) {
        arms.setRightArm(o);
    }

    public void setIntellect(Intellect i) {
        this.intellect = i;
    }

    @Override
    public int hashCode() {
        return weight.hashCode() + name.hashCode() + intellect.hashCode() + type.hashCode() + state.hashCode();
    }

    public boolean equals(Object o) {
        return o instanceof SomeObj && o.hashCode() == this.hashCode();
    }
}
