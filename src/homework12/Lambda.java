package homework12;

import java.util.function.Predicate;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.joining;

public class Lambda {
    public static void main(String[] args) {
        print("Names that start with A", e -> e.startsWith("A"), "Mati", "Kati", "Aadu");
        print("Values that are greater than ten", e -> e > 10, 40, 0, 4, -5, -14, 35, 1, 5, 6, 7, 8);
    }

    public static <T> void print(String beginning, Predicate<T> condition, T... elements) {
        String result = asList(elements).stream().filter(condition).map(Object::toString).collect(joining(", "));
        System.out.println(beginning + ": " + result);
    }
}