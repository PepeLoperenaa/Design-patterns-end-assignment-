import kotlin.jvm.JvmStatic
import tickets.BoardingPass
import airport.AirportApi
import airport.NoticeBoard
import flights.Flight
import tickets.FlexTicketProxy
import tickets.Passenger
import tickets.Ticket
import java.util.*

object Main {
    @JvmStatic
    fun main(args: Array<String>) {

        val airportApi = AirportApi()
        val flightList : List<Flight> = airportApi.flights
        airportApi.subscribe(flightList[1])
        println("Full name of passenger name:")
        val (pFName,pLName) = readLine()!!.split(' ')
        println("$pFName $pLName")
        flightList[0].tp.acquireReusable()
        val pepe = Passenger(pFName,pLName, Date(1998,11,11),false)
        val pt = FlexTicketProxy()
        val ticket : Ticket = flightList[0].tp.releaseTicket(pepe)

        println("Flight name | estimated Landing Time | actual landing time | terminal | gate | flightnumber | scheduled date | last updated |")
        NoticeBoard(airportApi.flights)
        val bp = BoardingPass.Builder(ticket)
            .atGate()
            .build()


        pt.ticket = ticket
        pt.ticket!!.flight.gate
        println(pt.getPassenger())

        println(pt.ticket!!.passenger!!.firstname)
    }
}