package tickets

import flights.Flight

/**
 * FlexTicketProxy class. Contains the methods and functions from ticket and has its own implementation.
 */
class FlexTicketProxy {
    var ticket: Ticket? = null
    private lateinit var ticketNum: String
    private val ticketType: TicketType = TicketType.FLEXTICKET

    /**
     * it gets the ticket number
     */
    fun getTicketNum(): String {
        return if (ticket != null) {
            ticket!!.ticketNum
        } else {
            "Ticket not set"
        }
    }

    /**
     * Getting the flight from the ticket.
     */
    fun getFlight(): Flight? {
        return if (ticket != null) {
            ticket?.flight
        } else {
            println("ticket not set")
            null
        }
    }

    /**
     * Getting the passenger information from the ticket.
     */
    fun getPassenger(): Passenger? {
        return if (ticket != null) {
            ticket?.passenger
        } else {
            println("ticket not set")
            null
        }
    }

}