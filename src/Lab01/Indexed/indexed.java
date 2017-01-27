package Lab01.Indexed;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Serato on January 26, 2017.
 */
public class indexed {
    public static void main(String[] args) {
        BufferedReader br = null;

        List<String> people = new ArrayList<>();

        try {
            Scanner sc = new Scanner(System.in);
            br = new BufferedReader(new FileReader("input.txt"));

            String currLine;
            while ((currLine = br.readLine()) != null) {
                people.add(currLine);
            }

            System.out.print("Who are we searching for? ");
            String name = sc.nextLine();

            char lookUp = name.charAt(0);
            int startIndex = 0, endIndex = people.size();
            br = new BufferedReader(new FileReader("index.txt"));
            while ((currLine = br.readLine()) != null) {
                if (currLine.charAt(0) == lookUp) {
                    startIndex = currLine.charAt(currLine.length() - 1) - '0';
                    try {
                        endIndex = br.readLine().charAt(currLine.length() - 1) - '0';
                    } catch (NullPointerException e) {

                    }
                }
            }

            boolean found = false;
            for (int i = startIndex; i < endIndex; i++) {
                if (people.get(i).equals(name)) {
                    System.out.println("Found \"" + name + "\" at index " + i);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Sorry. \"" + name + "\" is not on the list.");
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
