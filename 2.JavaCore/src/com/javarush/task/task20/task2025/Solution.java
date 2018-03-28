package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.List;

/*
Алгоритмы-числа
*/
public class Solution {
    static long[][] power;
    static List<Long> list = new ArrayList<>();
        public static long[] getNumbers(long N) {
            long[] result=null;

            int x = (""+N).length()+2;
            power = new long[10][x];
            for (int i = 0; i <10 ; i++) {
                for (int j = 1; j <x; j++) {
                    power[i][j]= pow(i,j);
            //   System.out.printf("%11d",power[i][j]);
                }
            // System.out.println();
            }
            long z=0;
            long y = N;
            long zy = N/15;
            for (int i = 1; i <9 ; i+=2) {
                z=y-zy*i;
                if (z<0)z=1;
                Potok p = new Potok(z,y);
               p.run();
                y=z-1;
            }


      
        return result;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        getNumbers(Integer.MAX_VALUE);
        long finish = System.currentTimeMillis();
        System.out.println("Time consumed: " + (finish - start) + " ms");



    }

    public static long pow (int num, int exp) {
        long l = 1;
        for (int i = 0; i < exp; i++)
            l *= (long)num;
        return l;}

    public static long summ(long l){
            long L = 0;
            int x = (""+l).length();
        while (l > 0) {
      //     if (L>l) return l-1;
            int i =(int) (l % 10);
            L += (power[i][x]);
            l/=10;
        }
        return L;
    }

    public static class Potok implements Runnable{
        long start;
        long stop;

        public Potok(long start, long stop) {
            this.start = start;
            this.stop = stop;
            System.out.println("Start thread: "+start+" - "+stop);
        }

        public Potok(long n) {

        }

        @Override
        public void run() {
            Solution s = new Solution();
            for (long i = start; i <stop ; i++) {
                if (s.summ(i)==i) System.out.println(i);
            }
        }
    }


}
