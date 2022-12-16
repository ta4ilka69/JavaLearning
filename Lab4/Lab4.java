import Abstract.*;
import Creatures.SomeCreature;
import Objects.Breach;
import Objects.River;
import Objects.StickStageTwo;
import World.World;
import World.Gravity;


public class Lab4 {
    public static void main(String[] args) {
        //Creating World
        World world = new World(Gravity.High);
        //Creating Creatures
        SomeCreature Pyx = new SomeCreature("Винни-Пух", 120.0, Intellect.Stupid, AliveType.Alive, State.Stay);
        world.addCreature(Pyx);
        SomeCreature Pyatachok = new SomeCreature("Пятачок", 30.0, Intellect.Stupid, AliveType.Alive, State.Stay);
        world.addCreature(Pyatachok);
        SomeCreature RuSmall = new SomeCreature("Крошка Ру", 60.0, Intellect.Stupid, AliveType.Alive, State.Stay);
        world.addCreature(RuSmall);
        SomeCreature rabbit = new SomeCreature("Кролик", 10.0, Intellect.Stupid, AliveType.Alive, State.Stay);
        world.addCreature(rabbit);
        River river = new River("Река", 10.0, State.Lazy, "ВЕЛИКАЯ ЦЕЛЬ");
        world.addOject(river);
        Breach breach = new Breach("Дворцовый мост", 100000.0, 3000.0, river);
        world.addObject(breach);
        //prequel




        //Creating game
        Game strangeOne = new Game("Пушишки", "Игроки бросают в Реку шишки по команде Кролика; чья шишка всплывёт первой, тот и победил.", Pyx, Intellect.Stupid);
        world.newGame(strangeOne);

        //Teaching
        Pyx.Teaching(strangeOne, Pyatachok);
        Pyx.Teaching(strangeOne, RuSmall);
        Pyx.Teaching(strangeOne, rabbit);

        //Change rules and name of the game
        strangeOne.setDescription(strangeOne.getDescription().replace("шишк", "палк"));
        strangeOne.setName("Игра в Пустяки");


        //Собственно, Battle (добавим 4 палки в мир, чтобы было, чем играть)
        StickStageTwo stick1 = new StickStageTwo(3000.,3.,0.001);
        StickStageTwo stick2 = new StickStageTwo(999.,2.5,0.002);
        StickStageTwo stick3 = new StickStageTwo(500.,3.5,0.004);
        StickStageTwo stick4 = new StickStageTwo(1.,4.5,0.001);
        world.addObject(stick1);
        world.addObject(stick2);
        world.addObject(stick3);
        world.addObject(stick4);
        //Теперь точно Battle
        PustyakBattle boy = new PustyakBattle(strangeOne, world.getCreatures(), world, stick2 , river, breach);
        world.newBattle(boy);
        //Бред какой-то, ну ладно🤷‍
        river.setState(State.ForgetTarget);
    }
}
