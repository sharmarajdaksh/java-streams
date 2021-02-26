package com.sharmarajdaksh;

import javax.swing.text.html.Option;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Person> people = getPeople();

        List<Person> femalePeople = people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .collect(Collectors.toList());

//        femalePeople.forEach(System.out::println);

        List<Person> sortedPeople = people.stream()
                .sorted(Comparator.comparing(Person::getAge))
                .collect(Collectors.toList());


        List<Person> sortedPeopleReversed = people.stream()
                .sorted(Comparator.comparing(Person::getAge).reversed())
                .collect(Collectors.toList());


        List<Person> sortedPeopleMultipleCriteria = people.stream()
                .sorted(Comparator.comparing(Person::getAge).reversed().thenComparing(Person::getName))
                .collect(Collectors.toList());

//        sortedPeople.forEach(System.out::println);

        boolean areAllOlderThan5 = people.stream()
                .allMatch(person -> person.getAge() > 5); // true

        boolean areAllOlderThan8 = people.stream()
                .allMatch(person -> person.getAge() > 8); // false

        boolean isAnyLessThen5 = people.stream()
                .anyMatch(person -> person.getAge() < 5);

        boolean areNoneOlderThan120 = people.stream()
                .noneMatch(person -> person.getAge() > 120);

        Optional<Person> maxAgePerson = people.stream()
                .max(Comparator.comparing(Person::getAge));

        Optional<Person> minAgePerson = people.stream()
                .min(Comparator.comparing(Person::getAge));

        // Group
        Map<Gender, List<Person>> genderMapList = people.stream().collect(Collectors.groupingBy(Person::getGender));

//        genderMapList.forEach((gender, p) -> {
//            System.out.println(gender);
//            p.forEach(System.out::println);
//            System.out.println();
//        });
    }

    private static List<Person> getPeople() {
        return List.of(
                new Person("James Bond", 20, Gender.MALE),
                new Person("Alina Smith", 33, Gender.FEMALE),
                new Person("Helen White", 57, Gender.FEMALE),
                new Person("Alex Boz", 14, Gender.MALE),
                new Person("Jamie Goa", 99, Gender.MALE),
                new Person("Anna Cook", 7, Gender.FEMALE),
                new Person("Zelda Brown", 120, Gender.FEMALE)
        );
    }
}
