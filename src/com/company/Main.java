package com.company;
import org.apache.log4j.Logger;
import java.io.File;
import java.util.Scanner;
public class Main {
    final static Logger logger = Logger.getLogger(Main.class);

    public static void fileFinder(File[] files, String inputed){
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile() && files[i].getName().startsWith(inputed)) {
                logger.info("მოიძებნა: " + files[i].getName());
            } else if (files[i].isDirectory()) {
                File file = new File(files[i].getAbsolutePath());
                File[] files2 = file.listFiles();
                if(files2.length > 0){
                    fileFinder(files2, inputed);
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.print("შეიყვანეთ საძიებო სიტყვა: ");
        Scanner inputedName = new Scanner(System.in);
        String searchName = inputedName.nextLine();
        logger.info("შემოტანილი სიტყვაა : " + searchName);
        File file = new File("/home/mariam/Desktop/");

        File[] files = file.listFiles();
        fileFinder(files, searchName);

    }
}
