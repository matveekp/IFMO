package multithreading.restaurant;

public class Restaurant {

    private TicketWindow ticketWindow;


    public static void main(String[] args) {

        Visitor visitor1 = new Visitor("visitor1");
        Visitor visitor2 = new Visitor("visitor2");
        Visitor visitor3 = new Visitor("visitor3");
        Visitor visitor4 = new Visitor("visitor4");
        Visitor visitor5 = new Visitor("visitor5");
        Visitor visitor6 = new Visitor("visitor6");
        Visitor visitor7 = new Visitor("visitor7");
        Visitor visitor8 = new Visitor("visitor8");
        Visitor visitor9 = new Visitor("visitor9");

        TicketWindow ticketWindow1 = new TicketWindow(1);
        TicketWindow ticketWindow2 = new TicketWindow(2);
        TicketWindow ticketWindow3 = new TicketWindow(3);





    }

}
