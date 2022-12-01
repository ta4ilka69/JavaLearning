package State;

public enum Intellect {
    Zero(0.0),
    Stupid(5.0),
    Clever(10.0);

    private final double intellect;

    Intellect(double intellect){
        this.intellect = intellect;
    }

}
