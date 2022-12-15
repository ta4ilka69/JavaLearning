package Objects;

import Abstract.AliveType;
import Abstract.State;

public class Breach extends SomeObj{
    private River r;
    public Breach(String name, Double weight,River r){
        super(weight,name, AliveType.Lifeless, State.Stay);
        this.r = r;
        System.out.println("Создан мост "+name+" через реку "+r.getName()+".");
    }
}
