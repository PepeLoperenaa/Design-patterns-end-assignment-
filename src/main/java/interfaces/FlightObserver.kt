package interfaces

import flights.Flight

/**
 * FlightObserver interface. Implemented in Flight and Noticeboard.
 */
interface FlightObserver {
    fun update(flights: ArrayList<Flight>)
    fun isFlight(): Boolean
}