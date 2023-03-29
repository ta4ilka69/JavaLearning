package ElementClasses;


import java.util.Date;

/**
 * Class as element of collection. Something like human.
 * All getters and setters are given for fields.
 */
public class HumanBeing implements Comparable<HumanBeing> {
    /**
     * Primary key for object. Must be >= 1.
     */
    private int id;
    /**
     * Name of human or whatever it is.
     */
    private String name;
    /**
     * Coordinates of this creature.
     * @see Coordinates
     */
    private Coordinates coordinates;
    /**
     * Date when was created.
     */
    private Date creationDate;
    /**
     * Is he a hero for someone?
     */
    private Boolean realHero;
    /**
     * Every real hero must have it. Ryan Gosling and Sylvester Stallone (C). May be null.
     */
    private Boolean hasToothpick;
    /**
     * That means speed of hit/punch. Make infinity for Mohammed Ali
     */
    private Float impactSpeed;
    /**
     * Make "Where Is My Mind" for Tyler Durden, "Nightcall" for Ryan Gosling,
     */
    private String soundtrackName;
    /**
     * Waiting for something or someone. Or something.
     */
    private double minutesOfWaiting;
    /**
     * Weapon for self safety. May be null if no weapon.
     */
    private WeaponType weaponType;
    /**
     * Car for real hero. Can not be null of course!
     * @see Car
     */
    private Car car;

    /**
     * Constructor for class.
     * @param id sets id.
     * @param name sets name.
     * @param coordinates sets location.
     * @param realHero sets if he is real hero.
     * @param hasToothpick sets if object has toothpick.
     * @param impactSpeed sets impactSpeed.
     * @param soundtrackName sets soundtrackName.
     * @param minutesOfWaiting sets minutesOfWaiting.
     * @param weaponType sets weapon for our hero.
     * @param car sets car for hero.
     * @throws IllegalArgumentException when some arguments are null and banned for null or id less than 1.
     */
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

    /**
     * Compare human by some fields.
     * @param humanBeing the object to be compared.
     * @return 1 if this better than given, -1 if worse, 0 if same.
     */
    public int compareTo(HumanBeing humanBeing) {
        //return Integer.compare(this.id, humanBeing.getId());
        return Integer.signum(Integer.compare(this.id, humanBeing.id) + this.name.compareTo(humanBeing.getName()) + this.coordinates.compareTo(humanBeing.getCoordinates()) + this.creationDate.compareTo(humanBeing.getCreationDate()) + this.realHero.compareTo(humanBeing.getRealHero())  + this.impactSpeed.compareTo(humanBeing.getImpactSpeed()) + this.soundtrackName.compareTo(humanBeing.getSoundtrackName()) + Double.compare(this.minutesOfWaiting, humanBeing.getMinutesOfWaiting()) + this.weaponType.compareTo(humanBeing.getWeaponType()) + this.car.compareTo(humanBeing.getCar()));
    }

    /**
     * @param id setter for id.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter for name.
     * @return name field.
     */
    public String getName() {
        return name;
    }
    /**
     * Getter for toothpick.
     * @return hasToothPick field.
     */
    public Boolean getHasToothpick() {
        return hasToothpick;
    }
    /**
     * Getter for id.
     * @return id field.
     */
    public Integer getId() {
        return id;
    }
    /**
     * Getter for realHero.
     * @return realHero field.
     */
    public Boolean getRealHero() {
        return realHero;
    }

    /**
     * Getter for car.
     * @return Car field.
     */
    public Car getCar() {
        return car;
    }

    /**
     * Getter for location.
     * @return coordinates field.
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * Getter for how much he is waiting.
     * @return minutesOfWaiting field.
     */
    public double getMinutesOfWaiting() {
        return minutesOfWaiting;
    }

    /**
     * Getter for speed of punch.
     * @return impactSpeed field.
     */
    public Float getImpactSpeed() {
        return impactSpeed;
    }

    /**
     * Getter for when was created.
     * @return creationDate field.
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * Getter for soundtrack.
     * @return soundtrackName field.
     */
    public String getSoundtrackName() {
        return soundtrackName;
    }

    /**
     * Getter for weapon.
     * @return weaponType field.
     */
    public WeaponType getWeaponType() {
        return weaponType;
    }

    /**
     * @param car setter for car.
     */
    public void setCar(Car car) {
        this.car = car;
    }

    /**
     * @param coordinates setter for coordinates.
     */
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    /**
     * @param creationDate setter for creation date.
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * @param hasToothpick setter for hasToothPick.
     */
    public void setHasToothpick(Boolean hasToothpick) {
        this.hasToothpick = hasToothpick;
    }

    /**
     * @param impactSpeed setter for speed of punch.
     */
    public void setImpactSpeed(Float impactSpeed) {
        this.impactSpeed = impactSpeed;
    }

    /**
     * @param minutesOfWaiting setter for minutes of waiting.
     */
    public void setMinutesOfWaiting(double minutesOfWaiting) {
        this.minutesOfWaiting = minutesOfWaiting;
    }

    /**
     * @param name setter for name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param realHero setter for real hero.
     */
    public void setRealHero(Boolean realHero) {
        this.realHero = realHero;
    }

    /**
     * @param soundtrackName setter for soundtrack.
     */
    public void setSoundtrackName(String soundtrackName) {
        this.soundtrackName = soundtrackName;
    }

    /**
     * @param weaponType setter for weapon type.
     */
    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    /**
     * @return string interpretation of object with all fields in a row.
     */
    @Override
    public String toString() {
        String weap;
        if (weaponType == null) {
            weap = "null";
        } else {
            weap = weaponType.toString();
        }
        return this.id + " " + this.name + " " + this.coordinates.xToString() + ";" + this.coordinates.yToString() + " " + creationDate.toString() + " " + realHero + " " + hasToothpick + " " + impactSpeed.toString() + " " + soundtrackName + " " + minutesOfWaiting + " " + weap + " " + car.toString();
    }
}
