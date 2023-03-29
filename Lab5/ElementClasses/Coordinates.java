package ElementClasses;

/**
 * Class for Coordinates object. Setters and getters for fields. Is Comparable.
 */
public class Coordinates implements Comparable<Coordinates> {
    /**
     * x coordinate (<316).
     */
    private final double x;
    /**
     * y coordinate
     */
    private final long y;

    /**
     * Constructor for class. Check if x>316.
     * @param x sets x coordinate.
     * @param y sets y coordinate.
     * @throws IllegalArgumentException when x>316.
     */
    public Coordinates(double x, long y) {
        if (x > 316) throw new IllegalArgumentException("Значение поля координаты x должно быть меньше 316");
        this.x = x;
        this.y = y;
    }

    /**
     * @return x coordinate.
     */
    public double getX() {
        return x;
    }

    /**
     * @return y coordinate.
     */
    public long getY() {
        return y;
    }

    /**
     * Comparing by x,y. If 0, could be mean as incomparable (x_1 bigger x_2 and y_1 less y_2).
     * @param coordinates the Coordinates object to be compared.
     * @return 1 if this is bigger than given, -1 if less, 0 if +-same.
     */
    public int compareTo(Coordinates coordinates) {
        return Integer.signum(Double.compare(this.x, coordinates.getX()) + Long.compare(coordinates.getY(), this.y));
    }

    /**
     * @return string of x.
     */
    public String xToString() {
        return Double.toString(x);
    }

    /**
     * @return string of y.
     */
    public String yToString() {
        return Long.toString(y);
    }
}
