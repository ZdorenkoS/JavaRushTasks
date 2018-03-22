package com.javarush.task.task22.task2211;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;


/* 
Смена кодировки
*/
public class Solution_ {
    public static void main(String[] args) throws IOException {
        String s = Files.lines(Paths.get(args[0]), Charset.forName("Windows-1251"))
                .collect(Collectors.joining(System.lineSeparator()));
        Files.write(Paths.get(args[1]), Arrays.asList(s), StandardCharsets.UTF_8);
    }
}
