package ru.elena;

import java.util.List;

@FunctionalInterface
public interface CheckInterface<T, S> {
   S check(List<T> list);
}
