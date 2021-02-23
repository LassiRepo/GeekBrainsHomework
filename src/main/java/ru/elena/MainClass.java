package ru.elena;

import java.util.*;

public class MainClass {
    public static void main(String[] args) {

        List<String> arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList("домино", "футбол", "хоккей", "бег",
                "домино", "футбол", "хоккей", "бег",
                "прыжки", "биатлон", "шахматы", "стрельба",
                "шахматы", "гимнастика", "гимнастика", "теннис"));

        Set<String> uniqueWords = new HashSet<>(arrayList);
        System.out.println(uniqueWords);

        HashMap<String, Integer> myMap = new HashMap<>();

        for (String word : arrayList) {
            if (myMap.containsKey(word)) {
                myMap.put(word, myMap.get(word) + 1);
            } else {
                myMap.put(word, 1);
            }
        }

        for (Map.Entry<String, Integer> entry : myMap.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.putRecord("Иванов", "8888888");
        phoneBook.putRecord("Сидоров", "00000000");
        phoneBook.putRecord("Петров", "111111111");
        phoneBook.putRecord("Петров", "574747476");
        phoneBook.putRecord("Зайцев", "5485787987");

        System.out.println(phoneBook.getPhoneBySurname("Зайцев"));
        System.out.println(phoneBook.getPhoneBySurname("Волков"));
        System.out.println(phoneBook.getPhoneBySurname("Петров"));
    }

}
