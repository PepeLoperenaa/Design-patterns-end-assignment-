package tickets;

import flights.Flight;

public class Ticket {
    private Passenger passenger;
    private Flight flight;
    private int ticketNum;
    private TicketType ticketType;
    private TicketPool ticket;


    public Ticket(Passenger p, int ticketNum) {
        this.passenger = p;
        this.ticketNum = ticketNum;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight){
        this.flight = flight;
    }

    public int getTicketNum() {
        return ticketNum;
    }

    public void setTicketNum(int ticketNum) {
        this.ticketNum = ticketNum;
    }

    public TicketPool getTicket() {
        return ticket;
    }

}

