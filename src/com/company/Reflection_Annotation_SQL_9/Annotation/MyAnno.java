package com.company.Reflection_Annotation_SQL_9.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
Для создания аннотации создаем интерфейс и ставим символ @ перед ключевым словом interface.
Необходимо указать две аннотации:

● @Retention – сообщает, где будет использоваться аннотация:
    ○ RetentionPolicy.SOURCE – используется на этапе компиляции и должна
отбрасываться компилятором;
    ○ RetentionPolicy.CLASS – будет записана в .class-файл, но не будет доступна во время
выполнения;
    ○ RetentionPolicy.RUNTIME – будет записана в .class-файл и доступна во время
выполнения через Reflection.

● @Target – к какому типу данных можно подключить эту аннотацию:
    ○ ElementType.METHOD – метод;
    ○ ElementType.FIELD – поле;
    ○ ElementType.CONSTRUCTOR – конструктор;
    ○ ElementType.PACKAGE – пакет;
    ○ ElementType.PARAMETER – параметр;
    ○ ElementType.TYPE – тип;
    ○ ElementType.LOCAL_VARIABLE – локальная переменная и т.д
*/


@Retention(RetentionPolicy.RUNTIME) //мы можем видеть аннотацию в процессе выполнения программы
@Target(ElementType.METHOD) // мы можем цеплять ее к методам
public @interface MyAnno {
    int priority() default 5;
}