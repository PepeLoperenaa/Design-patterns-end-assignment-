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

    //@param ticketNum, flight   when flight is known
    constructor(ticketNum: String, flight: Flight) {
        this.ticketNum = ticketNum
        this.flight = flight
    }

    //@param p, ticketNum   when flight is not known
    constructor(p: Passenger?, ticketNum: String) {
        passenger = p
        this.ticketNum = ticketNum
    }
}