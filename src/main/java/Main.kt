import kotlin.jvm.JvmStatic
import tickets.BoardingPass
import airport.AirportApi
import airport.NoticeBoard
import flights.Flight
import tickets.Passenger
import tickets.Ticket
import java.util.*

object Main {
    @JvmStatic
    fun main(args: Array<String>) {

        val airportApi = AirportApi()
        val flightList : List<Flight> = airportApi.flights
        val p = Passenger("Ramon", "Brakels", Date(1977,11,17), false)
        flightList[0].tp.acquireReusable()
        val ticket : Ticket = flightList[0].tp.releaseTicket(p)
        //return "$flightName $estimatedLandingTime $actualLandingTime $terminal $flightNumber $scheduleDateTime $lastUpdated"
        println("Flight name | estimated Landing Time | actual landing time | terminal | gate | flightnumber | scheduled date | last updated |")
        NoticeBoard(airportApi.flights)
        val bp = BoardingPass.Builder(ticket)
            .atGate()
            .build()
    }
}