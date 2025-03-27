package assignment_7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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

            // checks if the sum of the remaining lines are equal to the first
            while ((line = br.readLine()) != null) {
                // this will skip the empty line in the file
                line = br.readLine();

                // ending while-loop if reaches the line after the last line of integers
                if (line == null) {
                    break;
                }

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
        checker.checkRows("./assignment_7/Mercury.txt");
        checker.checkRows("./assignment_7/Luna.txt");
    }
}
