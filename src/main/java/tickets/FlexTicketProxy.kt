package tickets

import flights.Flight

/*
Needs to have dummy data and all the functions etc from Ticket. So it's own implementation.
 */
class FlexTicketProxy {
    var ticket: Ticket? = null
    private lateinit var ticketNum: String
    private val ticketType: TicketType? = null

    //fun setPassenger(passenger: Passenger){
    //    ticket?.passenger = passenger
    //}

    fun getTicketNum(): String{
        return if (ticket != null) {
            ticket!!.ticketNum
        } else{
            "Ticket not set"
        }
    }

    fun getFlight() : Flight? {
        return if(ticket != null){
            ticket?.flight
        } else{
            println("ticket not set")
            null
        }
    }

    fun getPassenger(): Passenger?{
        return if(ticket != null){
            ticket?.passenger
        } else{
            println("ticket not set")
            null
        }
    }

}