package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException, NumberFormatException {
        switch (args[0]) {
            case "-c": {
               Person p = null;
                if (args[2].equals("м"))
                    allPeople.add(p=Person.createMale(args[1], new SimpleDateFormat("dd/MM/yyyy").parse(args[3])));
                else if (args[2].equals("ж"))   allPeople.add(p=Person.createFemale(args[1], new SimpleDateFormat("dd/MM/yyyy").parse(args[3])));
                System.out.println(allPeople.indexOf(p));
                break;
            }

            case "-u": {

                Person p=allPeople.get(Integer.parseInt(args[1]));
                p.setBirthDay(new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH).parse(args[4]));
                p.setName(args[2]);
                if (args[3].equals("м")) p.setSex(Sex.MALE);
                else if("ж".equals(args[3])) p.setSex(Sex.FEMALE);
                break;
            }
            case "-d": {
                Person p = allPeople.get(Integer.parseInt(args[1]));
                p.setName(null);
                p.setSex(null);
                p.setBirthDay(null);
                break;
            }

            case "-i": {
                Person p=allPeople.get(Integer.parseInt(args[1]));
                String s ="";
                if (p.getSex().equals(Sex.MALE)) s="м"; else s="ж";
                System.out.println(p.getName() + " " + s + " " + new SimpleDateFormat(" dd-MMM-yyyy", Locale.ENGLISH).format(p.getBirthDay()));
                break;
            }
        }

    }

}
