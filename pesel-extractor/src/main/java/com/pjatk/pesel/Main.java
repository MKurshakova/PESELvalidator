package com.pjatk.pesel;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Locale;

public class Main {

    public static void main(String[] args){

        String pesel = "94011341966";

        if(!PeselValidator.isValid(pesel))return;

        Person person = new Person(pesel);
        person.setName("Jan");
        person.setLastName("Kowalski");
        System.out.println("imie: " + person.getName());
        System.out.println("nazwisko: " + person.getLastName());
        System.out.println("nr pesel: " + person.getPeselNumber());

        System.out.println("płeć: " +  person.getGender());

        System.out.println("Urodzony:");
        System.out.println("Rok: " + person.getDateOfBirth().getYear());
        System.out.println("Miesiąc: " +person.getDateOfBirth().getMonth().toString());
        System.out.println("Dzień: " +person.getDateOfBirth().getDayOfMonth());

        System.out.println("Dzien tygodnia: " +person.getDateOfBirth().getDayOfWeek().toString());

        funWithDates();
        funWithString();
    }

    static void funWithDates(){

        print("-------------------------------------------------------------");
        LocalDate date = LocalDate.of(2005, 10, 19);


        print(date.getDayOfMonth());
        print(date.getYear());
        print(date.getDayOfWeek());

        print(date.plusMonths(3));
        print(date.minusYears(4));

        print(LocalDate.now().isAfter(date));
        print("-------------------------------------------------------------");
    }

    static void funWithString(){
        print("-------------------------------------------------------------");
        String text = "Ala ma kota";

        print(text.toUpperCase(Locale.ROOT));
        print(text.toLowerCase(Locale.ROOT));

        print(text.replace("Ala", "Maciek"));

        print(text.contains("kot"));

        print(text.substring(4,6));

        print("test@wp.pl".matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$"));

        String sequenceOfNumbers = "12345";

        for (char c :
                sequenceOfNumbers.toCharArray()) {
            print(Integer.parseInt(c + ""));
        }

        int number = Integer.parseInt(sequenceOfNumbers.substring(0,1));
        print(number);
        print("-------------------------------------------------------------");
    }

    static void print(Object obj){
        System.out.println(obj);
    }
}
