package se.lexicon;

import java.util.List;
import java.util.function.Predicate;
import java.util.function.Consumer;

public class PersonProcessor {
    // Rule composition
    public static Predicate<Person> isActive = person -> person.isActive();
    public static Predicate<Person> isAdult = person -> person.getAge() >= 18;
    public static Predicate<Person> livesInStockholm = person -> "Stockholm".equals(person.getCity());

    // Combined rules
    public static Predicate<Person> activeAndAdult = isActive.and(isAdult);
    public static Predicate<Person> adultOrStockholm = isAdult.or(livesInStockholm);
    public static Predicate<Person> notActive = isActive.negate();

    // Reusable processing
    public static List<Person> findPeople(List<Person> people, Predicate<Person> rule) {
        return people.stream()
                .filter(rule)
                .toList();
    }

    public static void applyToMatching(List<Person> people, Predicate<Person> rule, Consumer<Person> action) {
        people.forEach(person -> {
            if (rule.test(person)) {
                action.accept(person);
            }
        });
    }
}