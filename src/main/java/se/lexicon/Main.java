package se.lexicon;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 25, "Stockholm", true));
        people.add(new Person("Bob", 17, "Uppsala", false));
        people.add(new Person("Charlie", 30, "Växjö", true));
        people.add(new Person("David", 22, "Gothenburg", false));

        // Print names of active adults
        PersonProcessor.applyToMatching(
                people,
                PersonProcessor.activeAndAdult,
                person -> System.out.println("Name: " + person.getName())
        );

        // Send emails to people in Stockholm
        PersonProcessor.applyToMatching(
                people,
                PersonProcessor.livesInStockholm,
                person -> System.out.println("Send email to " + person.getName())
        );
    }
}