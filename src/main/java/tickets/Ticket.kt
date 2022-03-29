package tickets

import tickets.Passenger
import flights.Flight
import tickets.TicketType
import tickets.TicketPool

class Ticket {
    var passenger: Passenger? = null
    var flight: Flight? = null
    var ticketNum: String
    private val ticketType: TicketType? = null
    val ticket: TicketPool? = null

    constructor(ticketNum: String) {
        this.ticketNum = ticketNum
    }

    constructor(p: Passenger?, ticketNum: String) {
        passenger = p
        this.ticketNum = ticketNum
    }
}