package ElementClasses;

public class Car implements Comparable<Car> {
    private final String carName;
    private boolean cool;
    private static final String[] coolCars = new String[]{"Honda", "Porsche", "Lamborghini", "Mustang", "Ferrari", "Bugatti", "Tesla", "Audi", "BMW", "Mercedes"};

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

    public String getCarName() {
        return carName;
    }

    public boolean isCool() {
        return cool;
    }

    //if you think a car is cool, it`s your problem but OK I`ll let you change cool status
    public void setCool(boolean cool) {
        this.cool = cool;
    }

    public int compareTo(Car o) {
        if (this.cool && !o.isCool()) {
            return 1;
        } else if (!this.cool && o.isCool()) {
            return -1;
        } else {
            return this.carName.compareTo(o.getCarName());
        }
    }

    public String toString(){
        return this.carName;
    }
}
