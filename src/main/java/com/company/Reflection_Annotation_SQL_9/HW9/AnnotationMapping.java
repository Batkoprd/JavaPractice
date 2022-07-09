package com.company.Reflection_Annotation_SQL_9.HW9;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public interface AnnotationMapping {

    //Аннотация со значением @Target(ElementType.TYPE), это значит, что ее можно использовать для класса
    // поле name название для таблицы
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @interface Table {
        String name() default "";
    }

    //набор стандартных метаданных для таблицы таких, как первичный ключ, возможность записывать null.
    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    @interface Constraints {
        boolean primaryKey() default false;
        boolean allowNull() default true;
        boolean unique() default false;
    }


    /*
    @ColumnString и @ColumnInteger являются конкретными типами SQL. Они имеют внутри себя также поле name,
    которое будет содержать название колонки. Помимо этого также они содержат вложенную аннотацию @Constraints.
    Для большинства полей заполнять ее не нужно, т.к. в ней уже установлены значения по умолчанию, удовлетворяющие
    большинству полей.
     */
    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    @interface ColumnString {
        int value() default 0;
        String name() default "";
        Constraints constraints() default @Constraints;
    }

    //ColumnInteger.java
    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    @interface ColumnInteger {
        String name() default "";
        Constraints constraints() default @Constraints;
    }

}
