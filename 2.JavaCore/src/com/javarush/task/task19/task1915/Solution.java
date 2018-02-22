package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String file  = br.readLine();
        br.close();

        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream myStream = new PrintStream(outputStream);
        System.setOut(myStream);
        testString.printSomething();
        String result = outputStream.toString();

        FileOutputStream fos = new FileOutputStream(file);
        fos.write(outputStream.toByteArray());
        fos.flush();
        fos.close();

        System.setOut(consoleStream);
        System.out.println(result);



    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

