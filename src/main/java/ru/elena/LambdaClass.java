package ru.elena;

import java.util.List;

public class LambdaClass {

    public int search(Integer n, List<Integer> list, SearchInterface<Integer> myInter) {
        return myInter.foo(n, list);
    }

    public String reverse(String s, ReverseInterface reverseInterface) {
        return reverseInterface.reverse(s);
    }

    public Integer maximum(List<Integer> list, CheckInterface<Integer, Integer> checkInterface) {
        return checkInterface.check(list);
    }

    public Double average(List<Integer> list, CheckInterface<Integer, Double> checkInterface) {
        return checkInterface.check(list);
    }

    public  List<String> search(List<String> list,SearchListInterface<String> searchListInterface) {
        return searchListInterface.search(list);
    }
}

