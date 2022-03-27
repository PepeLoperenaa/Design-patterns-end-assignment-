package tickets;

import java.sql.Time;

public class BoardingPass {

    public Time boardingTime;
    private String gate;
    private String seat;
    private Ticket ticket;
    public Passenger passenger;

    public BoardingPass(String gate, String seat, Time boardingTime) {
        this.gate = gate;
        this.seat = seat;
        this.boardingTime = boardingTime;

    }

    public String getGate() {
        return gate;
    }

    public String getSeat() {
        return seat;
    }

    public int getTicketNum() {
        return ticket.getTicketNum();
    }


}


