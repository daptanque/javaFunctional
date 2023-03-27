package org.coderpt;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.coderpt.Main.Gender.FEMALE;

public class Main {
    public static void main(String[] args) {

        //IMPERATIVE APPROACH
        List<Person> people = List.of(
            new Person("John", Gender.MALE),
            new Person("Maria", FEMALE),
            new Person("Aisha", FEMALE),
            new Person("Alex", Gender.MALE),
            new Person("Alice", FEMALE)
        );

        List<Person> females = new ArrayList<>();
        for(Person person : people){
            if (FEMALE.equals(person.gender)){
                females.add(person);
            }
        }

        for(Person female : females){
            System.out.println(female);
        }

        //DECLARATIVE APPROACH - use streams with collections
        // you can see that it is much more straight forward less fors and ifs and stuff... much like rails and sql
        people.stream()
                .filter(person -> FEMALE.equals(person.gender))
                .collect(Collectors.toList())
                .forEach(System.out::println);

        List<Person> femalesList = people.stream()
                .filter(person -> FEMALE.equals(person.gender))
                .collect(Collectors.toList());
        femalesList.forEach(System.out::println);

        //java.util.function


    }

    static  class Person{
        private final String name;
        private final Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender {
        MALE, FEMALE;
    }
}