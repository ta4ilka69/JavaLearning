package Objects;

import Abstract.AliveType;
import Abstract.State;

public class Cone extends SomeObj{
    public Cone(Double weight, Double density){
        super(weight,density,"шишка", AliveType.Lifeless, State.Lay);
    }

    public boolean equals(Object o){
        if(this.getOwner()==null) {
            return o instanceof Cone;
        }
        return (o instanceof Cone) && (this.getOwner()==((Cone) o).getOwner());
    }
}
