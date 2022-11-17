import Pokemons.Yanmega;
import ru.ifmo.se.pokemon.*;
import Pokemons.Alomomola;
import Pokemons.Yanma;

public class Lab2 {
    public static void main(String[] args) {
        Battle b = new Battle();
        Alomomola p1 = new Alomomola("Русский", 17);
        Yanma p2 = new Yanma("Пендос", 33);
        Yanmega p3 = new Yanmega("Бог", 43);
        b.addAlly(p1);
        b.addAlly(p3);
        b.addFoe(p2);
        b.go();
    }
}
