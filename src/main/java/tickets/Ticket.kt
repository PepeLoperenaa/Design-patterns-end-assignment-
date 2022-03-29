package tickets


import flights.Flight


open class Ticket {
    var passenger: Passenger? = null
    lateinit var flight: Flight
    var ticketNum: String
    private val ticketType: TicketType? = null

    constructor(ticketNum: String, flight:Flight) {
        this.ticketNum = ticketNum
        this.flight = flight
    }

    constructor(p: Passenger?, ticketNum: String) {
        passenger = p
        this.ticketNum = ticketNum
    }
}