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




    }
}





class MessageTask {
    public static void countEachPriority(List<Message> messageList) {
        // Подсчитать количество сообщений для каждого приоритела
        // Ответ в консоль
        String name1 = String.valueOf(MessagePriority.getPriority(0));
        String name2 = String.valueOf(MessagePriority.getPriority(1));
        String name3 = String.valueOf(MessagePriority.getPriority(2));
        String name4 = String.valueOf(MessagePriority.getPriority(3));

        Map<String, String> result = new HashMap<>();


        for (Message message : messageList) {

            //может в hashmap запихнуть???
            // тип  и кол-во

//            String type
//
//            result.put()

        }






    }

    public static void countEachCode(List<Message> messageList) {
        // Подсчитать количество сообщений для каждого кода сообщения
        // Ответ в консоль
    }

    private static void uniqueMessageCount(List<Message> messageList) {
        // Подсчитать количество уникальных сообщений
        // Ответ в консоль
    }

    public static List<Message> uniqueMessagesInOriginalOrder(List<Message> messageList){
        // вернуть только неповторяющиеся сообщения и в том порядке, в котором они
        // встретились в первоначальном списке
        // Например, было
//        [{URGENT, 4}, {HIGH, 9}, {LOW, 3}, {HIGH, 9}]
        // на выходе:
        // [{URGENT, 4}, {HIGH, 9}, {LOW, 3}]
        return messageList;
    }

    public static void removeEach(List<Message> messageList, MessagePriority priority){
        // удалить из коллекции каждое сообщение с заданным приоритетом
        // вывод до удалеия и после удаления
    }

    public static void removeOther(List<Message> messageList, MessagePriority priority){
        // удалить из коллекции все сообщения, кроме тех, которые имеют заданный приоритет
        // вывод до удалеия и после удаления
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

