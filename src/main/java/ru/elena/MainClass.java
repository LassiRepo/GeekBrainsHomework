package ru.elena;

public class MainClass {
    public static void main(String[] args) {
        String arr[][] = {
                {"1", "6", "7", "9"},
                {"1", "10", "9", "97", "97", "97"},
                {"8", "98",}};

        // summ = 32
        String arr2[][] = {
                {"2", "2", "2", "2"},
                {"2", "2", "2", "2"},
                {"2", "2", "2", "2"},
                {"2", "2", "2", "2"}
        };

        String arr3[][] = {
                {"2", "2", "2", "2"},
                {"2", "а", "2", "2"},
                {"2", "2", "2", "2"},
                {"2", "2", "2", "2"}
        };

        try {
            System.out.println("Сумма элементов " + summArray(arr2));
        } catch (MyArrayDataException myde) {
            System.out.println(myde.getMessage());
        } catch (MyArraySizeException mase){
            System.out.println("Ошибка. Неверный размер массива");
        }
    }

    private static int summArray(String arr[][]) throws MyArrayDataException {
        int summ = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr.length != 4 || arr[0].length != 4) {
                    throw new MyArraySizeException();
                }

                try {
                    summ += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException nfe) {
                    throw new MyArrayDataException("Ошибка. В ячейке [" + i + "][" + j + "] не число");
                }
            }
        }
        return summ;
    }

}
