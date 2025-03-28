package assignment_7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class RowChecker {

    public void checkRows(String fileName) {

        boolean rowSumsToConstant = true;
        String line;
        String nums[];
        int firstRowSum = 0;
        int currentRowSum = 0;

        try {

            // creating file reader and bufferreader
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);

            // Finding the sum of the first line of integers
            if ((line = br.readLine()) != null) { // after reading the line, it will go to the next line
                nums = line.split("\t");
                for (int i = 0; i < nums.length; i++) {
                    firstRowSum += Integer.valueOf(nums[i]);
                }
            }

            // skip the empty line without integers
            line = br.readLine();

            // checks if the sum of the remaining lines are equal to the first
            while ((line = br.readLine()) != null) {

                nums = line.split("\t");
                for (int i = 0; i < nums.length; i++) {
                    currentRowSum += Integer.valueOf(nums[i]);
                }

                // checks if the current row sum is equal to that of the first.
                // if it does not equal then end loop because we know that file
                // is not a magic square.
                if (currentRowSum != firstRowSum) {
                    rowSumsToConstant = false;
                    break;
                }

                // make current row sum equal to 0 again.
                currentRowSum = 0;

                // this will skip the empty lines in the file
                line = br.readLine();
                System.out.println(Arrays.toString(nums));
            }

            // rows all sum to constant, so file is a magic square
            if (rowSumsToConstant = true) {
                System.out.println("This is a magic square!");
            } else {
                System.out.println("This is not a magic square. :(");
            }
            br.close();

        } catch (IOException e) {

            e.printStackTrace();

        }
    }

    public static void main(String[] args) {
        RowChecker checker = new RowChecker();
        // checker.checkRows("./assignment_7/Mercury.txt");
        // checker.checkRows("./assignment_7/Luna.txt");
        // checker.checkRows("./assignment_7/Unhappy1.txt");
        checker.checkRows("./assignment_7/Unhappy2.txt");
    }
}
