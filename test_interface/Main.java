package test_interface;

public class Main {

    public static void main(String[] args) {
        Cat tom = new Cat("tom");
        Bulldog jack = new Bulldog("jack");

        adopt(tom);
        adopt(jack);
    }

    public static void adopt(Pet p) {
        // System.out.println("The concrete type is: " + p.getClass().getName());

        if (p instanceof Cat) {
            System.out.println("The object is an instance of cat ");
        } else {
            System.out.println("The object is not an instance of cat");
        }

        if (p instanceof Bulldog) {
            System.out.println("The object is an instance of bulldog ");
        } else {
            System.out.println("The object is not an instance of bulldog");
        }
    }
}
