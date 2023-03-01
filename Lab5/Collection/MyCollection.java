package Collection;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.PriorityQueue;

import ElementClasses.HumanBeing;

public class MyCollection {
    private PriorityQueue<HumanBeing> collection;
    private LocalDate creationDate;

    public MyCollection() {
        this.collection = new PriorityQueue<>();
        creationDate = LocalDate.now();
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void add(HumanBeing h){
        this.collection.offer(h);
    }

    public HumanBeing getElementById(int id){
        HumanBeing[] l = new HumanBeing[this.getSize()];
        this.collection.toArray(l);
        for (HumanBeing t:l
             ) {
            if(t.getId()==id){
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
}
