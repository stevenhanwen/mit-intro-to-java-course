package assignment_7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RowChecker {
    FileReader fr = new FileReader("Mercury.txt");
    BufferedReader br = new BufferedReader(fr);
    String line = null;

    while((line=br.readLine())!=null)
    {
        System.out.println(line);
    }

    br.close();
}
