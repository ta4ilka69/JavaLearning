package FileManager;

import Collection.Commands.Executable;
import Collection.MyCollection;
import ElementClasses.HumanBeing;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class CollectionWriter implements Executable {
    private static String pathToFile = "Collection/collection.csv";
    private MyCollection collection;
    public CollectionWriter(MyCollection collection){
        this.collection = collection;
    }

    public void execute(){
        try {
            FileOutputStream file = new FileOutputStream(pathToFile);
            OutputStreamWriter writer = new OutputStreamWriter(file);
            for (HumanBeing h:collection.list()
                 ) {
                String s=h.getId().toString()+',';
                s+=h.getName();
                String name = h.getName();
                s = (name.contains(",")) ? s+'"'+name+'"': s+name;
                s+=',';
                s+=h.getCoordinates().toString();
                s+=',';
                s+=h.getCreationDate().toString();
                s+=',';
                s+=h.getRealHero().toString();
                s+=',';
                s+=h.getHasToothpick().toString();
                s+=',';
                s+=h.getImpactSpeed().toString();
                s+=',';
                String sound = h.getSoundtrackName();
                s = (sound.contains(","))? s+'"'+sound+'"':s+sound;
                s+=',';
                s+=Float.toString(h.getMinutesOfWaiting());
                s+=',';
                s+=h.getWeaponType().toString();
                s+=',';
                String car = h.getCar().toString();
                s = (car.contains(","))? s+'"'+car+'"':s+car;
                s+='\n';
                writer.write(s);
            }
        }
        catch (Exception e){
            if(e instanceof FileNotFoundException){
                System.out.println("Кто то сп***ил файл с коллекцией!!!");
            }
        }
    }

    public static String info() {
        return "Writes collection to file";
    }
}
