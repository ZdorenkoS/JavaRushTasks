package com.javarush.task.task26.task2601;

import java.util.Arrays;

/*
Почитать в инете про медиану выборки
*/
public class Solution {
    private static Integer mediana;
    public static void main(String[] args) {

    }

    public static Integer[] sort(Integer[] array) {
        Arrays.sort(array);
        if (array.length % 2 == 0) mediana = (array[array.length / 2] + array[array.length / 2 - 1]) / 2;
        else mediana = array[array.length / 2];
        Arrays.sort(array, (x, y) -> Integer.compare(Math.abs(mediana - x), Math.abs(mediana - y)));

        return array;
    }


}
