package pl.waw.sgh;
import java.io.File;

public class Files {
    static int j = 0;
    static long memory = 0;
    static int onlyfiles = 0;
    static long onlyfilesMemory = 0;

    static void listFilesInDir(File directory) {

        for (File f : directory.listFiles()) {
            memory = memory + f.length();
            j++;
            if (f.isDirectory()) {
                listFilesInDir(f);
            } else {
                onlyfiles++;
                onlyfilesMemory = onlyfilesMemory + f.length();
            }

        }
    }
        final static String FILE = "C:\\Users\\LocalUser\\IdeaProjects\\CP_summer_2018\\src\\pl";
        public static void main (String[]args){
            File myFile = new File(FILE);
            listFilesInDir(myFile);
            System.out.println("The number of files and folders: " + j);
            System.out.println("The number of files: " + onlyfiles);
            System.out.println("The memory (files+folders): " + memory);
            System.out.println("The memory (files): " + onlyfilesMemory);
        }

    }
