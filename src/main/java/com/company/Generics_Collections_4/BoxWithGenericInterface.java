package main.java.com.company.Generics_Collections_4;

public class BoxWithGenericInterface implements Comparable<BoxWithGenericInterface>{
    private int size;

    public BoxWithGenericInterface(int size) {
        this.size = size;
    }


//    @Override
//    public int compareTo(Object o) {
//        if (this == o) {
//            return 0;
//        }
//        if (o instanceof BoxWithGenericInterface) {
//
//        }
//        BoxWithGenericInterface another = (BoxWithGenericInterface) o;
//        return 0;
//    }


    @Override
    public int compareTo(BoxWithGenericInterface o) {
        return this.size - o.size;
    }
}
