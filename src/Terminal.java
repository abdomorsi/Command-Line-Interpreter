import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.*;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.lang.System.out;

public class Terminal {
    // private static File currentFile;
    private static File currentDirectory;
    private static File rootDirectory;

    Terminal() {
        currentDirectory = new File("E:\\A .. Morsi\\CLI");
        //currentFile = new File("E:\\A .. Morsi\\CLI");
        rootDirectory = new File("E:\\A .. Morsi");
    }

    private boolean isShortPath(String inPath) {
        return (boolean) inPath.contains(":");
    }

    private String getFullPath(String path) {
        String full = currentDirectory + "\\" + path;
        return full;
    }

    private ArrayList<String> readLineByLine(String fileName) throws IOException {
        List<String> list1 = Files.readAllLines(Paths.get(fileName));
        ArrayList<String> content = new ArrayList<String>();
        for (String s : list1) {
            content.add(s);
        }
        return content;
    }

    private void writeInFile(ArrayList<String> content, String fileName) throws IOException {
        BufferedWriter BW = new BufferedWriter(new FileWriter(fileName, true));
        for (String s : content) {
            BW.write(s);
            System.out.print(s);
            BW.newLine();
            // System.out.print("\n");
            // Files.write(Paths.get(fileName), s.getBytes(),StandardOpenOption.APPEND);
        }
        BW.close();
    }

    public void cp(String sourcePath, String destinationPath) throws IOException {
        // check if it is relative or short path
        //ArrayList<String> content = readLineByLine(sourcePath);
        String[] fname;
        fname = sourcePath.split("\\\\");
        String destName = destinationPath + "\\" + fname[fname.length - 1];
        //System.out.print(destName);
        //writeInFile(content,destName);
        FileSystem system = FileSystems.getDefault();
        Path mainFile = system.getPath(sourcePath);
        Path copiedFile = system.getPath(destinationPath);
        Files.copy(mainFile, copiedFile);
    }

    public void mv(String sourcePath, String destinationPath) throws IOException {
        // ArrayList<String> content = readLineByLine(sourcePath);
        String[] fname;
        fname = sourcePath.split("\\\\");
        String destName = destinationPath + "\\" + fname[fname.length - 1];
        //System.out.print(destName);
        //writeInFile(content,destName);
        FileSystem system = FileSystems.getDefault();
        Path from = system.getPath(sourcePath);
        Path to = system.getPath(destName);
        Files.move(from, to);
        File deleteFile = new File(sourcePath);
        deleteFile.delete();
    }

    public void rm(String sourcePath) {
        File removeFile = new File(sourcePath);
        if (removeFile.isFile())
            removeFile.delete();
    }

    public void mkdir(String directoryName) {
        File newDirectory = new File(currentDirectory + "\\" + directoryName);
        if (!newDirectory.exists())
            newDirectory.mkdir();
    }

    public void rmdir(String directoryName) {
        File newDirectory = new File(currentDirectory + "\\" + directoryName);
        if (newDirectory.isDirectory())
            newDirectory.delete();
    }

    public void pwd() {
        // show which directory i am in
        System.out.println(currentDirectory.getPath());
        //System.out.print(System.getProperty("user.dir"));
    }

    /// cat0 to show the content of the file
    public void cat0(String[] paths) throws IOException {
        for (int i = 0; i < paths.length; i++) {
            String file_name = paths[i];
            ArrayList<String> content = readLineByLine(file_name);
            for (int j = 0; j < content.size(); j++) {
                out.println(content.get(j));
            }
        }
    }

    /// cat1 to read data from console and save it into file
    public void cat1(String fileName) throws IOException {
        ArrayList<String> content = new ArrayList<String>();
        // Scanner input = new Scanner(System.in);
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        File f = new File(fileName);
        String data = " ";
        while (!data.isEmpty()) {
            data = input.readLine();
            content.add(data);
        }
        writeInFile(content, fileName);
    }

    /// copy from one to another >
    public void cat2(String fileName1, String fileName2) throws IOException {
        File f = new File(fileName2);
        FileWriter tr = new FileWriter(fileName2, false);
        if (!f.exists()) f.createNewFile();
        else if (f.exists() && f.isFile()) tr.flush();
        tr.close();
        ArrayList<String> content = readLineByLine(fileName1);
        writeInFile(content, fileName2);
    }

    /// append from one to another >>
    public void cat3(String fileName1, String fileName2) throws IOException {
        ArrayList<String> content = readLineByLine(fileName1);
        writeInFile(content, fileName2);
    }

    public void clear() {
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }
    }

    public void ls() {
        String[] listOfFiles = currentDirectory.list();
        for (String s : listOfFiles)
            System.out.println(s);
    }

    public void ls(String path) {
        File f = new File(path);
        String[] listOfFiles = {};
        if (f.isDirectory())
            listOfFiles = f.list();
        for (String s : listOfFiles)
            System.out.println(s);
    }

    ////////////////////////////////////////////////////////////////////////
    public void help(String command) {
        //description for the command
    }

    ///////////////////////////////////////////////////////////////////////
    public void args(String command) {
        // how many args for the command
    }

    public void date() {
        SimpleDateFormat showTime = new SimpleDateFormat(" HH:mm:ss  dd/MM/yyyy ");
        Date now = new Date();
        System.out.println(showTime.format(now));
    }
    //cd
    public void cd() {
        currentDirectory = rootDirectory;
    }
    // cd..
    public void cdParent(){
        File p = new File(currentDirectory.getParent());
        currentDirectory = p;
    }
    //cd directory_name
    public void cd(String newDirectory) {
        if (isShortPath(newDirectory)) {
            newDirectory = getFullPath(newDirectory);
        }
        File New = new File(newDirectory);
        currentDirectory = New;
    }


}
