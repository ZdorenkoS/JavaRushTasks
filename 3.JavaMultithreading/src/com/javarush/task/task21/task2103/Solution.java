package com.javarush.task.task21.task2103;

/* 
Все гениальное - просто!
*/
public class Solution {
    public static boolean calculate(boolean a, boolean b, boolean c, boolean d) {
          return c ;
       // return (a && b && c && !d) || (!a && c) || (!b && c) || (c && d);
    }

    public static void main(String[] args) {
        boolean a = false;boolean b = false;boolean c = false;boolean d = false;

        System.out.println((a && b && c && !d) || (!a && c) || (!b && c) || (c && d));
        System.out.println((c && ((a && b && !d) || !a || !b || d)));

    }
}
