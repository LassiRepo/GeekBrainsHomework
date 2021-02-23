package ru.elena;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PhoneBook {

    Map<String, Set<String>> phoneBook = new HashMap<>();

    public void putRecord(String surname, String phoneNumber){
        if(phoneBook.containsKey(surname)) {
            phoneBook.get(surname).add(phoneNumber);
        } else {
            Set<String> set = new HashSet<>();
            set.add(phoneNumber);
            phoneBook.put(surname, set);
        }
    }

    public String getPhoneBySurname(String surname) {
       if(phoneBook.containsKey(surname)){
           StringBuilder sb = new StringBuilder();
           for(String phone : phoneBook.get(surname)) {
               sb.append(phone);
               sb.append(" ");
           }
           return sb.toString();
       }
       return null;

    }

    public void printPhoneBook() {
        for (Map.Entry<String, Set<String>> entry : phoneBook.entrySet()) {
            StringBuilder sb = new StringBuilder();
            for(String phone : entry.getValue()) {
                sb.append(phone);
                sb.append(" ");
            }

            System.out.println(entry.getKey() + " = " + sb.toString());
        }
    }
}
