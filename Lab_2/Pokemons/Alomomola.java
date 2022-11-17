package Pokemons;

import ru.ifmo.se.pokemon.*;


public final class Alomomola extends Pokemon {
    public Alomomola(String name, int level) {
        super(name, level);
        this.setStats(165.0, 75.0, 80.0, 40.0, 45.0, 65.0);
        this.setType(Type.WATER);
    }
}
