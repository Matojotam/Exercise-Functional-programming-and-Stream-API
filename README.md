# Reflection Questions

## 1. Which solutions were easier to read: loop-based or stream-based?

**Stream-based**, because it makes the code look simpler.

---

## 2. Which operations felt like transformations and which felt like side effects?

### Transformations

```java
people.stream().map(Person::getName)
```

### Side Effects

```java
System.out.println(...)
setActive(...)
```

---

## 3. Where did `Predicate`, `Function`, and `Consumer` fit naturally?

- **Predicate:** Used naturally for filtering people based on a condition.

  ```java
  people.stream().filter(p -> p.getAge() >= 18)
  ```

- **Function:** Used naturally for transforming a person into an email address.

  ```java
  people.stream().map(p -> p.getName() + "@example.com")
  ```

- **Consumer:** Used naturally for side effects, such as printing.

  ```java
  people.forEach(System.out::println)
  ```