package main.java.com.company.Reflection_Annotation_SQL_9.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MarkingAnnotation {
}

@Retention (RetentionPolicy.RUNTIME)
@Target (ElementType.METHOD)
@interface AdvancedAnnotation {
    float value() default 5.0f;
}
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
        System.out.println("Вызываем методы testClass в соответствии с приоритетом аннотации MyAnno: ");
        List<Method> executionList = Arrays.stream(testClass.getDeclaredMethods())
                .filter(m -> m.isAnnotationPresent(MyAnno.class))
                .sorted((o1, o2) -> o2.getAnnotation(MyAnno.class).priority() - o1.getAnnotation(MyAnno.class).priority())
                .toList();

        for (Method m : executionList) {
            m.invoke(null);
        }
        System.out.println("---------------------------------");

        System.out.println("Пример вывода в консоль списка методов с аннотациями @MarkingAnnotation: ");
        Method[] methods = Annotation_MainApp.class.getDeclaredMethods();
        for (Method o : methods) {
            if (o.getAnnotation(MarkingAnnotation.class) != null) {
                System.out.println(o);

            }
        }
        System.out.println("---------------------------------");

        /*
        К аннотациям можно добавлять параметры. Рассмотрим пример работы с такими аннотациями и получения их параметров.
        Слово default в объявлении поля value отвечает за установку значения по умолчанию:
         */
        System.out.println("Пример вывода в консоль списка методов с аннотациями @AdvancedAnnotation: ");

        try {
            Method m = Annotation_MainApp.class.getMethod( "advAnnotatedMethod" , null );
            System.out.println(m);
            AdvancedAnnotation annotation =
                    m.getAnnotation(AdvancedAnnotation.class);
            System.out.println( "value: " + annotation.value());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

        @MarkingAnnotation
        public void markedMethod() {
            System.out.println("Java");
        }

        @AdvancedAnnotation(value = 20.0f)
        public void advAnnotatedMethod() {
            System.out.println("...");
    }
}
