package com.company.Reflection_Annotation_SQL_9.HW9;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainApp {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> catClass = Class.forName("main.java.com.company.Reflection_Annotation_SQL_9.HW9.Cat");
        AnnotationMapping.Table table = catClass.getAnnotation(AnnotationMapping.Table.class);

        if (table == null) {
            System.out.println("Нет аннотаций таблицы для класса: " + catClass.getName());
        } else {
            String tableName = table.name();
            if (tableName.length() < 1)
                tableName = catClass.getName().toUpperCase();
            String columnDef = "";
            StringBuilder createCommand = new StringBuilder(
                    "CREATE TABLE " + tableName + "("
            );
            for (Field field : catClass.getDeclaredFields()) {
                String columnName = null;
                Annotation[] annotations = field.getDeclaredAnnotations();
                if (annotations.length < 1) {
                    System.out.println("Поле не колонка датабазы.");
                } else {
                    if (annotations[0] instanceof AnnotationMapping.ColumnInteger) {
                        AnnotationMapping.ColumnInteger columnInteger = (AnnotationMapping.ColumnInteger) annotations[0];
                        if (columnInteger.name().length() < 1)
                            columnName = field.getName().toUpperCase(); // используем имя поля, если оно не предоставлено аннотацией
                        else
                            columnName = columnInteger.name();
                        columnDef = columnName + " INT" + getConstraints(columnInteger.constraints());
                    } else if (annotations[0] instanceof AnnotationMapping.ColumnString) {
                        AnnotationMapping.ColumnString columnString = (AnnotationMapping.ColumnString) annotations[0];
                        if (columnString.name().length() < 1)
                            columnName =field.getName().toUpperCase();
                        else
                            columnName = columnString.name();
                        columnDef = columnName + " VARCHAR(" + columnString.value() + ")" + getConstraints(columnString.constraints());
                    }
                    createCommand.append("\n    ").append(columnDef).append(", ");
                }
            }
            String tableCreate = createCommand.substring(0, createCommand.length() - 2) + ");";
            System.out.println(tableCreate);
            runCommandInDB(tableCreate);


        }
    }

    private static String getConstraints(AnnotationMapping.Constraints con) {
        String constraints = "";
        if (!con.allowNull())
            constraints += " NOT NULL";
        if (con.primaryKey())
            constraints += " PRIMARY KEY";
        if (con.unique())
            constraints += " UNIQUE";

        return constraints;
    }

    private static void runCommandInDB(String command) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:mydatabase.db");
            connection.prepareCall(command).execute();
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
