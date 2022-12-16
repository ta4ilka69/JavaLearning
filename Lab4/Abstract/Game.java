package Abstract;

import Creatures.SomeCreature;
import World.Entartainments;

public class Game implements Entartainments {
    private String name;
    private String description;
    private final SomeCreature author;
    private final Intellect IQMinimum;

    public Game(String name, String description, SomeCreature author) {
        this.name = name;
        this.description = description;
        this.IQMinimum = author.getIntellect();
        this.author = author;
        author.selfLearn(this);
        printCreate();
    }

    public Game(String name, String description, SomeCreature author, Intellect iq) {
        this.name = name;
        this.description = description;
        this.IQMinimum = iq;
        this.author = author;
        author.selfLearn(this);
        printCreate();
    }

    public void setName(String name) {
        System.out.println("Название игры "+this.name+" изменено на: "+name+".");
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
        System.out.println("Правила игры "+this.name+" изменены: ");
        System.out.println(description);
    }


    @Override
    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public Intellect getIQMinimum() {
        return IQMinimum;
    }

    public void printCreate(){
        System.out.println("Игра "+this.name+" создана "+this.author.getName()+".");
        System.out.println("У этой игры следующие правила: " + this.description);
    }

    @Override
    public int hashCode() {
        return name.hashCode()+description.hashCode()+author.hashCode()+ getIQMinimum().hashCode();
    }

    public boolean equals(Object o){
        return o instanceof Game && o.hashCode()==this.hashCode();
    }
}

