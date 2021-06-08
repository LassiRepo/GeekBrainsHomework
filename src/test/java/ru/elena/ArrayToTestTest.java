package ru.elena;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;



class ArrayToTestTest {

    @ParameterizedTest
    @MethodSource("fillCreateParams")
    void createArray(int [] in, int [] out) {
        Assertions.assertArrayEquals(out, ArrayToTest.createArray(in));

    }


    static Stream<Arguments> fillCreateParams(){
        List<Arguments> list = new ArrayList<>();
        list.add(Arguments.arguments(new int[]{1,1,1,9,5,3,4,9,6,4,1,1}, new int[]{1,1}));
        list.add(Arguments.arguments(new int[]{1,1,1,9,5,3,4,9,6,4,}, new int[]{}));
        list.add(Arguments.arguments(new int[]{1,1,1,9,5,3,4,9,6,1,1}, new int[]{9,6,1,1}));
        return list.stream();
    }



    @Test
    void createArrayException() {
//        Assertions.assertArrayEquals();
        Assertions.assertThrows(RuntimeException.class, () -> ArrayToTest.createArray(new int[] {1, 8, 666, 5}));

    }

    @Test
    void checkArray() {
        Assertions.assertTrue(ArrayToTest.checkArray(new int[] {1, 4, 1, 4, 1}));
    }
}