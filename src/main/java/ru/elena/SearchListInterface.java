package ru.elena;

import java.util.List;

@FunctionalInterface
public interface SearchListInterface<T> {
   List<T> search(List<T> list);
}
