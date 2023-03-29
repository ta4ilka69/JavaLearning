package ElementClasses;

/**
 * Class for cars elements. Setters and getters for class fields. Is comparable.
 */
public class Car implements Comparable<Car> {
    /**
     * Car name.
     */
    private final String carName;
    /**
     * Car can be cool or not.
     */
    private boolean cool;
    /**
     * Static array of cool cars. Cool status can be changed, but it is only in your mind and in this lab.
     */
    private static final String[] coolCars = new String[]{"Honda", "Porsche", "Lamborghini", "Mustang", "Ferrari", "Bugatti", "Tesla", "Audi", "BMW", "Mercedes"};

    /**
     * Sets fields. Cool status is set automatically, if you want to change it, use special setter.
     * @param carName sets the car name and define if car is cool or not (if it is in coolCars array)
     */
    public Car(String carName) {
        if (carName == null) {
            throw new NullPointerException("Car name cannot be null");
        }
        this.carName = carName;
        this.cool = false;
        for (String coolCar : coolCars) {
            if (coolCar.equals(carName)) {
                this.cool = true;
                break;
            }
        }
    }

    /**
     * @return car name field.
     */
    public String getCarName() {
        return carName;
    }

    /**
     * @return cool status of car.
     */
    public boolean isCool() {
        return cool;
    }

    /**
     * if you think a car is cool, it`s your problem but OK I`ll let you change cool status...
     * @param cool sets cool status of car to given one.
     */
    public void setCool(boolean cool) {
        this.cool = cool;
    }

    /**
     * Comparing first by cool status, only after by name.
     * @param o the car object to be compared.
     * @return 1 if this car if better than given, -1 if worse, 0 if in same condition.
     */
    public int compareTo(Car o) {
        if (this.cool && !o.isCool()) {
            return 1;
        } else if (!this.cool && o.isCool()) {
            return -1;
        } else {
            return this.carName.compareTo(o.getCarName());
        }
    }

    /**
     * @return string interpretation of car (with name and cool status).
     */
    public String toString() {
        return this.carName + " " + this.cool;
    }
}
