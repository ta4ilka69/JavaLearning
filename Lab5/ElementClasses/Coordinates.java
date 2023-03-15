package ElementClasses;


public class Coordinates implements Comparable<Coordinates> {
    private final double x;
    private final long y;

    public Coordinates(double x, long y) {
        if (x > 316) throw new IllegalArgumentException("Значение поля координаты x должно быть меньше 316");
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public long getY() {
        return y;
    }

    public int compareTo(Coordinates coordinates) {
        return Integer.signum(Double.compare(this.x, coordinates.getX()) + Long.compare(coordinates.getY(), this.y));
    }

    public String xToString() {
        return Double.toString(x);
    }

    public String yToString() {
        return Long.toString(y);
    }
}
