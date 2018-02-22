package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException, NumberFormatException{
        ArrayList<String> list = new ArrayList<>(Arrays.asList(args));
        switch (args[0]) {
            case "-c": {
                synchronized (allPeople){
                for (int i = 1; i <list.size();i+=3) {
                List<String> temp = list.subList(i,i+3);
               Person p = null;
                if (temp.get(1).equals("м"))
                    allPeople.add(p=Person.createMale(temp.get(0), new SimpleDateFormat("dd/MM/yyyy").parse(temp.get(2))));
                else if (temp.get(1).equals("ж"))
                    allPeople.add(p=Person.createFemale(temp.get(0), new SimpleDateFormat("dd/MM/yyyy").parse(temp.get(2))));
                System.out.println(allPeople.indexOf(p));
                }
                break;}}


            case "-u": {
                synchronized (allPeople){
                for (int i = 1; i <list.size();i+=4) {
                    List<String> temp = list.subList(i, i + 4);

                    Person p = allPeople.get(Integer.parseInt(temp.get(0)));
                    p.setBirthDay(new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(temp.get(3)));
                    p.setName(temp.get(1));
                    if (temp.get(2).equals("м")) p.setSex(Sex.MALE);
                    else if ("ж".equals(temp.get(2))) p.setSex(Sex.FEMALE);
                }
                break;}
            }
            case "-d": {
                synchronized (allPeople){
                for (int i = 1; i <args.length ; i++) {
                Person p = allPeople.get(Integer.parseInt(args[i]));
                p.setName(null);
                p.setSex(null);
                p.setBirthDay(null);
                }
                break;}
            }

            case "-i": {
                synchronized (allPeople){
                for (int i = 1; i <args.length ; i++) {
                    Person p = allPeople.get(Integer.parseInt(args[i]));
                    String s = "";
                    if (p.getSex().equals(Sex.MALE)) s = "м";
                    else s = "ж";
                    System.out.println(p.getName() + " " + s + " " + new SimpleDateFormat(" dd-MMM-yyyy", Locale.ENGLISH).format(p.getBirthDay()));
                }
                break;}
            }
        }

    }

}
