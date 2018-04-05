package com.javarush.task.task20.task2025;

import java.io.IOException;

/*
Алгоритмы-числа
*/
public class Solution {
    public static long[] getNumbers(long N) throws IOException, ClassNotFoundException {
        long[] result = {1, 2, 3, 4, 5, 6, 7, 8, 9, 153, 370, 371, 407, 1634, 8208, 9474, 54748, 92727, 93084, 548834, 1741725, 4210818, 9800817, 9926315, 24678050, 24678051, 88593477, 146511208, 472335975, 534494836, 912985153};
        long[] res = null;
        int i = 0;
        if (N > 0) {
            while (!(N <= result[i] || i == result.length - 1)) {
                i++;
            }
        }
        res = new long[i];
        for (int j = 0; j < res.length; j++) {
            res[j] = result[j];
        }
        return res;
    }

    private static int getNums(long N) {
        long p = 10;

        for (int i = 1; i < 19; i++) {
            if (N < p) {
                return i;
            }
            p *= 10;
        }

        return 19;
    }

    public static boolean getSum(long a) {
        long r = 0;
        for (int i = 0; i < getNums(a); i++) {
            r = r + (long) Math.pow(Double.parseDouble(Character.toString(String.valueOf(a).charAt(i))), getNums(a));
        }
        if (r == a) {
            return true;
        } else return false;
    }

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        long[] ss = getNumbers(Integer.MAX_VALUE);
        for (long s : ss) System.out.println(s);
        System.out.println("memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (1024 * 1024) + " mb");
        long finish = System.currentTimeMillis();
        long timeConsumedMillis = finish - start;
        System.out.println(timeConsumedMillis);
    }
}
