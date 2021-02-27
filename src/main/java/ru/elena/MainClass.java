package ru.elena;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainClass {
    public static void main(String[] args) {
        LambdaClass myClass = new LambdaClass();

        // Задание 2
        Integer n = 507;
        List<Integer> list = Arrays.asList(0, 9, 66, 507, 1, 63);

        int index = myClass.search(n, list, (a, b) -> list.stream()
                .filter(n::equals)
                .findFirst()
                .map(list::indexOf).orElse(-1));
        System.out.println(index);

        // Задание 3
        String s = "java interview";
        String reversedString = myClass.reverse(s, (string) -> Stream.of(string)
                .map(word -> new StringBuilder(word).reverse())
                .collect(Collectors.joining(" ")));
        System.out.println(reversedString);

        // Задание 4
        Integer maximumInteger = myClass.maximum(list, (newList) -> {
            Integer number = newList.get(0);
            for (Integer el : newList) {
                if (number < el) {
                    number = el;
                }
            }
            return number;
        });
        System.out.println(maximumInteger);

        // Задание 5
        Double averageInteger = myClass.average(list, (newList) -> {
            Double summ = 0.0;
            for (Integer el : newList) {
                summ = summ + el;

            }
            return summ / newList.size();
        });
        System.out.println(averageInteger);

        // Задание 6
        List<String> stringList = Arrays.asList("abc", "mmmlk", "aaaaaaaaa", "am", "roro", "ghjhgj", "amn", "Agygyg");
        List<String> newStringList = myClass.search(stringList,
                (l) -> l.stream()
                .filter(word -> word.length() == 3 && word.substring(0, 1).equals("a"))
                .collect(Collectors.toList()));
        System.out.println(newStringList);



    }



}
