package tickets

import flights.Flight
import tickets.FlexImpl

class FlexTicketProxy(ticketNumber: String, flight: Flight) : Ticket(ticketNumber, flight) {

    fun changeFlight(flight: Flight){
        this.flight = flight
    }

}