package assignment_7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class AdvancedChecker {

    public void checkRows(String fileName) throws IOException {

        boolean rowSumsToConstant = true;
        boolean columnSumsToConstant = true;
        boolean diagonalSumsToConstant = true;
        String line;
        int numRows = 0;
        int numCols = 0;
        int firstRowSum = 0;
        int currentRowSum = 0;
        int firstColumnSum = 0;
        int currentColumnSum = 0;

        // creating file reader and bufferreader
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);

        // if file is empty, then return the method.
        if ((line = br.readLine()) == null) {
            System.out.println("The file is empty");
            br.close();
            return;
        }

        br.close();

        // creating file reader and bufferreader
        fr = new FileReader(fileName);
        br = new BufferedReader(fr);

        while ((line = br.readLine()) != null) {
            numRows++;
            numCols = numRows;
            System.out.println("number of rows: " + numRows);
            System.out.println(line);
            br.readLine();
        }

        System.out.println("number of rows is: " + numRows + " and the number of columns is: " + numCols);

        br.close();

        String nums[][] = new String[numRows][numCols];

        // reopening file reader and bufferreader
        fr = new FileReader(fileName);
        br = new BufferedReader(fr);
        line = br.readLine();

        // Finding the sum of the first line of integers
        nums[0] = line.split("\t");
        for (int i = 0; i < nums.length; i++) {
            firstRowSum += Integer.valueOf(nums[0][i]);
        }

        System.out.println("first row sum is: " + firstRowSum);

        // skip the empty line without integers
        line = br.readLine();

        // curent row index at 1
        int rowIndex = 1;

        // checking if the sum of the remaining lines are equal to the first
        while ((line = br.readLine()) != null) {
            System.out.println("the row index is: " + rowIndex);
            nums[rowIndex] = line.split("\t");
            for (int i = 0; i < nums[rowIndex].length; i++) {
                currentRowSum += Integer.valueOf(nums[rowIndex][i]);
            }

            if (currentRowSum != firstRowSum) {
                rowSumsToConstant = false;
            }

            // make current row sum equal to 0 again.
            currentRowSum = 0;

            line = br.readLine();
            rowIndex++;
        }

        br.close();

        // print out the 2d array
        for (int i = 0; i < numRows; i++) {
            System.out.println(Arrays.toString(nums[i]));
        }

        // find sum of first column
        for (int i = 0; i < numRows; i++) {
            System.out.println("current row index is:" + i);
            firstColumnSum += Integer.valueOf(nums[i][0]);
        }

        // checking if the sum of the remaining columns are equal to the first
        // outer loop goes through each column after the first one,
        // inner loop calculates the sum of the column
        for (int i = 1; i < numCols; i++) {
            for (int j = 0; j < numRows; j++) {
                currentColumnSum += Integer.valueOf(nums[j][i]);
            }

            if (currentColumnSum != firstColumnSum) {
                columnSumsToConstant = false;
            }

            // make current column sum equal to 0 again.
            currentColumnSum = 0;
        }

        // find sum of the diagonal from top left to bottom right
        int firstDiagonalSum = 0;
        int j = 0;
        for (int i = 0; i < numCols; i++) {
            firstDiagonalSum += Integer.valueOf(nums[i][j]);
            j++;
            System.out.println("The current diagonal sum is: " + firstDiagonalSum);
        }

        // find sum of the diagonal from top right to bottom left
        int secondDiagonalSum = 0;
        j = 0;
        for (int i = numCols - 1; i > -1; i--) {
            secondDiagonalSum += Integer.valueOf(nums[i][j]);
            j++;
            System.out.println("The current diagonal sum  of the second diagonal is: " + secondDiagonalSum);
        }

        if (firstDiagonalSum != secondDiagonalSum) {
            diagonalSumsToConstant = false;
        }

        // both rows and columns all sum to constant, so file is a magic square
        if (rowSumsToConstant && columnSumsToConstant && diagonalSumsToConstant) {
            System.out.println("This is a magic square!");
        } else {
            System.out.println("This is not a magic square. :(");
        }
    }

    public static void main(String[] args) throws IOException {
        AdvancedChecker checker = new AdvancedChecker();
        // checker.checkRows("./assignment_7/testfiles/Mercury.txt");
        checker.checkRows("./assignment_7/testfiles/Luna.txt");
        // checker.checkRows("./assignment_7/testfiles/Unhappy1.txt");
        // checker.checkRows("./assignment_7/testfiles/Unhappy2.txt");
        // checker.checkRows("./assignment_7/testfiles/Unhappy3.txt");
    }
}
