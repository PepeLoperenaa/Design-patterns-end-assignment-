import airport.AirportApi
import airport.NoticeBoard
import flights.Flight
import tickets.BoardingPass
import tickets.FlexTicketProxy
import tickets.Passenger
import tickets.Ticket
import java.util.*

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
        val lName = if (pName.size == 3) {
            "$pName[1] $pName[2]"
        } else if (pName.size > 3) {
            println("not possible")
            "$pName[1] $pName[2]"
        } else {
            try {
                pName[1]
            } catch (e: Exception) {
                "" //in real life this should not exist but for application purposes, it stays.
            }
        }
        println("(we filled in date of birth and gender for brevity)")
        flightList[0].tp.acquireReusable()
        val pepe = Passenger(fName, lName, Date(1998, 11, 11), false)
        println("Flight name please:")
        val flightName = readLine()!!
        lateinit var pickedFlight: Flight
        for (flight in flightList) {
            pickedFlight = if (flight.flightName == flightName) {
                flight
            } else {
                flightList[1]
            }
        }
        pickedFlight.tp.acquireReusable()
        val ticket: Ticket = pickedFlight.tp.releaseTicket(pepe)
        val pt = FlexTicketProxy(pepe, pickedFlight)
        println("Thank you " + ticket.passenger!!.firstname + ". Your flight number is " + ticket.flight.flightNumber)

        println("Please look out for any updates to your flight number in the noticeboard above")


        println("Boarding pass for $fName is created. See details above:")
        pt.ticket = ticket
        pt.ticket!!.flight.gate
        pt.changeFlight(flightList[10])
        pt.ticket!!.ticketNum
        airportApi.subscribe(flightList[1])
        airportApi.subscribe(noticeBoard)
        println("Would you like to create a boarding pass? Yes or no")
        val createPass = readLine()!!
        if (createPass.uppercase() == "YES" || createPass.uppercase() == "Y") {
            val bp = BoardingPass.Builder()
                //need to add passenger before setting ticket. Passenger is lateint
                .addPassenger(pepe)
                .addTicket(pickedFlight)
                .atGate()
                .inSeat()
                .withBoardingTime()
                .isFlying()
                .build()
            println("Your boarding pass is created.")
        }
    }
}