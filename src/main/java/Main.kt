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
        val pName = readLine()!!.split(' ')
        val fName = pName[0]
        var lName = if(pName.size == 3) {
            "$pName[1] $pName[2]"
        }
        else if(pName.size > 3) {
            println("not possible")
            "$pName[1] $pName[2]"
        }else
        {
            pName[1]
        }
        println("(we filled in date of birth and gender for brevity)")
        flightList[0].tp.acquireReusable()
        val pepe = Passenger(fName, lName, Date(1998, 11, 11), false)
        val pt = FlexTicketProxy(pepe)
        val ticket: Ticket = flightList[0].tp.releaseTicket(pepe)
        println("Thank you "+ ticket.passenger!!.firstname+". Your flight number is "+ticket.flight.flightNumber)

        println("Please look out for any updates to your flight number in the noticeboard above")


     println("Boarding pass for $fName is created. See details above:")
        val bp = BoardingPass.Builder()
            .atGate()
            .addTicket(ticket)
            .addPassenger(pepe)
            .inSeat()
            .withBoardingTime()
            .isFlying()
            .build()


        pt.ticket = ticket
        pt.ticket.flight.gate
        airportApi.subscribe(flightList[1])
        airportApi.subscribe(noticeBoard)
    }
}