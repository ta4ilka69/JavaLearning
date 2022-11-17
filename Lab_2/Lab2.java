import ru.ifmo.se.pokemon.*;
import Pokemons.Alomomola.Alomomola;
import Pokemons.Yanma.Yanma;
public class Lab2 {
    public static void main(String[] args){
        Battle b = new Battle();
        Alomomola p1 = new Alomomola("Скрыга",17);
        Yanma p2 = new Yanma("Хуесос",33);
        b.addAlly(p1);
        b.addFoe(p2);
        b.go();
    }
}
