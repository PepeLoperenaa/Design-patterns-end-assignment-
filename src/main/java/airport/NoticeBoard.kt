package airport

import flights.Flight
import kotlin.collections.ArrayList

class NoticeBoard(flights: ArrayList<Flight>) {
    init {
        var i = 0
        while (flights.size > i) {
            println(flights[i])
            i++
        }
    }
}