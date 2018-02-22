package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        TreeMap<Integer,String> map = new TreeMap<>();
        while (!(line=br.readLine()).equals("end")){
        map.put(Integer.parseInt(line.substring(line.lastIndexOf('.')+5)),line);
        }
        br.close();

        File f = new File(map.get(1).substring(0, map.get(1).length()-6));
        FileOutputStream os = new FileOutputStream(f);
        byte[] bytes = new byte[100_000];
        int count;
        for (int i = 1; i <map.size()+1 ; i++) {
            FileInputStream is = new FileInputStream(map.get(i));
            count = is.read(bytes);
            os.write(bytes, 0, count);

            is.close();
        }
        os.close();

    }
}
