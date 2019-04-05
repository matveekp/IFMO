package lesson12;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


    public class Server {
        private int port;
        Connection connection;




        public Server(int port){
            this.port = port;
        }



        public void start() throws IOException {
            try (ServerSocket serverSocket = new ServerSocket(port)){
                System.out.println("Server started...");
                while (true){
                    Socket socket = serverSocket.accept();
                    connection = new Connection(socket);
                    printMessage(connection.readMessage());
                    connection.sendMessage(new Message("server", "сообщение получено"));
//                getMessage(socket);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

//    private void getMessage(Socket socket) throws IOException, ClassNotFoundException {
//        try (ObjectInputStream objIn = new ObjectInputStream(socket.getInputStream())){
//            Object obj = objIn.readObject();
//            printMessage((Message) obj);
//        }
//    }

        private void printMessage(Message message){
            System.out.println("получено сообщение: " +
                    message.getMessageText() + " от " + message.getSender());
        }



        public static void main(String[] args) {
            int port = 8090;
            Server messageServer = new Server(port);
            try {
                messageServer.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }




