package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.List;

/*
Алгоритмы-числа
*/
public class Solution1 {
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
        long s=1;
        int c=15;
        long e =N/c;
        for (int i = 0; i <c ; i++) {

            Potok p = new Potok(s,e);
            p.run();
            s=e+1;
            e=e+e/2;
        }



        return result;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        getNumbers(Integer.MAX_VALUE);
        long finish = System.currentTimeMillis();
        System.out.println("Time consumed: " + (finish - start) + " ms");
        System.out.println("Memory used: "+(Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory())/1048576);



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

        }



        @Override
        public void run() {
            Solution s = new Solution();
            for (long i = start; i <stop ; i++) {
                System.out.println("Start thread: "+start+" - "+stop);
                if (s.summ(i)==i) System.out.println(i);
            }
        }
    }


}
