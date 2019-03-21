package lesson6.classWork.nested;


public class Main {

    public static void main(String[] args) {

        Food apple = new Food.Builder(4)
                        .calories(45)
                            .fat(6)
                                .build();


        System.out.println(apple);



        LinkedList linkedList = new LinkedList();
        linkedList.add(4);
        linkedList.add(3);
        linkedList.add(6);

        for (Object o : linkedList) {
            System.out.println(o);
        }


        }


    }

