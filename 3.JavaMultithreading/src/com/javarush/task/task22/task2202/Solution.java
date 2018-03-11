package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        String []s = string.split(" ");
        StringBuilder sb = new StringBuilder();
        if (s.length<3) throw new TooShortStringException();
        for (int i = 1; i <5 ; i++) {
            sb.append(s[i]+" ");
        }

        return  sb.toString().trim();
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
