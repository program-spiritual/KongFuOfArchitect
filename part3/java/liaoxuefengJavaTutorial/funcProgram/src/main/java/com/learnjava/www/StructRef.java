package com.learnjava.www;

import java.util.*;
import java.util.stream.*;

public class StructRef {
    public static void main(String[] args) {
        List<String> names = Arrays.asList(new String[]{"Bob", "Alice", "Tim"});
        List<Person> persons = names.stream().map(Person::new).collect(Collectors.toList());
        System.out.println(persons);
    }
}
class Person {
    String name;
    public Person(String name) {
        this.name = name;
    }
    public String toString() {
        return "Person:" + this.name;
    }
}