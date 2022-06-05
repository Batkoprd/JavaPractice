package com.company.OOP_1;

public class Box {
    String color;
    int size;

    public Box(String color, int size) {
        this.color = color;
        this.size = size;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Box)) {
            return false;
        }
        Box another = (Box) object;
        return this.color.equals(another.color) && this.size == another.size;
    }

    @Override
    public int hashCode() { // преобразует объект в какое-нибудь число,
        // у одинаковых по equals объектов хэшКод должен совпадать, у объектов которые не
        // равны по equals нежелательно, чтобы совпадал хэшКод
        // те поля которые используются в рассчете equals должны использоваться и в хэшКод
        return color.length() * 13 + size * 71;
    }
}
