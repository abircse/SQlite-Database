package com.studioabir.sqlitepractice.sqlitepractice.modelforall;

public class model {

    private String name;
    private String age;

    public model(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
