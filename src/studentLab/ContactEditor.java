package studentLab;

import java.io.BufferedReader;
import java.io.*;
import java.util.*;

/**
 *
 * @author Matthew
 */
public class ContactEditor {

    public static void main(String[] args) throws IOException {
        
        String userHome = System.getProperty("user.home");
        System.out.println(userHome);
        File contactPlace = new File(File.separatorChar + "temp" + File.separatorChar + "test.txt");

        List<String[]> contactInfo = new ArrayList<>();
        try (BufferedReader fileViewer = new BufferedReader(new FileReader(contactPlace))) {
            String line;
            while ((line = fileViewer.readLine()) != null) {
                if (line.equals("")) {
                } else {
                    contactInfo.add(line.split(" "));
                }
            }
        }

        for (int i = 0; i < contactInfo.size(); ++i) {

            if (i % 3 == 0) {
                System.out.print("First Name: " + contactInfo.get(i)[0]);
                System.out.println(" Last Name: " + contactInfo.get(i)[1]);
            } else if (i % 3 == 1) {
                System.out.print("Address: " + contactInfo.get(i)[0]);
                for (int x = 1; x < contactInfo.get(i).length; ++x) {
                    System.out.print(" " + contactInfo.get(i)[x]);
                }
                System.out.println("");
            } else if (i % 3 == 2) {
                System.out.println("City: " + contactInfo.get(i)[0]);
                System.out.println("State: " + contactInfo.get(i)[1]);
                System.out.println("Zip: " + contactInfo.get(i)[2]);
            }

        }

        try (PrintWriter fileScrib = new PrintWriter(new BufferedWriter(new FileWriter(contactPlace, true)))) {
            fileScrib.println();
            fileScrib.print("Matthew ");
            fileScrib.println("Cromby");
            fileScrib.println("1921 S 71 Street");
            fileScrib.print("West Allis, ");
            fileScrib.print("WI ");
            fileScrib.println("53219");

            fileScrib.println();
            fileScrib.print("Bradley ");
            fileScrib.println("Adams");
            fileScrib.println("Humbolt Boulvard");
            fileScrib.print("Milwaukee, ");
            fileScrib.print("WI ");
            fileScrib.println("53214");
        }

    }

}
