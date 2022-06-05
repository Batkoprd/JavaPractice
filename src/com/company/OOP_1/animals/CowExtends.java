package com.company.OOP_1.animals;

import com.company.OOP_1.animals.Animal;

public abstract class CowExtends extends Animal {
    @Override
    public void info() {
        System.out.println(name); // поле name недоступно вне пакета animals
        // в этом случае у класса Animal модификатор поля должен быть измене на protected
    }
}
