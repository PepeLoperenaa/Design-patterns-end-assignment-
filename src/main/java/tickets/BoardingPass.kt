package tickets

import kotlin.random.Random

class BoardingPass private constructor(builder: Builder) {
    var boardingTime: String?
    var gate: String?
    private var seat: String?
    private var ticket: Ticket
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
            if(gate == null){
                println("Gate not set yet.")
            }
            return this
        }


        fun inSeat(): Builder {
            return try {
                this.seat = Random.nextInt(0, ticket.flight.tp.size).toString()
                this
            } catch (e : Exception){
                e.printStackTrace()
                this
            }

        }

        fun build(): BoardingPass {
            return BoardingPass(this)
        }
    }
}