package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User u1=new User(),u2=new User(),u3=new User();
            javaRush.users.add(u1); u1.setMale(true); u1.setCountry(User.Country.UKRAINE); u1.setFirstName("Daos");
            u1.setBirthDate(new Date());
            javaRush.users.add(u2); u2.setMale(true); u2.setCountry(User.Country.RUSSIA);  u2.setFirstName("NotDaos");
            javaRush.users.add(u3); u3.setMale(false);u3.setCountry(User.Country.OTHER);   u3.setFirstName("DaosNot");


            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(loadedObject.equals(javaRush));

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
           // e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter pw = new PrintWriter(outputStream);
            for (User u:users) {
                pw.println(u.isMale() ? true:false);
                pw.println(u.getFirstName()!=null  ? u.getFirstName(): "");
                pw.println(u.getLastName()!=null   ? u.getLastName() : "");
                pw.println(u.getBirthDate()!=null  ? u.getBirthDate().getTime(): "");
                pw.println(u.getCountry()!=null    ? u.getCountry()  : "");
            }
            pw.flush();
            }


        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            while (br.ready()){
             User u = new User();
             u.setMale(br.readLine().equals("true")? true : false);
            String f = br.readLine();
                if (!f.equals("")) u.setFirstName(f);
                String l = br.readLine();
                if (!l.equals(""))         u.setLastName(l);
             String d = br.readLine();
             if (!d.equals("")) u.setBirthDate(new Date(Long.parseLong(d)));
             String s = br.readLine();
                if (s.equals("UKRAINE")) u.setCountry(User.Country.UKRAINE);
                if (s.equals("RUSSIA")) u.setCountry(User.Country.RUSSIA);
                if (s.equals("OTHER")) u.setCountry(User.Country.OTHER);
              users.add(u);
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
