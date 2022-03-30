package interfaces

import flights.Flight

/**
 * FlightObserver interface. Implements to the flights.
 */
interface FlightObserver {
    fun update(flights: ArrayList<Flight>)
    fun isFlight(): Boolean
}