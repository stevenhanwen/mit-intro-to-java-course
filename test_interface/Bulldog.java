package test_interface;

public class Bulldog implements Pet {
    private String name;

    public Bulldog(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }
}
