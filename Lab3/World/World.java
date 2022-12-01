package World;

import Objects.SomeObj;

import java.util.ArrayList;

public class World {
    private final ArrayList<SomeObj> Objects;
    private Gravity g;

    public World(Gravity g){
        this.g = g;
        Objects = new ArrayList<>();
    }

    public void setGravity(Gravity g){
        this.g = g;
    }

    public Gravity getWorldGravity(){
        return this.g;
    }

    public void addObject(SomeObj obj){
        this.Objects.add(obj);
    }
}
