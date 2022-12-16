package Objects;

import Abstract.AliveType;
import Abstract.State;

public class Breach extends SomeObj{
    private final River r;
    public Breach(String name, Double weight, Double density,River r){
        super(weight,density,name, AliveType.Lifeless, State.Stay);
        this.r = r;
        System.out.println("Создан мост "+name+" через реку "+this.r.getName()+".");
    }
}
