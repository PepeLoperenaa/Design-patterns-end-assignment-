package tickets


import flights.Flight
import java.lang.IllegalArgumentException
import java.util.ArrayList

/**
 * Object pool base creates empty tickets.
 */
class TicketPool(size: Int, flight: Flight) {
    private val pool: ArrayList<Ticket> = ArrayList()
    private val flight: Flight
    val size: Int

    init {
        this.flight = flight
        this.size = size
    }

    fun acquireReusable() { //create ticket instances
        for (j in 0 until size) {
            val t = Ticket(flight.flightNumber.toString() + j)
            t.flight = flight //change with setter when tickets are called.
            pool.add(t) //adding first ticket
        } //this method works and stops creating blank tickets when the default size is reached.
    }

    fun releaseTicket(p : Passenger): Ticket { //getting the tickets from the Array.
        //make sure that the list is not 0
        require(pool.isNotEmpty())
        val lastIndex = pool.size - 1
        val t = pool[lastIndex]
        pool.removeAt(lastIndex)
        t.passenger = p
        return t
    }
}