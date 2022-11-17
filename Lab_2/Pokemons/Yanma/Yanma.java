package Pokemons.Yanma;
import ru.ifmo.se.pokemon.*;

public final class Yanma extends Pokemon{
    public Yanma(String name, int level){
        super(name,level);
        this.setStats(65.0,65.0,45.0,75.0,45.0,95.0);
        this.setType(Type.BUG,Type.FLYING);
    }
}
