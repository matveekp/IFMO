package lesson9;

import java.util.*;

enum MessagePriority {
    LOW, MEDIUM, HIGH, URGENT;

    public static MessagePriority getPriority(int ord){
        for (MessagePriority mp: values()){
            if (ord == mp.ordinal()) {
                return mp;
            }
        }
        throw new AssertionError("Wrong ordinal: " + ord);
    }
}


public class Message {
    private int code;
    private  MessagePriority priority;

    public Message(int code, MessagePriority priority) {
        this.code = code;
        this.priority = priority;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public MessagePriority getPriority() {
        return priority;
    }

    public void setPriority(MessagePriority priority) {
        this.priority = priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        if (code != message.code) return false;
        return priority == message.priority;
    }

    @Override
    public int hashCode() {
        int result = code;
        result = 31 * result + (priority != null ? priority.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Message{" +
                "code=" + code +
                ", priority=" + priority +
                '}';
    }



}

class Test2 {
    public static void main(String[] args) {


        List<Message> myList = new ArrayList<>(MessageGenerator.generate(500));

        MessageTask.countEachPriority(myList);

        System.out.println("----------");
        MessageTask.countEachCode(myList);

        System.out.println("----------");
        MessageTask.uniqueMessageCount(myList);


        System.out.println("----------");
        System.out.println(MessageTask.uniqueMessagesInOriginalOrder(myList));


    }
}





class MessageTask {
    public static void countEachPriority(List<Message> messageList) {
        // Подсчитать количество сообщений для каждого приоритела
        // Ответ в консоль

        int[] count = new int[MessagePriority.values().length];

        for (Message message : messageList) {
            count[message.getPriority().ordinal()] ++;
        }

        for (int i = 0; i < count.length; i++) {
            System.out.println(MessagePriority.getPriority(i) + " : " + count[i]);
        }
    }

    public static void countEachCode(List<Message> messageList) {
        // Подсчитать количество сообщений для каждого кода сообщения
        // Ответ в консоль
        int[] count = new int[10];

        for (Message message : messageList) {
            count[message.getCode()] ++;
        }

        for (int i = 0; i < count.length; i++) {
            System.out.println(i + " : " + count[i]);
        }


    }

    public static void uniqueMessageCount(List<Message> messageList) {
        // Подсчитать количество уникальных сообщений
        // Ответ в консоль

        int[] count = new int[10];
        Set<Message> result = new HashSet<>();

        for (Message message : messageList) {
            result.add(message);
        }

        System.out.println("количество уникальных сообщений: " + result.size());


    }

    public static List<Message> uniqueMessagesInOriginalOrder(List<Message> messageList){
        // вернуть только неповторяющиеся сообщения и в том порядке, в котором они
        // встретились в первоначальном списке
        // Например, было
//        [{URGENT, 4}, {HIGH, 9}, {LOW, 3}, {HIGH, 9}]
        // на выходе:
        // [{URGENT, 4}, {HIGH, 9}, {LOW, 3}]

        Set<Message> unique = new LinkedHashSet<>();
        for (Message message : messageList) {
            unique.add(message);
        }

        List<Message> result = new ArrayList<>(unique);

        return result;
    }

    public static void removeEach(List<Message> messageList, MessagePriority priority){
        // удалить из коллекции каждое сообщение с заданным приоритетом
        // вывод до удалеия и после удаления

        System.out.println(messageList);
        for (int i = 0; i < messageList.size(); i++) {

            if (messageList.get(i).getPriority() == priority)
                messageList.remove(i);
        }
        System.out.println(messageList);
    }

    public static void removeOther(List<Message> messageList, MessagePriority priority){
        // удалить из коллекции все сообщения, кроме тех, которые имеют заданный приоритет
        // вывод до удалеия и после удаления

        System.out.println(messageList);
        for (int i = 0; i < messageList.size(); i++) {

            if (messageList.get(i).getPriority() != priority)
                messageList.remove(i);
        }
        System.out.println(messageList);
    }


}

class MessageGenerator {
    public static List<Message> generate(int num){
        if (num <= 0) {
            return Collections.emptyList();
        }

        Random random = new Random();
        List<Message> messages = new ArrayList<>(num);

//        values() - вернет массив констант
        int typesCount = MessagePriority.values().length;

        for (int i = 0; i < num; i++){
            messages.add(
                    new Message(
                            random.nextInt(10),
                            MessagePriority.getPriority(random.nextInt(typesCount)))
            );
        }

        return messages;
    }
}

