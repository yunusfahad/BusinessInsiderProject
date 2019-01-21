package BITests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
/**
 * Created by Fahad on 1/21/19.
 */
public class FileCheck {

    public static void main(String[] args) throws IOException {
        String path = "/Users/Fahad/Documents/BIProject/src/main/resources/TestFile";

        boolean fileExist = doesFileExist(path);
        if(fileExist == true) {
            BufferedReader oBuffer = new BufferedReader(new FileReader(path));
            String szLine;
            int nCount = 0;
            while ((szLine = oBuffer.readLine()) != null) {
                nCount++;
                String[] arrayName = szLine.split("[-]");
                System.out.println(arrayName[0]);
                if(nCount > 3) break;
            }

        }

    }

    //method to check if a file exist
    public static boolean doesFileExist(String path){
        File temp;
        boolean exists = false;
        try
        {
            temp = new File(path);
            exists = temp.exists();
            System.out.println("Temp file exists : " + exists);
        } catch (Exception e)
        {
            System.out.println(e);
        }

        return exists;

    }
}
