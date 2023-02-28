package Collection;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HumanBeing {
    private Integer id;
    private String name;
    private Coordinates coordinates;
    private java.time.LocalDate creationDate;
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
            float x,
            Double y,
            Boolean realHero,
            Boolean hasToothpick,
            Integer impactSpeed,
            String soundtrackName,
            float minutesOfWaiting,
            WeaponType weaponType,
            Car car
    ) {
        this.id = id;
        this.name = name;
        this.coordinates = new Coordinates(x,y);
        this.creationDate = LocalDate.now();
        this.realHero = realHero;
        this.hasToothpick = hasToothpick;
        this.impactSpeed = impactSpeed;
        this.soundtrackName = soundtrackName;
        this.minutesOfWaiting = minutesOfWaiting;
        this.weaponType = weaponType;
        this.car = car;

    }

    public class Coordinates {
        private float x;
        private Double y;
        public Coordinates(float x, Double y){
            this.x = x;
            this.y = y;
        }
    }

    public class Car {
        private String name;
        private boolean cool;
        private static List<String> coolCars = new ArrayList<>();
        public Car(String name){
            this.name = name;
        }
    }

    public enum WeaponType {
        AXE,
        RIFLE,
        MACHINE_GUN
    }
}
