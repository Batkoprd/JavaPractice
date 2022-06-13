package main.java.com.company.Reflection_Annotation_SQL_9.Annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Annotation_MainApp {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Class testClass = TestClass.class;
//        Method[] methods = testClass.getDeclaredMethods();
//        for (Method o : methods) {
//            if (o.isAnnotationPresent(MyAnno.class)) {
//                executionList.add(o);
//            }
//        }
//        executionList.sort((o1, o2) -> o2.getAnnotation(MyAnno.class).priority() - o1.getAnnotation(MyAnno.class).priority());

        //если мы хотим вызвать методы testClass в соответствии с приоритетом аннотации MyAnno
        List<Method> executionList = Arrays.stream(testClass.getDeclaredMethods())
                .filter(m -> m.isAnnotationPresent(MyAnno.class))
                .sorted((o1, o2) -> o2.getAnnotation(MyAnno.class).priority() - o1.getAnnotation(MyAnno.class).priority())
                .toList();

        for (Method m : executionList) {
            m.invoke(null);
        }

    }
}
