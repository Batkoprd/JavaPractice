package com.company.Reflection_Annotation_SQL_9.HW9;

@AnnotationMapping.Table(name = "CAT")
public class Cat {

    @AnnotationMapping.ColumnInteger(name = "CAT_ID"
            , constraints = @AnnotationMapping.Constraints(primaryKey = true))
    private Integer id;

    /*
     @ColumnString(30), значение 30 без указания поля, тк мы указываем
     только один параметр, который называется value.
     */
    @AnnotationMapping.ColumnString(30)
    private String name;

    @AnnotationMapping.ColumnInteger
    private Integer age;

    @AnnotationMapping.ColumnString(30)
    private String color;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
