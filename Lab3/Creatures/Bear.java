package Creatures;

import Abstract.AliveType;
import Abstract.Intellect;
import Abstract.State;

public class Bear extends SomeCreature{
    public Bear(String name, double weight, AliveType type, Intellect intellect, State state){
        super(name, weight,intellect, type, state);
        printCreate();
    }

    private void printCreate(){
        System.out.println("Создан медведь по имени: "+this.getName()+".");
    }
}
