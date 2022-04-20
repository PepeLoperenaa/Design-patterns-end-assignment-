package tickets

import flights.Flight

/**
 * FlexTicketProxy class. Contains the methods and functions from ticket and has its own implementation.
 */
class FlexTicketProxy {
    lateinit var ticket: Ticket
    private lateinit var ticketNum: String
    private val ticketType: TicketType = TicketType.FLEXTICKET

    constructor(p: Passenger) {
        ticket = Ticket(p,"0")
    }
    constructor(ticket: Ticket){
        this.ticket = ticket
    }
    /**
     * it gets the ticket number
     */
    fun getTicketNum(): String {
        return ticket.ticketNum
    }

    fun setTicketNum(ticketNum : String){
        this.ticket.ticketNum = ticketNum
    }

    fun setTicketFlight(flight: Flight){
        this.ticket.flight = flight
    }

    fun setTicketType(ticketType: TicketType){
        this.ticket.ticketType = ticketType
    }
    

    /**
     * Getting the flight from the ticket.
     */
    fun getFlight(): Flight? {
        return ticket.flight

    }

    /**
     * Getting the passenger information from the ticket.
     */
    fun getPassenger(): Passenger? {
        return ticket.passenger

    }

}