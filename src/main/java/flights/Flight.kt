package flights

class Flight {
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

    override fun toString(): String {
        return "$flightName | $estimatedLandingTime | $actualLandingTime | $terminal | $gate | $flightNumber | $scheduleDateTime | $lastUpdated"
    }
}