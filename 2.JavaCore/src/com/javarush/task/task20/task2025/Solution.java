package com.javarush.task.task20.task2025;

import java.util.ArrayList;

/*
Алгоритмы-числа
*/
public class Solution {
    public static long[] getNumbers(long N) {
        long[] result = new long[100];
        int count =0;
        ArrayList<Long> list = new ArrayList<>();
        for (long i = 1; i <N ; i++) {
            long summ=0;
          char [] cifri =(""+i).toCharArray();
            for (int j = 0; j <cifri.length ; j++) {
                summ += Math.pow(Long.valueOf(""+ cifri[j]),cifri.length);

            }
            if (summ==i) {result[count]=i; count++;}
        }

        return result;
    }

    public static void main(String[] args) {



    }
}
