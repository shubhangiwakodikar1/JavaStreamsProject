package org.example;

import java.util.Optional;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Main main = new Main();
        String returnedString = main.returnString();
        System.out.println("returnedString: " + returnedString);

        main.streamExercise();
    }

    public String returnString() {
        return "string";
    }

    public void streamExercise() {
        Stream<String> stringStream = Stream.empty();
        Optional<String> foundString = stringStream.findFirst();
        System.out.println("foundFirstString: " + foundString);
    }


}