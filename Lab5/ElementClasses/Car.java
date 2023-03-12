package ElementClasses;

public class Car implements Comparable<Car> {
    private final String name;
    private boolean cool;
    private static final String[] coolCars = new String[]{"Honda", "Porsche", "Lamborghini", "Mustang", "Ferrari", "Bugatti", "Tesla", "Audi", "BMW", "Mercedes"};

    public Car(String name) {
        if (name==null) {
            throw new NullPointerException("Car name cannot be null");
        }
        this.name = name;
        this.cool = false;
        for (String coolCar : coolCars) {
            if (coolCar.equals(name)) {
                this.cool = true;
                break;
            }
        }
    }

    public String getName() {
        return name;
    }
    public boolean isCool() {
        return cool;
    }

    public int compareTo(Car o) {
        if (this.cool && !o.isCool()) {
            return 1;
        } else if (!this.cool && o.isCool()) {
            return -1;
        } else {
            return this.name.compareTo(o.getName());
        }
    }

    public String toString(){
        return this.name;
    }
}
