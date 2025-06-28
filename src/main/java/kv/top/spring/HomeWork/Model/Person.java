package kv.top.spring.HomeWork.Model;


import java.math.BigDecimal;

public class Person {

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

  int id;

    public void setName(String name) {
        this.name = name;
    }

    String name;
    Integer age;

    public int getId() {
        return id;
    }

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
