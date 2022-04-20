package tickets

import kotlin.random.Random

/**
 * Boarding pass Class. Includes the builder Design patterns as an internal class.
 */
class BoardingPass private constructor(builder: Builder) {
    var ticket: Ticket?
    var boardingTime: String?
    var gate: String?
    private var seat: String?
    var passenger : Passenger?

    init {
        boardingTime = builder.boardingTime
        gate = builder.gate
        seat = builder.seat
        ticket = builder.ticket
        passenger = builder.passenger
    }

    class Builder {
        var boardingTime: String? = null
        var gate: String? = null
        var seat: String? = null
        var passenger: Passenger? = null
        var ticket: Ticket? = null

        fun addTicket(t: Ticket): Builder{
            this.ticket = t
            return this
        }

        fun addPassenger(p: Passenger): Builder{
            this.passenger = p
            return this
        }

        fun isFlying(): Builder {
            //println(passenger?.firstname)
            return this
        }

        fun withBoardingTime(): Builder {
            this.boardingTime = ticket?.flight?.expectedTimeGateOpen
            if (boardingTime == null) {
                println("Boarding Time not known yet")
            } else {
                println("Boarding time: $boardingTime")
            }
            return this
        }

        fun atGate(): Builder {
            this.gate = ticket?.flight?.gate
            if (gate == null) {
                println("Gate number not available yet")
            } else {
                println("Gate number: $gate")
            }
            return this
        }

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
         * actually builds the boarding pass and is always returned fully initialised
         */
        fun build(): BoardingPass {
            return BoardingPass(this)
        }
    }
}