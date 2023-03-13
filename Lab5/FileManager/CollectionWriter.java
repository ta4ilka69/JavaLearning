package FileManager;

import Commands.Executable;
import Collection.MyCollection;
import ElementClasses.HumanBeing;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class CollectionWriter implements Executable {
    private String pathToFile;
    private MyCollection collection;
    public CollectionWriter(MyCollection collection){
        this.collection = collection;
        this.pathToFile = collection.getPathToSave();
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
                s += screening(name);
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
                s += screening(sound);
                s+=',';
                s+=Float.toString(h.getMinutesOfWaiting());
                s+=',';
                s+=h.getWeaponType().toString();
                s+=',';
                String car = h.getCar().toString();
                s += screening(car);
                s+='\n';
                writer.write(s);
            }
            writer.close();
        }
        catch (Exception e){
            if(e instanceof FileNotFoundException){
                System.out.println("Кто то сп***ил файл с коллекцией!!!");
            }
        }
    }
    private String screening(String s){
        String res = "";
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)==','||s.charAt(i)=='"'){
                res+='"'+s.charAt(i)+'"';
            }
            else{
                res+=s.charAt(i);
            }
        }
        return res;
    }
    public static String info() {
        return "Writes collection to file";
    }
}
