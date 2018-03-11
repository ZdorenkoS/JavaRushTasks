package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        if (string == null) {
            throw new TooShortStringException();
        }
        String []s = string.split(" ");
        StringBuilder sb = new StringBuilder();
       try {
        for (int i = 1; i <5 ; i++) {
            sb.append(s[i]+" ");
        }

        return  sb.toString().trim();}
        catch (RuntimeException r) {
           if ((string.length() - string.replace(" ", "").length()) < 4) throw new TooShortStringException();
        return null;
       }
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
