package World;

import State.AliveType;

public interface Thing {
    default double getWeight(){
        return 0;
    }

    default  String getName(){
        return "Безымянный";
    }

    default AliveType getType(){
        return AliveType.Substance;
    }
}
