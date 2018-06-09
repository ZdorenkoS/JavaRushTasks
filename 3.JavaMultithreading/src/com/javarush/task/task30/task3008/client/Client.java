package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.*;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client {
    private volatile boolean clientConnected = false;
    protected Connection connection;

    protected String getServerAddress(){
        ConsoleHelper.writeMessage("Input server address");
        return ConsoleHelper.readString();
    }

    protected int getServerPort(){
        ConsoleHelper.writeMessage("Input port number");
        return ConsoleHelper.readInt();
    }

    protected String getUserName(){
        ConsoleHelper.writeMessage("Input user name");
        return ConsoleHelper.readString();
    }

    protected boolean shouldSendTextFromConsole(){
        return true;
    }

    protected SocketThread getSocketThread(){
        return new SocketThread();
    }

    protected void sendTextMessage(String text){
        try {
            connection.send(new Message(MessageType.TEXT,text));
        } catch (IOException e) {
            clientConnected=false;
            ConsoleHelper.writeMessage("Message not send");
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }

    public void run() {
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();

        try {
            synchronized (this){
            wait();}
        } catch (InterruptedException e) {
            ConsoleHelper.writeMessage("Error, programm terminated");
            socketThread.isInterrupted();
        }

        if (clientConnected) {
            ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");
        } else {
            ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
        }
        String s;

        while (clientConnected){
            s = ConsoleHelper.readString();
            if (shouldSendTextFromConsole()) sendTextMessage(s);
            if (s.equals("exit")) break;
        }

    }

    public class SocketThread extends Thread{
        protected void processIncomingMessage(String message){
            ConsoleHelper.writeMessage(message);
            }

         protected void informAboutAddingNewUser(String userName){
             ConsoleHelper.writeMessage(userName+" join to chat");
         }

        protected void informAboutDeletingNewUser(String userName) {
            ConsoleHelper.writeMessage(userName + " leave a chat");
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected){
           Client.this.clientConnected = clientConnected;
            synchronized (Client.this){
                Client.this.notify();

            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException{
        loop:  while (true){
               Message m = connection.receive();
            if (m.getType() == MessageType.NAME_REQUEST) {
                connection.send(new Message(MessageType.USER_NAME, getUserName()));
            } else if (m.getType() == MessageType.NAME_ACCEPTED) {
                notifyConnectionStatusChanged(true);
                break loop;
            } else {
                throw new IOException("Unexpected MessageType");
            }
            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            while (true) {
                Message m = connection.receive();
                if (m.getType() == MessageType.TEXT) {
                    processIncomingMessage(m.getData());

                } else if (m.getType() == MessageType.USER_ADDED) {
                    informAboutAddingNewUser(m.getData());

                } else if (m.getType() == MessageType.USER_REMOVED) {
                    informAboutDeletingNewUser(m.getData());

                } else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }

        @Override
        public void run() {
           String address =  getServerAddress();
           int port = getServerPort();
            Socket socket;
            try {
               socket = new Socket(address, port);
               connection = new Connection(socket);
               clientHandshake();
               clientMainLoop();

           }
           catch (UnknownHostException e){notifyConnectionStatusChanged(false);}
           catch (IOException e){ notifyConnectionStatusChanged(false);}
           catch (ClassNotFoundException e) {notifyConnectionStatusChanged(false);
           }
        }
    }
}
