import java.util.Arrays;

public class test {
    public static void main(String[] arguments) {

        System.out.println("Hello World!");

        String output[];

        String s = "boo:and:foo";
        output = s.split("o");

        System.out.println(Arrays.toString(output));
        System.out.println(output.length);
    }

}
