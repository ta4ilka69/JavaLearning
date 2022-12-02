package Creatures;

import Abstract.AliveType;
import Abstract.Intellect;
import Abstract.State;

public class Rabbit extends SomeCreature{
    public Rabbit(String name, double weight, Intellect intellect, AliveType type, State state){
        super(name, weight, intellect, type, state);
        printCreate();
    }

    private void printCreate(){
        System.out.println("Создан кролик по имени: "+this.getName()+".");
    }
}
