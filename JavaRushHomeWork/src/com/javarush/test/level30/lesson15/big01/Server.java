package com.javarush.test.level30.lesson15.big01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by GAVRISH on 03.06.16.
 */
public class Server
{
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    private static class Handler extends Thread {

        private Socket socket;

        //Constructor
        public Handler(Socket socket) {

            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message reply = connection.receive();
                if (reply.getType() == MessageType.USER_NAME) {
                    if (reply.getData() != null && !reply.getData().isEmpty()) {
                        if (!connectionMap.containsKey(reply.getData())) {
                            connectionMap.put(reply.getData(), connection);
                            connection.send(new Message(MessageType.NAME_ACCEPTED));
                            return reply.getData();
                        }
                    }
                }
            }
        }

       private void sendListOfUsers(Connection connection, String userName) throws IOException{
            for(String user: connectionMap.keySet()){
                Message m = new Message(MessageType.USER_ADDED,user);
                if(!user.equals(userName)){
                    connection.send(m);
                }


            }
       }

       private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException{
            while(true){
                Message message = connection.receive();
                if(message.getType().equals(MessageType.TEXT)){
                    Message newm = new Message(MessageType.TEXT, userName+": "+ message.getData());
                    sendBroadcastMessage(newm);
                }
                else
                {
                    ConsoleHelper.writeMessage("Не является сообщением!");
                }
            }

        }
        @Override
        public void run() {

            ConsoleHelper.writeMessage("Установленно соединение с адресом " + socket.getRemoteSocketAddress());
            String clientName = null;
            //Создаем Connection
            try (Connection connection = new Connection(socket)) {
                //Выводить сообщение, что установлено новое соединение с удаленным адресом
                ConsoleHelper.writeMessage("Подключение к порту: " + connection.getRemoteSocketAddress());
                //Вызывать метод, реализующий рукопожатие с клиентом, сохраняя имя нового клиента
                clientName = serverHandshake(connection);
                //Рассылать всем участникам чата информацию об имени присоединившегося участника (сообщение с типом USER_ADDED)
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, clientName));
                //Сообщать новому участнику о существующих участниках
                sendListOfUsers(connection, clientName);
                //Запускать главный цикл обработки сообщений сервером
                serverMainLoop(connection, clientName);


            } catch (IOException e) {
                ConsoleHelper.writeMessage("Ошибка при обмене данными с удаленным адресом");
            } catch (ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Ошибка при обмене данными с удаленным адресом");
            }

            //После того как все исключения обработаны, удаляем запись из connectionMap
            connectionMap.remove(clientName);
            //и отправлялем сообщение остальным пользователям
            sendBroadcastMessage(new Message(MessageType.USER_REMOVED, clientName));

            ConsoleHelper.writeMessage("Соединение с удаленным адресом закрыто");

        }

    }
        public static void main(String[] args)
    {
        ConsoleHelper.writeMessage("Введите порт сервера");
        int port = ConsoleHelper.readInt();
        try (ServerSocket serverSocket = new ServerSocket(port);)
        {
            ConsoleHelper.writeMessage("Сервер запущен");

            while (true)
            {

                    Socket socket = serverSocket.accept();
                    Handler handler = new Handler(socket);
                    handler.start();

            }
        }
        catch (IOException e)
        {
            ConsoleHelper.writeMessage("Ошибка сокета");
        }
    }

   public static void sendBroadcastMessage(Message message){

       try {

           for (Connection connection : connectionMap.values()) {
               connection.send(message);
           }

       } catch (Exception e){
           e.printStackTrace();
           ConsoleHelper.writeMessage("Сообщение не отправлено");
       }
   }


}
