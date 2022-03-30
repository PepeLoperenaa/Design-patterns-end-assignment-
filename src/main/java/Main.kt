import airport.AirportApi
import airport.NoticeBoard
import flights.Flight
import tickets.BoardingPass
import tickets.FlexTicketProxy
import tickets.Passenger
import tickets.Ticket
import java.util.*
import java.io.Console;

/**
 * Main class.
 */
object Main {
    @JvmStatic
    fun main(args: Array<String>) {

        val airportApi = AirportApi()
        val flightList: ArrayList<Flight> = airportApi.flights
        val noticeBoard = NoticeBoard(flightList)
        println("Full name of passenger:")
        val (pFName, pLName) = readLine()!!.split(' ')
        println("(we filled in date of birth and gender for brevity)")
        flightList[0].tp.acquireReusable()
        val pepe = Passenger(pFName, pLName, Date(1998, 11, 11), false)
        val pt = FlexTicketProxy()
        val ticket: Ticket = flightList[0].tp.releaseTicket(pepe)
        println("Thank you "+ ticket.passenger!!.firstname+". Your flight number is "+ticket.flight.flightNumber)

        println("Please look out for any updates to your flight number in the noticeboard below:")


     println("Boarding pass for $pFName is created. See details below:")
        val bp = BoardingPass.Builder(ticket)
            .atGate()
            .inSeat()
            .withBoardingTime()
            .isFlying()
            .build()


        pt.ticket = ticket
        pt.ticket!!.flight.gate
        println(pt.getPassenger())
        airportApi.subscribe(flightList[1])
        airportApi.subscribe(noticeBoard)
/*
        println(pt.ticket!!.passenger!!.firstname)*/
    }
}