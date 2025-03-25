package assignment_7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RowChecker {

    public void readFile() {
        try {
            FileReader fr = new FileReader("./assignment_7/Mercury.txt");
            BufferedReader br = new BufferedReader(fr);

            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        RowChecker checker = new RowChecker();
        checker.readFile();
    }
}
