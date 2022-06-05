package com.company.Generics_Collections_4;

public class SimpleBox {
    private Object obj;

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public SimpleBox(Object obj) {
        this.obj = obj;
    }

    public void info() {
        System.out.println(obj.getClass().getSimpleName() + " " + obj);
    }
}
