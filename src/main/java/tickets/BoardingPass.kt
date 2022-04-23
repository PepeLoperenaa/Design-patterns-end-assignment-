package tickets

import flights.Flight
import kotlin.random.Random

/**
 * Boarding pass Class. Includes the builder Design patterns as an internal class.
 */
class BoardingPass private constructor(builder: Builder) {
    var ticket: Ticket?
    var boardingTime: String?
    var gate: String?
    private var seat: String?
    var passenger: Passenger?

    init {
        boardingTime = builder.boardingTime
        gate = builder.gate
        seat = builder.seat
        ticket = builder.ticket
        passenger = builder.passenger
    }

    /**
     * Internal class Builder
     */
    class Builder {
        var boardingTime: String? = null
        var gate: String? = null
        var seat: String? = null
        lateinit var passenger: Passenger
        var ticket: Ticket? = null


        /**
         * link passenger to boarding pass
         */
        fun addPassenger(p: Passenger): Builder {
            this.passenger = p
            return this
        }


        fun addTicket(flight: Flight): Builder {
            flight.tp.acquireReusable()
            this.ticket = flight.tp.releaseTicket(passenger)
            return this
        }

        fun isFlying(): Builder {
            return this
        }

        /**
         * Checks API for boarding time.
         */
        fun withBoardingTime(): Builder {
            this.boardingTime = ticket?.flight?.expectedTimeGateOpen
            if (boardingTime == null) {
                println("Boarding Time not known yet")
            } else {
                println("Boarding time: $boardingTime")
            }
            return this
        }

        /**
         * Checks API for gate.
         */
        fun atGate(): Builder {
            this.gate = ticket?.flight?.gate
            if (gate == null) {
                println("Gate number not available yet")
            } else {
                println("Gate number: $gate")
            }
            return this
        }

        /**
         * gets a random seat on the flight
         * @exception e
         */
        fun inSeat(): Builder {
            return try {
                this.seat = ticket?.flight?.tp?.let { Random.nextInt(0, it.size).toString() }
                println("Seat number: $seat")
                this
            } catch (e: Exception) {
                e.printStackTrace()
                this
            }
        }

        /**
         * Actually builds the boarding pass and is always returned fully initialised
         * @return BoardingPass
         * @exception NullPointerException  check ticket is !null
         */
        fun build(): BoardingPass {
            if (this.ticket == null) {
                throw NullPointerException("There is no ticket assigned to this boardingpass")
            } else {
                return BoardingPass(this)
            }
        }
    }
}