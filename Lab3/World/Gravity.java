package World;

public enum Gravity {
    Zero(0), High(9.8), Low(4.9);
    private final double gravity;

    Gravity(double g){
        this.gravity = g;
    }
    public double getGravity() {
        return gravity;
    }

    @Override
    public String toString() {
        if(this.getGravity()==0){
            return "zero";
        } else if (this.getGravity()<9.8) {
            return "low";
        }
        else{
            return "high";
        }
    }
}
