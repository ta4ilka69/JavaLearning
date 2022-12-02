package World;

import Abstract.Battle;
import Abstract.Game;
import Abstract.State;
import Creatures.SomeCreature;
import Objects.River;
import Objects.SomeObj;

import java.util.ArrayList;

public class World {
    private final ArrayList<SomeObj> Objects;

    private final ArrayList<Game> Games;

    private final ArrayList<Battle> Battles;
    private final ArrayList<SomeCreature> Creatures;
    private Gravity g;

    public World(Gravity g) {
        System.out.println("Создан мир!");
        this.setGravity(g);
        Objects = new ArrayList<>();
        Creatures = new ArrayList<>();
        Games = new ArrayList<>();
        Battles = new ArrayList<>();
    }

    public void setGravity(Gravity g) {
        System.out.println("Гравитация установлена на уровне " + g.toString()+".");
        if (g == Gravity.Zero) {
            for (SomeCreature c : this.Creatures) {
                if (c.getState() != State.Fly) {
                    c.setState(State.Levitate);
                }
            }
            for (SomeObj obj : this.Objects) {
                if (obj.getState() != State.Fly) {
                    obj.setState(State.Levitate);
                }
            }
        } else {
            if (this.g == Gravity.High && g == Gravity.Low) {
                for (SomeObj o : this.Objects) {
                    if(o.getState()==State.FastFall){
                        o.setState(State.Fall);
                    }
                }
                for (SomeCreature c : this.Creatures) {
                    if(c.getState()==State.FastFall){
                        c.setState(State.Fall);
                    }
                }
            } else if (this.g == Gravity.Low && g==Gravity.High) {
                for (SomeObj o : this.Objects) {
                    if(o.getState()==State.Fall){
                        o.setState(State.FastFall);
                    }
                }
                for (SomeCreature c : this.Creatures) {
                    if(c.getState()==State.Fall){
                        c.setState(State.FastFall);
                    }
                }

            } else if (g==Gravity.High && this.g==Gravity.Zero) {
                for (SomeObj o : this.Objects) {
                    if(o.getState()==State.Levitate){
                        o.setState(State.FastFall);
                    }
                }
                for (SomeCreature c : this.Creatures) {
                    if(c.getState()==State.Levitate){
                        c.setState(State.FastFall);
                    }
                }
            }
            else if (g==Gravity.Low && this.g==Gravity.Zero) {
                for (SomeObj o : this.Objects) {
                    if(o.getState()==State.Levitate){
                        o.setState(State.Fall);
                    }
                }
                for (SomeCreature c : this.Creatures) {
                    if(c.getState()==State.Levitate){
                        c.setState(State.Fall);
                    }
                }
            }

        }
        this.g = g;
    }

    public Gravity getWorldGravity() {
        return this.g;
    }

    public void addObject(SomeObj obj) {
        this.Objects.add(obj);
        System.out.println("Объект "+obj.getName()+" добавлен в мир.");
        if(this.g == Gravity.Zero && obj.getState()!=State.Fly){
            obj.setState(State.Levitate);
        }
    }

    public void addCreature(SomeCreature c) {
        this.Creatures.add(c);
        System.out.println(c.getName()+" добавлен(а) в мир.");
        if(this.g == Gravity.Zero && c.getState()!=State.Fly){
            c.setState(State.Levitate);
        }
    }

    public ArrayList<SomeCreature> getCreatures() {
        return this.Creatures;
    }

    public ArrayList<SomeObj> getObjects() {
        return this.Objects;
    }

    public void newGame(Game g) {
        Games.add(g);
    }

    public void newBattle(Battle b) {
        Battles.add(b);
    }

    public ArrayList<Battle> getBattles() {
        return this.Battles;
    }

    public ArrayList<Game> getGames() {
        return this.Games;
    }

    public void deleteObj(SomeObj o){
        this.Objects.remove(o);
    }

    public void addOject(River river) {
        this.Objects.add(river);
    }

    public String toString(){
        return "G: "+this.g+"; Objects: "+this.Objects.toString()+"; Creatures: "+this.Creatures.toString();
    }
}
