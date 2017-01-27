package Lab01.Hashing;

import java.io.*;

/**
 * Created by Serato on January 26, 2017.
 */
public class hash {
    public static void main(String[] args) {
        BufferedReader br = null;
        BufferedWriter bw;

        try {
            br = new BufferedReader(new FileReader("input.txt"));
            bw = new BufferedWriter(new FileWriter("hashes.txt"));

            String currLine;
            while((currLine = br.readLine()) != null) {
                bw.write(hashFunction(currLine) + "\n");
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

    private static int hashFunction(String input) {
        int hash = input.hashCode() % 67; //67 a random number
        if (hash < 0) {
            hash *= -1;
        }

        return hash;
    }
}
