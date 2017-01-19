/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacompare;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ivica
 */
public class JavaCompare {
    private static final Logger logger = Logger.getLogger("mylogger");
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        Handler fileHandler = new FileHandler("L:\\develop\\Java\\JavaCompare\\logs\\mylog.log");
        logger.addHandler(fileHandler);
        logger.setLevel(Level.FINEST);
        FileReader fr = null;
        System.out.println("This class name is: " + JavaCompare.class.getName());
        try {
            // TODO code application logic here
            System.out.println("%h: " + System.getProperty("user.home"));
            System.out.println("%t: " + System.getProperty("user.temp"));
            String fileToRead = "L:\\develop\\Java\\JavaCompare\\logs\\output1.log";
            fr = new FileReader(fileToRead);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            try {
                line = br.readLine();
            } catch (IOException ex) {
                Logger.getLogger(JavaCompare.class.getName()).log(Level.SEVERE, null, ex);
            }
            while (line != null) {
                try {
                    line = br.readLine();
                    System.out.print(line);
                } catch (IOException ex) {
                    Logger.getLogger(JavaCompare.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (FileNotFoundException ex) {
            //Logger.getLogger(JavaCompare.class.getName()).log(Level.SEVERE, ex.toString(), ex);            
            System.out.println("No file or file name misspelled!");
            logger.log(Level.WARNING, ex.toString(), ex);
            System.out.println("This is reported: " +  ex.getMessage());
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(JavaCompare.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}