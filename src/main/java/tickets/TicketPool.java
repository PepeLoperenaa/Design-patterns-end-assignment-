package tickets;

import flights.PlaneType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Arrays;

/**
 * Object pool base creates empty tickets.
 */
public class TicketPool {
    private Ticket[] pool;
    private PlaneType pt;
    public int DEFAULT_SIZE = 5; //varies depending on the plane type.

    public TicketPool() {
        pool = new Ticket[DEFAULT_SIZE];
    }

    public void acquireReusable() { //create ticket instances
        int i = 0; //counter to add objects in array.
        for (Ticket ticket : pool) {
            Ticket t = new Ticket("name", 0); //change with setter when tickets are called.
            if (pool.length != DEFAULT_SIZE) {
                pool[i] = t; //adding first ticket in position 0
                i++; //after every iteration add one to the counter until it reaches max ticket size.
            }
        } //this method works and stops creating blank tickets when the default size is reached.
    }

    public Ticket releaseTicket() { //getting the tickets from the Array.
        List<Ticket> list = new ArrayList<Ticket>(Arrays.asList(pool)); //Array to List
        if (list.isEmpty()) { //make sure that the list is not 0
            throw new IllegalArgumentException();
        }
        int index = new Random().nextInt(list.size()); //getting a random ticket from the pool.
        int lastIndex = list.size() - 1;
        Ticket t = list.get(index);
        list.set(index, list.get(lastIndex));
        list.remove(lastIndex);

        return t;
        //do we need to move the number of tickets down everytime we do this?
        // This gives a ticket to the user and -1 the index of the array.
    }

    public void managePoolSize(int DEFAULT_SIZE) {
        this.DEFAULT_SIZE = DEFAULT_SIZE;
    }
}
