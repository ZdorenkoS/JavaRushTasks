package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void sendBroadcastMessage(Message message){
        try {
            for (Map.Entry<String, Connection> pair : connectionMap.entrySet())
                pair.getValue().send(message);
        } catch (IOException e) {
            System.out.println("Сообщение не отправлено");
        }
    }

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

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException{
           Message m;
           String name;
            while (true){
                connection.send(new Message(MessageType.NAME_REQUEST));
                m=connection.receive();
                name = m.getData();
                if (m.getType()==MessageType.USER_NAME && !name.isEmpty() && !connectionMap.containsKey(name)) break;
            }
            connectionMap.put(name,connection);
            connection.send(new Message(MessageType.NAME_ACCEPTED));
            return name;
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException{
            for (Map.Entry<String, Connection> map:connectionMap.entrySet()) {
                if (map.getKey()==userName) continue;
                connection.send(new Message(MessageType.USER_ADDED, map.getKey()));

            }
        }
    }
}
