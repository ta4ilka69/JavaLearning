package Collection;

import ElementClasses.Car;
import ElementClasses.HumanBeing;

import java.util.*;

/**
 * Class that stores HumanBeing elements using PriorityQueue collection.
 * All getters and setters for fields.
 * @see HumanBeing
 */
public class MyCollection {
    /**
     * Collection with elements.
     */
    private PriorityQueue<HumanBeing> collection;
    /**
     * Date of creating collection.
     */
    private Date creationDate;
    /**
     * Path for saving collection.
     */
    private String pathToSave;
    /**
     * List with all id that have elements of collection.
     */
    private ArrayList<Integer> id;

    /**
     * Initialize collection.
     * @param path sets path to save.
     */
    public MyCollection(String path) {
        this.collection = new PriorityQueue<>();
        this.pathToSave = path;
        creationDate = new Date();
        id = new ArrayList<>();
    }

    /**
     * Getter for date.
     * @return creationDate field.
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * Add new element into collection.
     * @param h element to add.
     */
    public void add(HumanBeing h) {
        if (id.contains(h.getId())) {
            h.setId(this.getFreeId());
        }
        this.collection.offer(h);
        this.id.add(h.getId());
    }

    /**
     * Get element by id from collection.
     * @param id id of element to search.
     * @return element with id = <i>id</i>, null if no such was found.
     */
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
    /**
     * Getter for size of collection.
     * @return size.
     */
    public int getSize() {
        return this.collection.size();
    }

    /**
     * method for clearing collection.
     */
    public void clear() {
        this.collection.clear();
    }

    /**
     * Gets array of HumanBeing elements
     * @return all elements in HumanBeing[].
     */
    public HumanBeing[] list() {
        HumanBeing[] res = new HumanBeing[this.getSize()];
        this.collection.toArray(res);
        return res;
    }
    /**
     * Getter for path.
     * @return pathToSave field.
     */
    public String getPathToSave() {
        return this.pathToSave;
    }

    /**
     * Get all ids that have elements in collection (in array).
     * @return Integer[] of ids.
     */
    private Integer[] getIds() {
        Integer[] res = new Integer[this.id.size()];
        this.id.toArray(res);
        return res;
    }

    /**
     * Search for free id.
     * @return id not existing in any element of collection.
     */
    public int getFreeId() {
        int i = 1;
        while (this.id.contains(i)) {
            i++;
        }
        this.id.add(i);
        return i;
    }

    /**
     * Prints Size, Type and creation date into console.
     */
    public void printInfo() {
        System.out.println("Size: " + this.getSize());
        System.out.println("Type: " + this.collection.getClass());
        System.out.println("Date of initialization: " + this.getCreationDate());
    }

    /**
     * Prints all elements in column, their fields in a row.
     */
    public void show() {
        for (HumanBeing h : collection) {
            System.out.println(h.toString());
        }
    }

    /**
     * Update element with given id.
     * @param h - element that will be in collection.
     * @param id - id of element we want to update.
     */
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

    /**
     * Removes element by given id.
     * @param id id of element.
     */
    public void removeById(int id) {
        HumanBeing h = this.getElementById(id);
        this.collection.remove(h);
    }

    /**
     * Prints the first element and removes it.
     */
    public void removeHead() {
        HumanBeing[] list = this.list();
        System.out.println(list[0].toString());
        collection.remove(list[0]);
    }

    /**
     * Remove all elements that are greater than given.
     * @param h element for comparing with.
     */
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

    /**
     * Counts and prints how many elements have better car than given.
     * @param car car for comparing with.
     * @see Car
     */
    public void count_greater_than_car(Car car) {
        int count = 0;
        for (HumanBeing h : list()) {
            if (h.getCar().compareTo(car) > 0) {
                count++;
            }
        }
        System.out.println(count);
    }

    /**
     * Prints all elements in reversed sorted order.
     */
    public void printDescending() {
        List<HumanBeing> l = Arrays.asList(list());
        l.sort(Comparator.reverseOrder());
        for (HumanBeing h : l) {
            System.out.println(h.toString());
        }
    }

    /**
     * Prints all soundtracks of elements in sorted order.
     */
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

    /**
     * Setter for path to save.
     * @param path path to set for saving.
     */
    public void setPathToSave(String path) {
        this.pathToSave = path;
    }

}
