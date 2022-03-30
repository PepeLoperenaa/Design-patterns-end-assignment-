package tickets

import java.util.*

/**
 * Passenger class. Contains information from the passenger.
 */
class Passenger(var firstname: String, var lastName: String, var doB: Date, var gender: Boolean){
    override fun toString(): String {
        return "$firstname $lastName"
    }
}