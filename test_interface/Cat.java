package test_interface;

public class Cat implements Pet {

    private String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }

}
