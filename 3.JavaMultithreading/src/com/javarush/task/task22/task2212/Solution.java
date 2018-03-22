package com.javarush.task.task22.task2212;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber==null) return false;

            Pattern p = Pattern.compile("((?:\\+\\d{2})?\\(?\\d{3}\\)?\\d{3}-?\\d{2}-?\\d{2})");
            Matcher m = p.matcher(telNumber);
            if (m.matches()) return true;
            return false;
    }

    public static void main(String[] args) {
      //  System.out.println(checkTelNumber(""));
    }
}
