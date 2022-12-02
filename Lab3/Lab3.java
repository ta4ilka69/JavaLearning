import Abstract.*;
import Creatures.Bear;
import Creatures.Kenguru;
import Creatures.Pig;
import Creatures.Rabbit;
import Objects.River;
import Objects.Stick;
import World.World;
import World.Gravity;

import java.util.ArrayList;

public class Lab3 {
    public static void main(String[] args) {
        //Creating World
        World world = new World(Gravity.High);

        //Creating Creatures
        Bear Pyx = new Bear("Винни-Пух", 120, AliveType.Alive, Intellect.Clever, State.Stay);
        world.addCreature(Pyx);
        Pig Pyatachok = new Pig("Пятачок", 30, AliveType.Alive, Intellect.Stupid, State.Stay);
        world.addCreature(Pyatachok);
        Kenguru RuSmall = new Kenguru("Крошка Ру", 60,AliveType.Alive,Intellect.Stupid,State.Stay);
        world.addCreature(RuSmall);
        Rabbit rabbit = new Rabbit("Кролик",10,Intellect.Stupid,AliveType.Alive,State.Stay);
        world.addCreature(rabbit);

        //Creating game
        Game strangeOne = new Game("Пушишки","Игроки бросают в Реку шишки по команде Кролика; чья шишка всплывёт первой, тот и победил.", Pyx,Intellect.Stupid);
        world.newGame(strangeOne);

        //Teaching
        Pyx.Teaching(strangeOne,Pyatachok);
        Pyx.Teaching(strangeOne,RuSmall);
        Pyx.Teaching(strangeOne,rabbit);

        //Change rules and name of the game
        strangeOne.setDescription(strangeOne.getDescription().replace("шишк", "палк"));
        strangeOne.setName("Игра в Пустяки");


        //Собственно, Battle (добавим 4 палки в мир, чтобы было, чем играть)

        Stick stick1 = new Stick();
        Stick stick2 = new Stick();
        Stick stick3 = new Stick();
        Stick stick4 = new Stick();
        world.addObject(stick1);
        world.addObject(stick2);
        world.addObject(stick3);
        world.addObject(stick4);
        River river = new River("Река",State.Lazy,"ВЕЛИКАЯ ЦЕЛЬ");
        world.addOject(river);
        //Теперь точно Battle

        PustyakBattle boy = new PustyakBattle(strangeOne,world.getCreatures(),world,new Stick(),river);
    }
}
