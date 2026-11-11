package se.lexicon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    static void main() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 25, "Stockholm", true));
        people.add(new Person("Bob", 17, "Uppsala", false));
        people.add(new Person("Charlie", 30, "Växjö", true));
        people.add(new Person("David", 22, "Gothenburg", false));

        // 🟢 Core Tasks
        System.out.println("=== Core Tasks ===");
        System.out.println("1. Active people:");
        people.stream()
                .filter(Person::isActive)
                .forEach(System.out::println);

        System.out.println("\n2. Names of all people:");
        people.stream()
                .map(Person::getName)
                .forEach(System.out::println);

        System.out.println("\n3. Count of adults:");
        long adultCount = people.stream()
                .filter(p -> p.getAge() >= 18)
                .count();
        System.out.println("Total adults: " + adultCount);

        System.out.println("\n4. Sorted by age:");
        people.stream()
                .sorted(Comparator.comparingInt(Person::getAge))
                .forEach(System.out::println);

        System.out.println("\n5. First active person in Stockholm:");
        people.stream()
                .filter(p -> p.isActive() && "Stockholm".equals(p.getCity()))
                .findFirst()
                .ifPresent(System.out::println);

        // 🟡 Optional Tasks
        System.out.println("\n=== Optional Tasks ===");
        System.out.println("6. Active adults:");
        people.stream()
                .filter(p -> p.isActive() && p.getAge() >= 18)
                .forEach(System.out::println);

        System.out.println("\n7. Active people in Stockholm:");
        people.stream()
                .filter(p -> p.isActive() && "Stockholm".equals(p.getCity()))
                .forEach(System.out::println);

        System.out.println("\n8. Inactive people older than 30:");
        people.stream()
                .filter(p -> !p.isActive() && p.getAge() > 30)
                .forEach(System.out::println);

        System.out.println("\n9. Sorted unique cities:");
        people.stream()
                .map(Person::getCity)
                .distinct()
                .sorted()
                .forEach(System.out::println);

        System.out.println("\n10. Sorted unique first letters of names:");
        people.stream()
                .map(p -> p.getName().charAt(0))
                .distinct()
                .sorted()
                .forEach(c -> System.out.print((char) c + " "));

        System.out.println("\n\n11. Formatted name (age) - city:");
        people.stream()
                .map(p -> p.getName() + " (" + p.getAge() + ") - " + p.getCity())
                .forEach(System.out::println);

        System.out.println("\n12. Emails (lowercase):");
        people.stream()
                .map(p -> p.getName().toLowerCase() + "@example.com")
                .forEach(System.out::println);
    }
}