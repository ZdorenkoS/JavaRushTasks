package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread{
    private Thread t;
    public LoggingStateThread(Thread target) {
       t=target;
    }

    @Override
    public void run() {
        Thread.State state = State.TERMINATED;
        super.run(); // ???? без этого валидацию не проходило!
      do {
          if (t.getState() != state) {
              System.out.println(t.getState());
              state = t.getState();
          }
      }
       while (t.getState()!=State.TERMINATED);

       this.interrupt();
    }
}
