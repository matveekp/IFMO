package lesson4.Task1;

public class Test {

    public static void main(String[] args) {


        MyLinkedList myLinkedList = new MyLinkedList();

        myLinkedList.add(4);
        myLinkedList.add(2);
        myLinkedList.add(9);
        myLinkedList.add(11);


        System.out.println(myLinkedList);

        System.out.println(myLinkedList.get(3));

        myLinkedList.remove(1);
        System.out.println(myLinkedList);

    }


}
