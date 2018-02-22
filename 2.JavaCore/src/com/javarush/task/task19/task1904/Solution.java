package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner{
       private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException, ParseException {
            String lines [] = fileScanner.nextLine().split(" ",4);
            SimpleDateFormat date = new SimpleDateFormat();
            date.applyPattern("dd MM yyyy");
            return new Person(lines[1],lines[2],lines[0],date.parse(lines[3]));
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
