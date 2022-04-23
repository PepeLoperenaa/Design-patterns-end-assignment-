package flights

import interfaces.FlightObserver
import tickets.TicketPool

/**
 * Flight observer class. Contains all the information of the API.
 */
class Flight : FlightObserver {
    var id: String? = null
    var flightName: String? = null
    var pier: String? = null
    var aircraftType: PlaneType? = null
    var scheduleDateTime: String? = null
    var expectedTimeGateClosing: String? = null
    var scheduleData: String? = null
    var flightDirection: String? = null
    var airlineCode: Int? = null
    var mainFlight: String? = null
    var codeshares: String? = null
    var estimatedLandingTime: String? = null
    var actualLandingTime: String? = null
    var terminal: Long? = null
    var flightNumber: Long? = null
    var baggageClaim: Int? = null
    var expectedTimeOnBelt: String? = null
    var publicFlightState: String? = null
    var expectedTimeGateOpen: String? = null
    var lastUpdated: String? = null
    var gate: String? = null
    var destination: String? = null
    var visa: Boolean? = null
    var eu: String? = null
    lateinit var tp: TicketPool


    /**
     * Set the ticket pool depending on the aircraft type.
     */
    fun setTicketPool() {
        tp = when (aircraftType?.iataMain) {
            "737" -> TicketPool(188, this)
            "747", "74F" -> TicketPool(366, this)
            "787" -> TicketPool(330, this)
            "ABF" -> TicketPool(440, this)
            else -> {
                TicketPool(250, this)
            }
        }
    }

    /**
     * Updating the API information.
     */
    override fun update(flights: ArrayList<Flight>) {
        for (flight in flights) {
            if (flight.flightNumber == this.flightNumber) {
                if (this.estimatedLandingTime != flight.estimatedLandingTime) {
                    this.estimatedLandingTime = flight.estimatedLandingTime
                }
                if (this.lastUpdated != flight.lastUpdated) {
                    this.lastUpdated = flight.lastUpdated
                }
                if (this.pier != flight.pier) {
                    this.pier = flight.pier
                }
                if (this.gate != flight.gate) {
                    this.gate = flight.gate
                }
                if (this.terminal != flight.terminal) {
                    this.terminal = flight.terminal
                }
                if (this.actualLandingTime != flight.actualLandingTime) {
                    this.actualLandingTime = flight.actualLandingTime
                }
            }
        }
    }


    /**
     * Formatting of the table printed out.
     */
    override fun toString(): String {
        return String.format(
            "%11s | %30s | %30s | %8s | %8s | %12s | %30s | %30s",
            flightName,
            estimatedLandingTime,
            actualLandingTime,
            terminal,
            gate,
            flightNumber,
            scheduleDateTime,
            lastUpdated
        )
    }

    override fun isFlight(): Boolean {
        return true
    }

    /**
     * Overriding the equals function to compare the Flight objects based on the values that are assigned to them.
     * This is used in the noticeboard to compare the 2 lists.
     */
    override fun equals(other: Any?): Boolean {
        if (this === other)
            return true

        /**
         * checking for two condition:
         * 1) object is pointing to null
         * 2) if the objects belong to the same class or not
         */
        if (other == null || other::class != this::class)
            return false
        /**
         * casting the other object to the Flight class, the intended class.
         */
        val obj: Flight = other as Flight

        /**
         * Checking if the 2 objects are the same by comparing the output strings
         */
        return this.toString() == obj.toString()
    }

}