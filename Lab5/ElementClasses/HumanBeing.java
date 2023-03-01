package ElementClasses;


import org.jetbrains.annotations.NotNull;

import java.util.Date;

public class HumanBeing implements Comparable<HumanBeing> {
    private final Integer id;
    private String name;
    private Coordinates coordinates;
    private Date creationDate;
    private Boolean realHero;
    private Boolean hasToothpick;
    private Integer impactSpeed;
    private String soundtrackName;
    private float minutesOfWaiting;
    private WeaponType weaponType;
    private Car car;

    public HumanBeing(
            Integer id,
            String name,
            Coordinates coordinates,
            Date creationDate,
            Boolean realHero,
            Boolean hasToothpick,
            Integer impactSpeed,
            String soundtrackName,
            float minutesOfWaiting,
            WeaponType weaponType,
            String car
    ) {
        if (id < 0 || name.equals("") || name == null || coordinates == null || creationDate == null || realHero == null || hasToothpick == null || impactSpeed == null || soundtrackName == null || car == null) {
            throw new IllegalArgumentException("Значение некоторых аргументов не может быть null или пустым");
        }
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.realHero = realHero;
        this.hasToothpick = hasToothpick;
        this.impactSpeed = impactSpeed;
        this.soundtrackName = soundtrackName;
        this.minutesOfWaiting = minutesOfWaiting;
        this.weaponType = weaponType;
        this.car = new Car(car);
    }

    public HumanBeing(Integer id,
                      String name,
                      float x, Double y,
                      Boolean realHero,
                      Boolean hasToothpick,
                      Integer impactSpeed,
                      String soundtrackName,
                      float minutesOfWaiting,
                      WeaponType weaponType,
                      String car) {
        this.id = id;
        new HumanBeing(id, name, new Coordinates(x, y), new Date(), realHero, hasToothpick, impactSpeed, soundtrackName, minutesOfWaiting, weaponType, car);
    }

    public int compareTo(@NotNull HumanBeing humanBeing) {
        return Integer.signum(this.id.compareTo(humanBeing.getId()) + this.name.compareTo(humanBeing.getName()) + this.coordinates.compareTo(humanBeing.getCoordinates()) + this.creationDate.compareTo(humanBeing.getCreationDate()) + this.realHero.compareTo(humanBeing.getRealHero()) + this.hasToothpick.compareTo(humanBeing.getHasToothpick()) + this.impactSpeed.compareTo(humanBeing.getImpactSpeed()) + this.soundtrackName.compareTo(humanBeing.getSoundtrackName()) + Float.compare(this.minutesOfWaiting, humanBeing.getMinutesOfWaiting()) + this.weaponType.compareTo(humanBeing.getWeaponType()) + this.car.compareTo(humanBeing.getCar()));
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

    public float getMinutesOfWaiting() {
        return minutesOfWaiting;
    }

    public Integer getImpactSpeed() {
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

    public void setImpactSpeed(Integer impactSpeed) {
        this.impactSpeed = impactSpeed;
    }

    public void setMinutesOfWaiting(float minutesOfWaiting) {
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
}
