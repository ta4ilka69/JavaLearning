package ElementClasses;


public class Coordinates implements Comparable<Coordinates> {
    private final float x;
    private final Double y;

    public Coordinates(float x, Double y) {
        if (x>316) throw new IllegalArgumentException("Значение поля координаты x должно быть меньше 316");
        this.x = x;
        this.y = y;
    }
    public float getX() {
        return x;
    }
    public Double getY() {
        return y;
    }
    public int compareTo(Coordinates coordinates) {
        return Integer.signum(Float.compare(this.x, coordinates.getX()) + this.y.compareTo(coordinates.getY()));
    }

    public String toString(){
        return Float.toString(this.getX())+";"+Double.toString(this.getY());
    }
}
