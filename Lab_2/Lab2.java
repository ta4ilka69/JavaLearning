import Pokemons.*;
import ru.ifmo.se.pokemon.*;

public class Lab2 {
    public static void main(String[] args) {
        Battle b = new Battle();
        Alomomola p1 = new Alomomola("Скрыга", 17);
        Yanma p2 = new Yanma("Трупоед", 17);
        Yanmega p3 = new Yanmega("Волколак", 17);
        Oddish p4 = new Oddish("Волк",20);
        Vileplume p5 = new Vileplume("Вожак",17);
        Gloom p6 = new Gloom("Вампир",17);
        b.addAlly(p1);
        b.addAlly(p3);
        b.addAlly(p5);
        b.addFoe(p2);
        b.addFoe(p4);
        b.addFoe(p6);
        b.go();
    }
}
