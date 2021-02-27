package ru.elena;

import java.util.List;

@FunctionalInterface
public interface SearchInterface<T> {
    int foo(T number, List<T> list);
}
