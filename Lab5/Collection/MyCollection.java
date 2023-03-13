package Collection;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.PriorityQueue;

import ElementClasses.HumanBeing;

public class MyCollection {
    private PriorityQueue<HumanBeing> collection;
    private LocalDate creationDate;
    private String pathToSave;

    private ArrayList<Integer> id;
    public MyCollection(String path) {
        this.collection = new PriorityQueue<>();
        this.pathToSave = path;
        creationDate = LocalDate.now();
        id = new ArrayList<>();
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void add(HumanBeing h) {
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
    private Integer[] getIds(){
        Integer[] res = new Integer[this.id.size()];
        this.id.toArray(res);
        return res;
    }

    public int getFreeId(){
        int i = 0;
        while(this.id.contains(i)){
            i++;
        }
        return i;
    }
}
