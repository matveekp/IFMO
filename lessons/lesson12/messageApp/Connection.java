package lesson12.messageApp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Connection {

    private Socket socket;
    private ObjectInputStream objIn;
    private ObjectOutputStream objOut;

    public Connection(Socket socket) throws IOException {
        this.objIn = new ObjectInputStream(socket.getInputStream());
        this.objOut = new ObjectOutputStream(socket.getOutputStream());
    }

    Message readMessage() throws IOException, ClassNotFoundException {
        Message message = (Message) objIn.readObject();
        return message;
    }

    public void writeObject(Message message) throws IOException {
        objOut.writeObject(message);
        objOut.flush();
            }



}
