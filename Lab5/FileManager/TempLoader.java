package FileManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TempLoader {
    private String tempPath;
    private String cPath;
    public TempLoader(String tempPath, String cPath){
        this.tempPath = tempPath;
        this.cPath = cPath;
    }
    public String check(){
        Scanner c;
        Scanner temp;
        try {
            temp = new Scanner(new File(tempPath));
            c = new Scanner(new File(cPath));
        } catch (FileNotFoundException e) {
            return cPath;
        }
        while(c.hasNext()&&temp.hasNext()){
            if(!temp.nextLine().equals(c.nextLine())){
                return getAnswer();
            }
        }
        if(!c.hasNext()&&temp.hasNext()){
            return tempPath;
        }
        return cPath;
    }

    private String getAnswer(){
        String ans = "";
        Scanner scan = new Scanner(System.in);
        while(!ans.equals("y")&&!ans.equals("n")) {
            System.out.println("Do you want to restore collection from temporary file? (y/n)");
            ans = scan.nextLine();
        }
        if(ans.equals("y")){
            return this.tempPath;
        }
        return this.cPath;
    }
}
