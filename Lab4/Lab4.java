import Abstract.*;
import Creatures.SomeCreature;
import Exceptions.StageException;
import Objects.Breach;
import Objects.Cone;
import Objects.River;
import Objects.StickStageTwo;
import World.World;
import World.Gravity;

import java.util.ArrayList;


public class Lab4 {
    public static void main(String[] args) {
        //Creating World
        World world = new World(Gravity.High);
        //Creating Creatures and Objects
        var Pyx = new SomeCreature("Винни-Пух", 80.0, Intellect.Stupid, AliveType.Alive, State.Stay, Mood.Neutral) {
            private String goal;

            public void setGoal(String s) {
                this.goal = s;
                System.out.println("У " + this.getName() + " новая цель: " + s);
            }
        };
        world.addCreature(Pyx);
        SomeCreature Pyatachok = new SomeCreature("Пятачок", 30.0, Intellect.Clever, AliveType.Alive, State.Stay, Mood.Neutral);
        world.addCreature(Pyatachok);
        SomeCreature RuSmall = new SomeCreature("Крошка Ру", 60.0, Intellect.Clever, AliveType.Alive, State.Stay, Mood.Neutral);
        world.addCreature(RuSmall);
        SomeCreature Rabbit = new SomeCreature("Кролик", 10.0, Intellect.Clever, AliveType.Alive, State.Stay, Mood.Neutral);
        world.addCreature(Rabbit);
        River river = new River("Река", 10.0, State.Lazy, "ВЕЛИКАЯ ЦЕЛЬ");
        world.addOject(river);
        Breach breach = new Breach("мост", 100000.0, 3000.0, river);
        world.addObject(breach);
        var interactions = new ObjCreatureInteract() {
            public static void saw(ArrayList<SomeCreature> c, SomeCreature p) {
                String s = "";
                for (SomeCreature t : c) {
                    s += t.getName() + ", ";
                }
                s = s.substring(0, s.length() - 2);
                System.out.println(s + " увидели " + p.getName() + ", который " + p.getPosition());
            }
        };
        SomeCreature Ia = new SomeCreature("Иа-Иа", 100., Intellect.Clever, AliveType.Alive, State.Swim, Mood.Neutral);
        world.addCreature(Ia);
        Ia.setPosition("задрал в небо все 4 ноги");
        //prequel
        Cone cone0 = new Cone(2., 400.);
        Pyx.setRArm(cone0);
        ObjCreatureInteract.getCloserTo(Pyx, breach);
        river.popup();
        Game conesGame = new Game("Шишкокид", "закидываем шишками", Pyx);

        //Count of games with cones
        int roundsCount = (int) Math.round(Math.random() * 7 + 21) + 2;

        //Searching for this amount of cones
        for (int i = 0; i < roundsCount; i++) {
            if (i < 2) {
                world.addObject(new Cone(2. + Math.random() / 10, 300.));
                Pyx.search(new Cone(2., 300.), world);
            }
            world.addObject(new Cone(Math.random() * 4 + 1, Math.random() * 50 + 375));
        }
        while (Pyx.getInventory().size() != roundsCount) {
            Pyx.search(new Cone(4., 300.), world);
        }
        //playing
        ConeExperiment experiment = new ConeExperiment(conesGame, Pyx, river);
        int winTimes = 0;
        try {
            winTimes += experiment.start(1);
            winTimes += experiment.start(0);
            for (int i = 2; i <= (roundsCount / 2) - 1; i++) {
                winTimes += experiment.start(i);
            }
        } catch (StageException e) {
            System.out.println(e.getMessage());
        }


        if (winTimes > 0) {
            System.out.println(Pyx.getName() + " выиграл на " + winTimes + " раунда(-ов) больше, чем проиграл");
        } else if (winTimes < 0) {
            System.out.println(Pyx.getName() + " проиграл на " + (-winTimes) + " раунда(-ов) больше, чем выиграл");
        } else {
            System.out.println(Pyx.getName() + " вышел в 0 по раундам");
        }
        Pyx.setGoal("пойти домой и выпить чаю");
        //Creating game
        Game strangeOne = new Game("Пушишки", "Игроки бросают в Реку шишки по команде Кролика; чья шишка всплывёт первой, тот и победил.", Pyx, Intellect.Stupid);
        world.newGame(strangeOne);

        //Teaching
        Pyx.Teaching(strangeOne, Pyatachok);
        Pyx.Teaching(strangeOne, RuSmall);
        Pyx.Teaching(strangeOne, Rabbit);

        //Change rules and name of the game
        strangeOne.setDescription(strangeOne.getDescription().replace("шишк", "палк"));
        strangeOne.setName("Игра в Пустяки");

        //Собственно, Battle (добавим 4 палки в мир, чтобы было, чем играть)
        StickStageTwo stick1 = new StickStageTwo(3000., 3., 0.001);
        StickStageTwo stick2 = new StickStageTwo(999., 2.5, 0.002);
        StickStageTwo stick3 = new StickStageTwo(500., 3.5, 0.004);
        StickStageTwo stick4 = new StickStageTwo(451., 4.5, 0.001);
        world.addObject(stick1);
        world.addObject(stick2);
        world.addObject(stick3);
        world.addObject(stick4);
        ArrayList<SomeCreature> players = new ArrayList<>();
        players.add(Pyx);
        players.add(Pyatachok);
        players.add(Rabbit);
        players.add(RuSmall);
        //Теперь точно Battle
        PustyakBattle boy = new PustyakBattle(strangeOne, players, world, stick2, river, breach);
         world.newBattle(boy);
        //Бред какой-то, ну ладно🤷‍
        river.setState(State.ForgetTarget);


        //sequel

        Rabbit.setPosition("высунулся дальше всех");
        RuSmall.say("Палка, палка, поскорей! Палка, палка, поскорей!", Mood.Lively);
        ArrayList<SomeCreature> notSwim = new ArrayList<>();
        for (SomeCreature t : world.getCreatures()) {
            if (t.getState() != State.Swim) {
                notSwim.add(t);
            }
        }
        interactions.saw(notSwim, Ia);
        for (SomeCreature t : world.getCreatures()) {
            t.setState(State.Silent);
            t.setMood(Mood.Dreamy);
        }
        Pyx.setMood(Mood.Happy);
        Pyatachok.setMood(Mood.Thief);
    }
}
