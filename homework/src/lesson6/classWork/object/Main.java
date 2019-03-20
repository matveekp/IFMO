package lesson6.classWork.object;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {


        Object object = new Object();


        Author author = new Author("Author");

        Message message = new Message();

        message.setAuthor(author);
        message.setMessageText("message text");


        System.out.println(message.toString());

        System.out.println(message.hashCode());
        System.out.println(message.hashCode());


        Message message1 = (Message) message.clone();

    }
}