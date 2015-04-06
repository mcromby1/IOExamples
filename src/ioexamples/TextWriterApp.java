package ioexamples;

import java.io.*;
import java.util.*;

/**
 * TextWriterApp.java	1.00 Nov 25, 2003
 *
 * A class that writes data to a text file, with buffering.
 */
public class TextWriterApp {

    public static void main(String[] args) throws IOException {
        boolean append = false;   // you can change this

        // This references the file in the working directory
        File data = new File("src" + File.separatorChar + "test.out");

        // This is where we setup our streams (append = false means overwrite)
        // new FileWriter() creates the file if doesn't exit
        PrintWriter fileEditor = new PrintWriter(
                new BufferedWriter(
                        new FileWriter(data, append)));

        // print statements do actual work of writing data
        // note that print statements work similar to Sytem.out.println,
        // where data is converted to strings
        fileEditor.print(5.25);
        fileEditor.print('c');
        fileEditor.print(true);
        fileEditor.println("Java");
        fileEditor.println(new Dog());
        fileEditor.print("End of file");
        fileEditor.close();  // be sure you close your streams when done!!

        System.out.println("Wrote file to: " + data.getAbsolutePath());
    }
}
