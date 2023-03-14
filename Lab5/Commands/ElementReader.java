package Commands;


import Collection.MyCollection;
import ElementClasses.Coordinates;
import ElementClasses.HumanBeing;
import ElementClasses.WeaponType;

import java.io.InputStream;
import java.util.Scanner;

public class ElementReader {
    private Scanner scanner;
    private boolean auto;
    private MyCollection collection;
    public ElementReader(InputStream input, MyCollection collection, boolean auto){
        this.scanner = new Scanner(input);
        this.collection = collection;
        this.auto = auto;
    }

    public HumanBeing getElement(){
        Object[] args = new Object[11];
        int j = 0;
        if(auto){
            args[0] = this.collection.getFreeId();
            j++;
        }
        for(int i = j;i<11;i++){
            if(scanner.hasNext()) {
                if (i == 0 || i == 5) {

                }
            }
            else{

            }
        }
    }

    public String getLine(int arg){

    }
}
