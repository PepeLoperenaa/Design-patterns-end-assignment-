package tickets

import flights.Flight

/**
 * FlexTicketProxy class. Contains the methods and functions from ticket and has its own implementation.
 */
class FlexTicketProxy(passenger: Passenger, flight: Flight) : FlexTicket() {
    var ticket: Ticket? = null
    private lateinit var ticketNum: String
    private val p = passenger
    private var flight = flight
    private val ticketType: TicketType = TicketType.FLEXTICKET

    /**
     * it gets the ticket number
     */
    fun getTicketNum(): String {
        checkTicket()
        return ticket!!.ticketNum
    }

    fun setTicketNum(ticketNum: String) {
        checkTicket()
        this.ticket!!.ticketNum = ticketNum
    }

    fun setTicketFlight(flight: Flight) {
        checkTicket()
        this.ticket!!.flight = flight
    }

    fun setTicketType(ticketType: TicketType) {
        checkTicket()
        this.ticket!!.ticketType = ticketType
    }


    /**
     * Getting the flight from the ticket.
     */
    fun getFlight(): Flight? {
        checkTicket()
        return ticket!!.flight
    }

    /**
     * Getting the passenger information from the ticket.
     */
    fun getPassenger(): Passenger? {
        checkTicket()
        return ticket!!.passenger
    }

    override fun changeFlight(flight: Flight) {
        this.flight = flight
        this.flight.tp.acquireReusable()
        this.ticket = this.flight.tp.releaseTicket(p)
    }

    /**
     * Method to check if the ticket is null.
     */
    private fun checkTicket() {
        if (this.ticket == null) {
            changeFlight(flight)
        }
    }
}