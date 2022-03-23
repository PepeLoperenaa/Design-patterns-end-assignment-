package tickets;

import flights.Flight;

public class Ticket {
    private String passengerName;
    private Flight flight;
    private int ticketNum;
    private TicketType ticketType;
    private TicketPool ticket;

    public Ticket(String passengerName, int ticketNum) {
        this.passengerName = passengerName;
        this.ticketNum = ticketNum;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public Flight getFlight() {
        return flight;
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

