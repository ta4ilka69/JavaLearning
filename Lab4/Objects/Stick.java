package Objects;

import Abstract.AliveType;
import Abstract.State;

public class Stick extends SomeObj {
    public Stick() {
        //Always one weight of stick - such a mystery...

        super(1.0, "Палка", AliveType.Lifeless, State.Lay);
    }

    public boolean equals(){
        return true;
    }

}
