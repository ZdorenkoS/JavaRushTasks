package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        br.close();

        List<String> lines = new ArrayList<>();
        BufferedReader  fr = new BufferedReader (new FileReader(fileName));
        String line;
        while ((line = fr.readLine())!=null){
            if (line.length()>0 && args[0].equals("-d") && args[1].equals(line.substring(0,8).trim())) continue;
            if (line.length()>0 && args[0].equals("-u") && args[1].equals(line.substring(0,8).trim())) {
                StringBuilder sb = new StringBuilder();
                sb.append(args[1]);    while (sb.length()<8)  sb.append(" ");
                sb.append(args[2]);    while (sb.length()<38) sb.append(" ");
                sb.append(args[3]);    while (sb.length()<46) sb.append(" ");
                sb.append(args[4]);    while (sb.length()<50) sb.append(" ");
            line = sb.toString();
            }
            lines.add(line+"\n");
        }
        fr.close();

        FileOutputStream os = new FileOutputStream(fileName);
        for (int i = 0; i <lines.size(); i++) {
            os.write((lines.get(i)).getBytes());

        }
        os.close();
        lines.clear();
    }
}
