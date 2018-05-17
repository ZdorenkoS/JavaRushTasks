package com.javarush.task.task25.task2512;

/* 
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        printException(e);

    }

    public static void printException(Throwable e){
        if (e.getCause() != null) {printException(e.getCause());}
        System.out.println(String.format("%s: %s", e.getClass().getName(), e.getMessage()));
        }

    public static void main(String[] args) {
 /*   Throwable e = new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")));
        printException(e);*/
    }
}
