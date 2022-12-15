package World;

import Abstract.AliveType;
import Abstract.State;

public interface Thing {
    default double getWeight() {
        return 0;
    }

    default String getName() {
        return "Безымянный";
    }

    default AliveType getType() {
        return AliveType.Substance;
    }

    default State getState(){
        return State.Undefined;
    }
}
