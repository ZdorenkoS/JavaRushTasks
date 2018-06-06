package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(ConsoleHelper.readInt());
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Error when create socket!!!");
        }
        ConsoleHelper.writeMessage("Server is running...");
        while (true){
            try {
                Socket s = serverSocket.accept();
                Handler handler = new Handler(s);
                handler.start();
            } catch (Exception e){
                ConsoleHelper.writeMessage("Error!!!");
                serverSocket.close();
                break;
            }
        }

    }

    private static class Handler extends Thread{
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }
    }
}
