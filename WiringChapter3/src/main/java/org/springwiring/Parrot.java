package org.springwiring;

public class Parrot {

    private String name;

    @Override
    public String toString(){
        return "Parrot : "+ name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
