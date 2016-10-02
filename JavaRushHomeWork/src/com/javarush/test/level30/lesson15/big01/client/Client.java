package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.Connection;
import com.javarush.test.level30.lesson15.big01.ConsoleHelper;
import com.javarush.test.level30.lesson15.big01.Message;
import com.javarush.test.level30.lesson15.big01.MessageType;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by GAVRISH on 07.06.16.
 */
public class Client
{
    protected Connection connection;
    volatile private boolean clientConnected = false;

    public static void main(String[] args) {

        Client client = new Client();
        client.run();
    }

    public void run(){
        Thread th = getSocketThread();
        th.setDaemon(true);
        // Запустить вспомогательный поток
        th.start();

        // Заставить текущий поток ожидать, пока он не получит нотификацию из другого потока
        try {
            synchronized (this) {
                this.wait();
            }
        } catch (InterruptedException e) {
            ConsoleHelper.writeMessage("Ошибка");
            return;
        }
        //После того, как поток дождался нотификации, проверь значение clientConnected
        if (clientConnected) {
            ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");

            //Считывай сообщения с консоли пока клиент подключен. Если будет введена команда 'exit', то выйди из цикла
            while (clientConnected) {
                String message;
                if (!(message = ConsoleHelper.readString()).equals("exit")) {
                    if (shouldSentTextFromConsole()) {
                        sendTextMessage(message);
                    }
                } else {
                    return;
                }
            }
        }
        else {
            ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
        }
    }
    public class SocketThread extends Thread{

        protected void clientMainLoop() throws IOException, ClassNotFoundException {

            while (true) {

                // В цикле получать сообщения, используя соединение connection
                Message message = connection.receive();

                switch (message.getType()) {

                    // Если это текстовое сообщение (тип TEXT), обработай его с помощью метода processIncomingMessage()
                    case TEXT:
                        processIncomingMessage(message.getData());
                        break;

                    // Если это сообщение с типом USER_ADDED, обработай его с помощью метода informAboutAddingNewUser()
                    case USER_ADDED:
                        informAboutAddingNewUser(message.getData());
                        break;

                    // Если это сообщение с типом USER_REMOVED, обработай его с помощью метода informAboutDeletingNewUser()
                    case USER_REMOVED:
                        informAboutDeletingNewUser(message.getData());
                        break;

                    default:
                        throw new IOException("Unexpected MessageType");
                }
            }
        }


        protected void clientHandshake() throws IOException,ClassNotFoundException{
            while (true) {

                // В цикле получать сообщения, используя соединение connection
                Message message = connection.receive();

                switch (message.getType()) {

                    // 	Если тип полученного сообщения NAME_REQUEST (сервер запросил имя)
                    case NAME_REQUEST: {

                        // запросить ввод имени пользователя с помощью метода getUserName()
                        // создать новое сообщение с типом USER_NAME и введенным именем, отправить сообщение серверу.
                        String userName = getUserName();
                        connection.send(new Message(MessageType.USER_NAME, userName));
                        break;
                    }

                    // Если тип полученного сообщения NAME_ACCEPTED (сервер принял имя)
                    case NAME_ACCEPTED: {

                        // значит сервер принял имя клиента, нужно об этом сообщить главному потоку, он этого очень ждет.
                        // Сделай это с помощью метода notifyConnectionStatusChanged(), передав в него true. После этого выйди из метода.
                        notifyConnectionStatusChanged(true);
                        return;
                    }

                    default: {
                        throw new IOException("Unexpected MessageType");
                    }
                }
            }
        }

        protected void processIncomingMessage(String message){
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName){
            ConsoleHelper.writeMessage(userName + " присоединился к чату");
        }

        protected void informAboutDeletingNewUser(String userName){
            ConsoleHelper.writeMessage(userName + " покинул чат");
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected){
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this){
                Client.this.notify();
            }
        }
       public void run(){
           try {
               // Создай новый объект класса java.net.Socket c запросом сервера и порта
               Socket socket = new Socket(getServerAddress(), getServerPort());

               // Создай объект класса Connection, используя сокет
               Client.this.connection = new Connection(socket);


               clientHandshake();
               clientMainLoop();


           } catch (IOException e) {
               notifyConnectionStatusChanged(false);
           } catch (ClassNotFoundException e) {
               notifyConnectionStatusChanged(false);
           }
    }
}
    protected String getServerAddress(){
        ConsoleHelper.writeMessage("Введите адрес сервера");
        return ConsoleHelper.readString();
    }
    protected int getServerPort(){
        ConsoleHelper.writeMessage("Введите порт сервера");
        return ConsoleHelper.readInt();
    }

    protected String getUserName(){
        ConsoleHelper.writeMessage("Введите имя пользователя");
        return ConsoleHelper.readString();
    }

    protected boolean shouldSentTextFromConsole(){
        return true;
    }
    protected SocketThread getSocketThread(){
        return new SocketThread();
    }
    protected void sendTextMessage(String text){
        Message m = new Message(MessageType.TEXT,text);
        try
        {
            connection.send(m);
        }
        catch (IOException e)
        {
            ConsoleHelper.writeMessage("Error!");
            clientConnected = false;
        }
    }

}
