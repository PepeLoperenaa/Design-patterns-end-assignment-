package interfaces

import flights.Flight

interface FlightObserver {
    fun update(flights: ArrayList<Flight>)
    fun isFlight() : Boolean
}