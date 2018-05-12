package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
   private Thread thread;

    @Override
    public void run() {
        try {
            // Проверка на прерывание если interrupt() был вызван во время выполнения Thread.sleep(100), и завершается трэд.
            while (!thread.currentThread().isInterrupted()) {
                System.out.println(thread.getName());
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
        }

    }

    @Override
    public void start(String threadName) {
        thread = new Thread(this,threadName);
        this.thread = thread;
        thread.start();
    }

    @Override
    public void stop() {
        thread.interrupt();
    }
}
