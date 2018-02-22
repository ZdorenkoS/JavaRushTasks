package com.javarush.task.task16.task1630;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    static {
        try {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        firstFileName = reader.readLine();
        secondFileName = reader.readLine();
        reader.close();}
            catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface extends Runnable {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface {
        private String fullFileName;
        private String fileContent="";

        @Override
        public void setFileName(String fullFileName) {
           this.fullFileName=fullFileName;
        }

        @Override
        public String getFileContent() {
            return fileContent;
        }

        @Override
        public void run() {
            if (!fullFileName.isEmpty()){
                try {
                    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(fullFileName)), StandardCharsets.UTF_8));

                    String line;
                    try{
                        while((line = br.readLine()) != null){
                            fileContent+=line+" ";
                        }
                        br.close();} catch (FileNotFoundException e){e.printStackTrace();}} catch (IOException e){e.printStackTrace();}}
        }
    }
}
