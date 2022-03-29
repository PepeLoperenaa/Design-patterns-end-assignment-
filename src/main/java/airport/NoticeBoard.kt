package airport

import flights.Flight
import interfaces.FlightObserver
import kotlin.collections.ArrayList

class NoticeBoard(flights: ArrayList<Flight>) : FlightObserver {
    var flights : ArrayList<Flight> = ArrayList()
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

    private fun printNoticeboard(){
        var i = 0
        while (flights.size > i) {
            println(flights[i])
            i++
        }
    }
}