package me.chulgil.cote.basic1;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Person person = new Person("박혜림");
        person.addPhoneNumber(new PhoneNumber("010-1234-1234"));
        person.addPhoneNumber(new PhoneNumber("010 1234 3234"));
        person.addPhoneNumber(new PhoneNumber("01012343234"));
        System.out.println(person);
        System.out.println(person.hasPhoneNumber(new PhoneNumber("01012343234")));

        Person person1 = new Person("홍길동");
        person1.addPhoneNumber(new PhoneNumber("010-1234-5678"));
        person1.addPhoneNumber(new PhoneNumber("010-2345-6789"));
        Person person2 = new Person("김철수");
        person2.addPhoneNumber(new PhoneNumber("010-2468-0246"));
        Person person3 = new Person("이영희");
        person3.addPhoneNumber(new PhoneNumber("010-1357-9135"));

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addPerson(person1);
        phoneBook.addPerson(person2);
        phoneBook.addPerson(person1);
        phoneBook.addPerson(person2);

        System.out.println(phoneBook);
    }


    private static class Person {
        public final String name;
        public final List<PhoneNumber> numbers;

        public Person(String name) {
            this.name = name;
            this.numbers = new ArrayList<>();
        }

        public void addPhoneNumber(PhoneNumber number) {
            this.numbers.add(number);
        }

        public boolean hasPhoneNumber(PhoneNumber number) {
            return numbers.contains(number);
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", numbers=" + numbers +
                    '}';
        }
    }

    private static class PhoneNumber {
        public final String phoneNumber;

        public PhoneNumber(String rawPhoneNumber) {
            this.phoneNumber = rawPhoneNumber.replaceAll("[^0-9]", "");
        }

        @Override
        public String toString() {
            return "PhoneNumber{" +
                    "phoneNumber='" + phoneNumber + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof PhoneNumber)) return false;
            PhoneNumber that = (PhoneNumber) o;
            return Objects.equals(phoneNumber, that.phoneNumber);
        }

        @Override
        public int hashCode() {
            return Objects.hash(phoneNumber);
        }
    }

    public static class PhoneBook {
        private final Set<Person> people;

        private PhoneBook() {
            people = new HashSet<>();
        }

        public void addPerson(Person person) {
            this.people.add(person);
        }

        @Override
        public String toString() {
            return "PhoneBook{" +
                    "people=" + people +
                    '}';
        }
    }
}
