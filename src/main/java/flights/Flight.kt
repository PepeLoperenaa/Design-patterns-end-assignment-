package flights

import interfaces.FlightObserver
import tickets.TicketPool

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

    override fun update(flights: ArrayList<Flight>) {
        for(flight in flights){
            if(flight.flightNumber == this.flightNumber){
                if(this.estimatedLandingTime != flight.estimatedLandingTime){
                    this.estimatedLandingTime = flight.estimatedLandingTime
                } else if(this.lastUpdated != flight.lastUpdated){
                    this.lastUpdated = flight.lastUpdated
                }else if(this.pier != flight.pier){
                    this.pier = flight.pier
                }else if(this.gate != flight.gate){
                    this.gate = flight.gate
                }else if(this.terminal != flight.terminal){
                    this.terminal = flight.terminal
                }else if(this.actualLandingTime != flight.actualLandingTime){
                    this.actualLandingTime = flight.actualLandingTime
                }
            }
        }
    }

    override fun toString(): String {
        return "$flightName | $estimatedLandingTime | $actualLandingTime | $terminal | $gate | $flightNumber | $scheduleDateTime | $lastUpdated"
    }

    override fun isFlight(): Boolean {
        return true
    }

}