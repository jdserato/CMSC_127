package Lab01.Sequential;

import java.io.*;
import java.util.*;

/**
 * Created by Serato on January 26, 2017.
 */
public class seq {
    public static void main(String[] args) {
        BufferedReader br = null;
        BufferedWriter bw;

        try {
            br = new BufferedReader(new FileReader("input.txt"));
            bw = new BufferedWriter(new FileWriter("output.txt"));

            List<String> people = new ArrayList<>();

            String currLine;
            while ((currLine = br.readLine()) != null) {
                people.add(currLine);
            }

            Scanner sc = new Scanner(System.in);
            System.out.print("Please enter name to be entered: ");
            String name = sc.nextLine();
            boolean added = false;

            for (int i = 0; i < people.size(); i++) {

                String compare = people.get(i);
                for (int j = 0; j < compare.length(); j++) {
                    if (compare.charAt(j) != name.charAt(j)) {
                        if (compare.charAt(j) > name.charAt(j)) {
                            people.add(i, name);
                            added = true;
                        }
                        break;
                    }
                }

                if(added) {
                    break;
                }
            }

            if (!added) {
                people.add(name);
            }

            for (String peo : people) {
                bw.write(peo + "\n");
            }
            bw.close();

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
