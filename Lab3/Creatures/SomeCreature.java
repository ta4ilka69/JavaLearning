package Creatures;

import Abstract.AliveType;
import Abstract.Game;
import Abstract.Intellect;
import Abstract.State;
import World.Thing;

import java.util.ArrayList;

public abstract class SomeCreature implements Thing {
    private final String name;
    private final double weight;
    private final Intellect intellect;
    private final AliveType type;
    private State state;

    private ArrayList<Game> knownGames;

    public SomeCreature(String name, double weight, Intellect intellect, AliveType type, State state){
        this.name = name;
        this.intellect = intellect;
        this.type = type;
        this.weight = weight;
        this.knownGames = new ArrayList<>();
        this.state = state;
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
        System.out.println(this.getName()+" "+t.getState()+".");
    }

    public String toString(){
        return "Создание с именем: "+this.getName()+", с весом: "+this.getWeight()+", с интеллектом: "+this.getIntellect()+". Находится в состоянии: "+this.getState()+". Знает игры: "+this.getKnownGames().toString();
    }

    private void printCreate(){
        System.out.println("Создан(-а,о) создание с именем: "+this.getName());
    }

    public void selfLearn(Game g){
        this.addKnownGame(g);
        System.out.println(this.name+" теперь знает игру "+g.getName());
    }

    public void Teaching(Game g, SomeCreature learner){
        if(this.getKnownGames().contains(g) && learner.getIntellect().getIntellect() >= g.getIQMinimum().getIntellect()){
            learner.addKnownGame(g);
        }
    }
}
