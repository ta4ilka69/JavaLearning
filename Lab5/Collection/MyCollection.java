package Collection;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.PriorityQueue;

public class MyCollection {
    private PriorityQueue<HumanBeing> collection;

    public MyCollection() {
        this.collection = new PriorityQueue<>();
    }

    public void delete(int id) {
        this.collection.remove(this.collection.toArray()[id]);
    }

    public void print(OutputStream out) {
        Writer w = new PrintWriter(out);
        for (HumanBeing c:collection
             ) {
            for (:
                 ) {
                
            }
        }
    }


    public int getSize() {
        return this.collection.size();
    }

    public void clear() {
        this.collection.clear();
    }
}
