package Collection;

import java.time.LocalDate;
import java.util.PriorityQueue;

import ElementClasses.HumanBeing;

public class MyCollection {
    private PriorityQueue<HumanBeing> collection;
    private LocalDate creationDate;

    public MyCollection() {
        this.collection = new PriorityQueue<>();
        creationDate = LocalDate.now();
    }

    public void insert()

    public LocalDate getCreationDate() {
        return creationDate;
    }


    public int getSize() {
        return this.collection.size();
    }

    public void clear() {
        this.collection.clear();
    }
}
