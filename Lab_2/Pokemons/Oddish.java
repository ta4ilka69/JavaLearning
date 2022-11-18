package Pokemons;

import Moves.PhysicalMoves.Facade;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Oddish extends Pokemon {
    public Oddish(String name, int level) {
        super(name, level);
        this.setType(Type.POISON, Type.GRASS);
        this.setStats(45.0, 50.0, 55.0, 75.0, 65.0, 30.0);
        this.addMove(new Facade(70.0, 100.0));
    }
}
