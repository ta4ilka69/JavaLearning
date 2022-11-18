import Pokemons.*;
import ru.ifmo.se.pokemon.*;

public class Lab2 {
    public static void main(String[] args) {
        Battle b = new Battle();
        Alomomola p1 = new Alomomola("Скрыга", 33);
        Yanma p2 = new Yanma("Трупоед", 36);
        Yanmega p3 = new Yanmega("Волколак", 43);
        Oddish p4 = new Oddish("Волк",45);
        Vileplume p5 = new Vileplume("Вожак",33);
        Gloom p6 = new Gloom("Вампир",33);
        b.addAlly(p1);
        b.addAlly(p3);
        b.addAlly(p5);
        b.addFoe(p2);
        b.addFoe(p4);
        b.addFoe(p6);
        b.go();
    }
}
