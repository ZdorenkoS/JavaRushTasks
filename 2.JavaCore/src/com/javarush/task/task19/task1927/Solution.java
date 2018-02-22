package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        //создаем адаптер к классу PrintStream
        PrintStream stream = new PrintStream(outputStream);
        //Устанавливаем его как текущий System.out
        System.setOut(stream);
        testString.printSomething();
        //Преобразовываем записанные в наш ByteArray данные в строку
        String [] result = outputStream.toString().split("\n");

        //Возвращаем все как было
        System.setOut(consoleStream);
        int count=1;
        for (int i = 0; i <result.length ; i++) {
            System.out.println(result[i]);
            if (count==2) {System.out.println("JavaRush - курсы Java онлайн"); count=0;}
            count++;
        }


    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
