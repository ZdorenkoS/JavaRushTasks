package com.javarush.task.task20.task2025;

import java.util.Date;

/*
Алгоритмы-числа
*/
public class Solution1 {
    public static long[] getNumbers(long N) {
        long[] result=new long[50];
        int x = (""+N).length()+2;
        long[][] power = new long[10][x];
        for (int i = 0; i <10 ; i++) {
            for (int j = 1; j <x; j++) {
                power[i][j]= (long)Math.pow(i,j);
            }
        }
        for (long i = 1; i <N ; i++) {
            long summ=0;
            char [] cifri =(""+i).toCharArray();
            for (int j = 0; j <cifri.length ; j++) {


            }

        }



        return result;
    }

    public static void main(String[] args) {

        Date d = new Date();
        getNumbers(2147483647l);
        System.out.println((new Date().getTime()-d.getTime())/1000);


    }
}
