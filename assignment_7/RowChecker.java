package assignment_7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RowChecker {

    public void checkRows(String fileName) {

        boolean rowSumsToConstant = true;
        String line;
        String nums[];
        int currentRowSum = 0;
        int nextRowSum = 0;

        try {

            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);

            if ((line = br.readLine()) != null) {
                System.out.println("line is: " + line);
                nums = line.split("\t");

                for (int i = 0; i < nums.length; i++) {
                    System.out.println(nums[i]);
                }

                // for (int i = 0; i < nums.length; i++) {
                // currentRowSum += Integer.valueOf(nums[i]);
                // }
            }

            br.close();

        } catch (IOException e) {
            e.printStackTrace();

        }

        // br.readLine();

        // while (nextRowSum != currentRowSum) {

        // }

    }

    public static void main(String[] args) {
        RowChecker checker = new RowChecker();
        checker.checkRows("./assignment_7/Mercury.txt");
    }
}
