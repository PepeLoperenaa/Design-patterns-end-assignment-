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

    /**
     * Updating notice board. Observer Design pattern
     */
    override fun update(flights: ArrayList<Flight>) {
        /**
         * Comparing the old and new list of flights to see if anything changed.
         * If so it will update the list in this object and reprint the noticeboard
         */
        if (flights != this.flights) {
            this.flights = flights
            printNoticeboard()
        }
    }


    /**
     * Printing the notice board
     */
    private fun printNoticeboard() {
        var i = 0
        print(
            String.format(
                "%11s | %30s | %30s | %8s | %8s | %12s | %30s | %30s \n",
                "Flight name",
                "estimated Landing Time",
                "actual landing time",
                "terminal",
                "gate ",
                "flightnumber",
                "scheduled date",
                "last updated"
            )
        )
        while (flights.size > i) {
            println(flights[i].toString())
            i++
        }
    }
}