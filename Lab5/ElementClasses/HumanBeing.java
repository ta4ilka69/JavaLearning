package ElementClasses;


import java.util.Date;

public class HumanBeing implements Comparable<HumanBeing> {
    private int id;
    private String name;
    private Coordinates coordinates;
    private Date creationDate;
    private Boolean realHero;
    private Boolean hasToothpick;
    private Float impactSpeed;
    private String soundtrackName;
    private double minutesOfWaiting;
    private WeaponType weaponType;
    private Car car;

    public HumanBeing(
            Integer id,
            String name,
            Coordinates coordinates,
            Boolean realHero,
            Boolean hasToothpick,
            Float impactSpeed,
            String soundtrackName,
            double minutesOfWaiting,
            WeaponType weaponType,
            String car
    ) {
        if (id < 0 || name.equals("") || coordinates == null || realHero == null || impactSpeed == null || soundtrackName == null || car == null) {
            throw new IllegalArgumentException("Значение некоторых аргументов не может быть null или пустым");
        }
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = new Date();
        this.realHero = realHero;
        this.hasToothpick = hasToothpick;
        this.impactSpeed = impactSpeed;
        this.soundtrackName = soundtrackName;
        this.minutesOfWaiting = minutesOfWaiting;
        this.weaponType = weaponType;
        this.car = new Car(car);
    }

    public int compareTo(HumanBeing humanBeing) {
        return Integer.compare(this.id,humanBeing.getId());
        //return Integer.signum(Integer.compare(this.id, humanBeing.id) + this.name.compareTo(humanBeing.getName()) + this.coordinates.compareTo(humanBeing.getCoordinates()) + this.creationDate.compareTo(humanBeing.getCreationDate()) + this.realHero.compareTo(humanBeing.getRealHero())  + this.impactSpeed.compareTo(humanBeing.getImpactSpeed()) + this.soundtrackName.compareTo(humanBeing.getSoundtrackName()) + Double.compare(this.minutesOfWaiting, humanBeing.getMinutesOfWaiting()) + this.weaponType.compareTo(humanBeing.getWeaponType()) + this.car.compareTo(humanBeing.getCar()));
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Boolean getHasToothpick() {
        return hasToothpick;
    }

    public Integer getId() {
        return id;
    }

    public Boolean getRealHero() {
        return realHero;
    }

    public Car getCar() {
        return car;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public double getMinutesOfWaiting() {
        return minutesOfWaiting;
    }

    public Float getImpactSpeed() {
        return impactSpeed;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public String getSoundtrackName() {
        return soundtrackName;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setHasToothpick(Boolean hasToothpick) {
        this.hasToothpick = hasToothpick;
    }

    public void setImpactSpeed(Float impactSpeed) {
        this.impactSpeed = impactSpeed;
    }

    public void setMinutesOfWaiting(double minutesOfWaiting) {
        this.minutesOfWaiting = minutesOfWaiting;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRealHero(Boolean realHero) {
        this.realHero = realHero;
    }

    public void setSoundtrackName(String soundtrackName) {
        this.soundtrackName = soundtrackName;
    }

    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    @Override
    public String toString() {
        return this.id+" " + this.name + " " + this.coordinates.xToString()+ ";"+ this.coordinates.yToString()+" "+creationDate.toString()+" "+realHero+" "+hasToothpick+" "+impactSpeed.toString()+ " "+ soundtrackName+" "+ minutesOfWaiting+ " "+ weaponType.toString()+" "+ car.toString();
    }
}
