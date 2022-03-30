package tickets

import kotlin.random.Random

/**
 * Boarding pass Class. Includes the builder Design patterns as an internal class.
 */
class BoardingPass private constructor(builder: Builder) {
    private var ticket: Ticket
    var boardingTime: String?
    var gate: String?
    private var seat: String?
    var passengerName: String?

    init {
        boardingTime = builder.boardingTime
        gate = builder.gate
        seat = builder.seat
        ticket = builder.ticket
        passengerName = builder.passengerName
    }

    class Builder(var ticket: Ticket) {
        var boardingTime: String? = null
        var gate: String? = null
        var seat: String? = null
        var passengerName: String? = null

        fun isFlying(): Builder {
            this.passengerName = ticket.passenger?.firstname.plus(ticket.passenger?.lastName)
            return this
        }

        fun withBoardingTime(): Builder {
            this.boardingTime = ticket.flight.expectedTimeGateOpen
            return this
        }

        fun atGate(): Builder {
            this.gate = ticket.flight.gate
            if (gate == null) {
                println("Gate not set yet.")
            }
            return this
        }

        fun inSeat(): Builder {
            return try {
                this.seat = Random.nextInt(0, ticket.flight.tp.size).toString()
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