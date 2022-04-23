package interfaces

import flights.Flight

/**
 * Ticket interface. Implements to the TicketProxy
 */
interface TicketInterface {
    /**
     * allow flight to be changed for ticket
     * @param flight
     */
    fun changeFlight(flight: Flight)
}