import tickets.TicketPool;


public class Main {
    public static void main(String args[]) {
        TicketPool t = new TicketPool();
        t.acquireReusable();
        t.releaseTicket();
    }
}