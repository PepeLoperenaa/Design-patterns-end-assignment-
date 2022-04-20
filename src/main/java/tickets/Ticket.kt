package tickets


import flights.Flight

/**
 * Ticket class. Contains the information about the ticket.
 */
open class Ticket {
    var passenger: Passenger? = null
    lateinit var flight: Flight
    var ticketNum: String
    var ticketType: TicketType = TicketType.TICKET

    constructor(ticketNum: String, flight: Flight) {
        this.ticketNum = ticketNum
        this.flight = flight
    }

    constructor(p: Passenger?, ticketNum: String) {
        passenger = p
        this.ticketNum = ticketNum
    }
}