import tickets.BoardingPass;
import tickets.TicketPool;


public class Main {
    public static void main(String args[]) {
        TicketPool t = new TicketPool();
        t.acquireReusable();
        t.releaseTicket();


        BoardingPass bp = new BoardingPass.Builder(1234)
                .atGate("D27")
                .inSeat("A5")
                .isFlying("Carla Redmond")
                .withBoardingTime("18:04")
                .build();
        System.out.println(bp.gate);

    }
}