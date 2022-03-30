package airport

import flights.Flight
import interfaces.FlightObserver

/**
 * Notice board class. Prints out all the flights from the Schiphol API.
 */
class NoticeBoard(flights: ArrayList<Flight>) : FlightObserver {
    var flights: ArrayList<Flight> = ArrayList()

    init {
        this.flights = flights
        printNoticeboard()
    }

    override fun update(flights: ArrayList<Flight>) {
        this.flights = flights
        printNoticeboard()
    }

    override fun isFlight(): Boolean {
        return false
    }

    /**
     * Printing the notice board
     */
    private fun printNoticeboard() {
        var i = 0
        print(String.format("%11s | %30s | %30s | %8s | %8s | %12s | %30s | %30s \n","Flight name","estimated Landing Time" , "actual landing time" , "terminal" , "gate ", "flightnumber" , "scheduled date","last updated"))
        while (flights.size > i) {
            println(flights[i].toString())
            i++
        }
    }
}