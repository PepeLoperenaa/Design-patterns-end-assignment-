import airport.AirportApi;
import airport.NoticeBoard;
import flights.Flight;
import tickets.BoardingPass;
import tickets.FlexTicketProxy;
import tickets.TicketPool;
import tickets.FlexImpl;


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

        AirportApi AirportApi = new AirportApi();
        AirportApi.getFlight();
        //return "$flightName $estimatedLandingTime $actualLandingTime $terminal $flightNumber $scheduleDateTime $lastUpdated"
        System.out.println("Flightname | estimated Landing Time | actual landing time | terminal | gate | flightnumber | scheduled date | last updated |");
        NoticeBoard noticeBoard = new NoticeBoard(AirportApi.getFlight());
    }
}