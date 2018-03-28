package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) {
       StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fr = new BufferedReader(new FileReader(br.readLine()))) {
                while (fr.ready()){sb.append(fr.readLine());
                sb.append(" ");}
        } catch (IOException e){e.printStackTrace();}
        String [] s = sb.toString().split(" ");
         for (int i = 0; i <s.length ; i++) {
            for (int j = i+1; j <s.length ; j++) {
                if (s[i].equals(new StringBuilder(s[j]).reverse().toString()))
                {result.add(new Pair(s[i], s[j]));
                   s[i]=""+Math.random();
                   s[j]="" + Math.random();

                }
            }
        }
        for (Pair p :result) {System.out.println(p.first+" "+p.second);}

    }

    public static class Pair {
        String first;
        String second;

        public Pair() {
        }

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
