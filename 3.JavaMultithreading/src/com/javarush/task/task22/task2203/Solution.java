package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
       if (string == null) throw new TooShortStringException();
       if ((string.length() - string.replace("\t", "").length()) < 2) throw new TooShortStringException();

       int s = string.indexOf("\t")+1;
       int f = string.indexOf("\t",s);
       return string.substring(s,f);
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
