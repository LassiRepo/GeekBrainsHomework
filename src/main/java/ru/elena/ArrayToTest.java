package ru.elena;

import java.util.Arrays;

public class ArrayToTest {


    public static int[] createArray(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == 4) {
                return Arrays.copyOfRange(array, i + 1, array.length);
            }
        }
        throw new RuntimeException("Value 4 not found");
    }
    public static boolean checkArray(int[] array){
        boolean has1 = false;
        boolean has4 = false;
        for (int i = 0; i < array.length ; i++) {
            if(array[i] == 1) has1 = true;
            else if(array[i] == 4) has4 = true;
            else return false;
        }
        return has1 && has4;
    }
}
