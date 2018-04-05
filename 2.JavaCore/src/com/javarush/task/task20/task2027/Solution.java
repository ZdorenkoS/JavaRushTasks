package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        detectAllWords(crossword, "home", "same");

        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
            List<Word> list = new ArrayList<>();

        //список слов для которых найдена первая буква
        ArrayList<Word> firstLetter = new ArrayList<>();

        // ищем первую букву и записываем в firstLetter Word с координатами первой буквы
        for (String s :words) {
            for (int i = 0; i <crossword.length ; i++) {
                for (int j = 0; j <crossword[i].length ; j++) {
                    if (s.charAt(0) == crossword[i][j]) {
                       Word w = new Word(s);
                       w.startX=j;
                       w.startY=i;
                       firstLetter.add(w);
                    }
                }
            }
        }

        // ищем конец слова
        for (Word w:firstLetter) {

        }





        return list;
    }




    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
