package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BotClient extends Client {

    public class BotSocketThread extends SocketThread{
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            if (message != null && message.contains(":")) {
                int x = message.indexOf(':');
                String name = message.substring(0, x);
                String text = message.substring(x + 2);
                SimpleDateFormat dateFormat;
                switch (text) {
                    case "дата":     dateFormat = new SimpleDateFormat("d.MM.YYYY");  break;
                    case "день":     dateFormat = new SimpleDateFormat("d");          break;
                    case "месяц":    dateFormat = new SimpleDateFormat("MMMM");       break;
                    case "год":      dateFormat = new SimpleDateFormat("YYYY");       break;
                    case "время":    dateFormat = new SimpleDateFormat("H:mm:ss");    break;
                    case "час":      dateFormat = new SimpleDateFormat("H");          break;
                    case "минуты":   dateFormat = new SimpleDateFormat("m");          break;
                    case "секунды":  dateFormat = new SimpleDateFormat("s");          break;
                    default:         dateFormat = null;
                }
                if (dateFormat != null) sendTextMessage("Информация для " + name + ": " + dateFormat.format(Calendar.getInstance().getTime()));
        }
        }
    }

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }

    @Override
    protected String getUserName() {
        return  "date_bot_"+(int)(Math.random()*100);
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }
}
