package com.javarush.task.task18.task1812;

import java.io.*;

/* 
Расширяем AmigoOutputStream
*/

public class QuestionFileOutputStream implements AmigoOutputStream {
    AmigoOutputStream field;

    public QuestionFileOutputStream(AmigoOutputStream field) {
        this.field = field;
    }


    @Override
    public void flush() throws IOException {
        field.flush();
    }

    @Override
    public void write(int b) throws IOException {
        field.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        field.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        field.write(b, off,len);
    }

    @Override
    public void close() throws IOException {
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        String  s = new BufferedReader(new InputStreamReader(System.in)).readLine();
        if (s.equals("Д")) field.close();
    }
}

