package main.java.com.company.Reflection_Annotation_SQL_9.Reflection;

public class Cat {
    private int privateField;
    int defaultField;
    public int publicField;

    public Cat(int privateField, int defaultField, int publicField) {
        this.privateField = privateField;
        this.defaultField = defaultField;
        this.publicField = publicField;
    }

    public Cat() {
    }

    public final void publicMeow() {
        System.out.println("public meow");
    }

    private void privateMeow() {
        System.out.println("private meow");
    }

    @Override
    public String toString() {
        return "Cat{" +
                "privateField=" + privateField +
                ", defaultField=" + defaultField +
                ", publicField=" + publicField +
                '}';
    }
}