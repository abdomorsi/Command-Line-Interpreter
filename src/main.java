import com.sun.glass.ui.Pixels;
import com.sun.glass.ui.Robot;
import javafx.scene.input.KeyEvent;
import jdk.nashorn.internal.ir.Terminal;

import javax.naming.SizeLimitExceededException;
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.attribute.FileStoreAttributeView;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static java.lang.System.*;

public class main {



    private static ArrayList<String> readLineByLine (String fileName) throws IOException {
        List<String> list1 = Files.readAllLines(Paths.get(fileName));
        ArrayList<String> content = new ArrayList<String>();
        for (String s: list1)
        {
            content.add(s);
        }
        return content;
    }

    private static void writeInFile(ArrayList<String> content,String fileName) throws IOException {
        BufferedWriter BW = new BufferedWriter(new FileWriter(fileName,true));
        File f = new File(fileName);
        if(f.length()!=0)BW.newLine();
        for (String s:content) {
            BW.write(s);
            System.out.print(s);
            BW.newLine();
            // System.out.print("\n");
            // Files.write(Paths.get(fileName), s.getBytes(),StandardOpenOption.APPEND);
        }
        BW.close();
    }


    /*public static void stop() {
        TimeUnit.sleep(4);
        while (true) break;
    }*/


    public static void main(String ars[]) throws IOException {


        String sourcePath = "E:\\A .. Morsi\\CLI\\from";
        String destinationPath = "E:\\A .. Morsi\\CLI\\to\\18343.jpg";
        String currentDirectory = "E:\\A .. Morsi\\CLI";
        String directoryName = "New Foolder7.File folder";
       /* File f = new File(currentDirectory);
        System.out.println(f.getName());
        File f1 = new File(f.getParent());
        f = f1;
        System.out.println(f.getPath());
*/
        //String[] paths = { "E:\\A .. Morsi\\CLI\\from\\f1.txt","E:\\A .. Morsi\\CLI\\to\\f1.txt"};
        //cat0(paths);
        //Read();

   }

}
