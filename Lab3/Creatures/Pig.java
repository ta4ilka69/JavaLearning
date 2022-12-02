package Creatures;

import Abstract.AliveType;
import Abstract.Intellect;
import Abstract.State;

public class Pig extends SomeCreature{
    public Pig(String name, double weight,AliveType type,Intellect intellect, State state){
        super(name,weight,intellect,type,state);
        printCreate();
    }

    private void printCreate(){
        System.out.println("Создана свинья по имени: "+this.getName()+".");
    }
}
