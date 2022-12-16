package Objects;

import Abstract.AliveType;
import Abstract.State;

public class StickStageTwo extends SomeObj {
    private final Double length;
    private final Double dia;

    public StickStageTwo(Double density, Double length, Double dia) {
        super(density*length*dia,density,"палка",AliveType.Lifeless,State.Lay);
        this.length = length;
        this.dia = dia;
    }

    public double getLength(){
        return this.length;
    }

    public double getDia(){
        return this.dia;
    }
    public boolean equals(Object o){
        return o instanceof StickStageTwo;
    }
}
