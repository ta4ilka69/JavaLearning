package Collection;

import ElementClasses.Car;
import ElementClasses.HumanBeing;

import java.util.*;

public class MyCollection {
    private PriorityQueue<HumanBeing> collection;
    private Date creationDate;
    private String pathToSave;

    private ArrayList<Integer> id;

    public MyCollection(String path) {
        this.collection = new PriorityQueue<>();
        this.pathToSave = path;
        creationDate = new Date();
        id = new ArrayList<>();
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void add(HumanBeing h) {
        if (id.contains(h.getId())) {
            h.setId(this.getFreeId());
        }
        this.collection.offer(h);
        this.id.add(h.getId());
    }

    public HumanBeing getElementById(int id) {
        HumanBeing[] l = new HumanBeing[this.getSize()];
        this.collection.toArray(l);
        for (HumanBeing t : l
        ) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }

    public int getSize() {
        return this.collection.size();
    }

    public void clear() {
        this.collection.clear();
    }

    public HumanBeing[] list() {
        HumanBeing[] res = new HumanBeing[this.getSize()];
        this.collection.toArray(res);
        return res;
    }

    public String getPathToSave() {
        return this.pathToSave;
    }

    private Integer[] getIds() {
        Integer[] res = new Integer[this.id.size()];
        this.id.toArray(res);
        return res;
    }

    public int getFreeId() {
        int i = 1;
        while (this.id.contains(i)) {
            i++;
        }
        this.id.add(i);
        return i;
    }

    public void printInfo() {
        System.out.println("Size: " + this.getSize());
        System.out.println("Type: " + this.collection.getClass());
        System.out.println("Date of initialization: " + this.getCreationDate());
    }

    public void show() {
        for (HumanBeing h : collection) {
            System.out.println(h.toString());
        }
    }

    public void update(HumanBeing h, int id) {
        HumanBeing c = this.getElementById(id);
        c.setCar(h.getCar());
        c.setCoordinates(h.getCoordinates());
        c.setName(h.getName());
        c.setHasToothpick(h.getHasToothpick());
        c.setRealHero(h.getRealHero());
        c.setImpactSpeed(h.getImpactSpeed());
        c.setMinutesOfWaiting(h.getMinutesOfWaiting());
        c.setWeaponType(h.getWeaponType());
    }

    public void removeById(int id) {
        HumanBeing h = this.getElementById(id);
        this.collection.remove(h);
    }

    public void removeHead() {
        HumanBeing[] list = this.list();
        System.out.println(list[0].toString());
        collection.remove(list[0]);
    }

    public void removeGreater(HumanBeing h) {
        collection.offer(h);
        List<HumanBeing> l = Arrays.asList(list());
        l.sort(HumanBeing::compareTo);
        boolean was = false;
        for (HumanBeing t : l) {
            if (t.equals(h)) {
                was = true;
            }
            if (was) {
                collection.remove(t);
            }
        }
    }

    public void count_greater_than_car(Car car) {
        int count = 0;
        for (HumanBeing h : list()) {
            if (h.getCar().compareTo(car) > 0) {
                count++;
            }
        }
        System.out.println(count);
    }

    public void printDescending() {
        List<HumanBeing> l = Arrays.asList(list());
        l.sort(Comparator.reverseOrder());
        for (HumanBeing h : l) {
            System.out.println(h.toString());
        }
    }

    public void soundUp() {
        List<String> l = new ArrayList<>();
        for (HumanBeing h : list()) {
            l.add(h.getSoundtrackName());
        }
        l.sort(String::compareTo);
        for (String s : l) {
            System.out.println(s);
        }
    }

    public void setPathToSave(String path) {
        this.pathToSave = path;
    }

}
