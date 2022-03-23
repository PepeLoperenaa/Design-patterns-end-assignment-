package tickets;

import flights.PlaneType;

/**
Object pool base is probably done, just need to add some other methods such as plane type so that we can get the max tickets.
 */
public class TicketPool {
    private Ticket[] pool;
    private PlaneType pt;
    public static final int DEFAULT_SIZE = 32; //varies depending in the plane type.

    public TicketPool(int size, int max) {
        pool = new Ticket[size];
    }
    public void acquireReusable(){ //get ticket instances

    }

    public void releaseTicket(){ //releasing ticket when asked in ticket.

    }
}
