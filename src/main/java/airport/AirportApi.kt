package airport


import flights.Flight
import flights.PlaneType
import interfaces.FlightObserver
import org.apache.http.HttpStatus
import org.apache.http.ParseException
import org.apache.http.client.HttpClient
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.HttpClients
import org.apache.http.util.EntityUtils
import org.json.simple.JSONArray
import org.json.simple.JSONObject
import org.json.simple.parser.JSONParser
import java.io.IOException

/**
 * AirportApi class, connects and retrieves from Schiphol API
 */
class AirportApi {
    private var observers: ArrayList<FlightObserver> = ArrayList()
    private lateinit var flightList: ArrayList<Flight>
    private val t: Thread


    init {
        /**
         * Creating a thread that keeps running while the application is running to observe the subscribed items.
         */
        t = Thread {
            while (true) {
                for (observer in observers) {
                    observer.update(flights)
                }
                Thread.sleep(120_000)
            }
        }
    }

    /**
     * API information
     */
    val flights: ArrayList<Flight>
        get() {
            try {
                // API call to the Schiphol API
                val APP_ID = "975bc6d0"
                val APP_KEY = "a802c0b2c90faffa941925455e73ec9e"
                val httpClient: HttpClient = HttpClients.createDefault()
                val request = HttpGet("https://api.schiphol.nl/public-flights/flights?page=150")
                request.addHeader("ResourceVersion", "v4")
                request.addHeader("app_id", APP_ID)
                request.addHeader("app_key", APP_KEY)
                request.addHeader("accept", "application/json")
                val response = httpClient.execute(request)
                if (response.statusLine.statusCode == HttpStatus.SC_OK) {
                    val responseBody = EntityUtils.toString(response.entity, "UTF-8")
                    val parser = JSONParser()
                    val json = parser.parse(responseBody) as JSONObject
                    val flights: JSONArray = json["flights"] as JSONArray
                    flightList = arrayListOf()//create arraylist of flights
                    for (element in flights) {
                        try {
                            // general flight information
                            val jsonObject: JSONObject = element as JSONObject
                            val flight = Flight()
                            flight.flightName = jsonObject["flightName"] as String?
                            flight.terminal = jsonObject["terminal"] as Long?
                            flight.flightNumber = jsonObject["flightNumber"] as Long?
                            flight.lastUpdated = jsonObject["lastUpdatedAt"] as String?
                            flight.actualLandingTime = jsonObject["actualLandingTime"] as String?
                            flight.estimatedLandingTime = jsonObject["estimatedLandingTime"] as String?
                            flight.pier = jsonObject["pier"] as String?
                            flight.scheduleDateTime = jsonObject["scheduleDateTime"] as String?
                            flight.mainFlight = jsonObject["mainFlight"] as String?
                            flight.gate = jsonObject["gate"] as String?

                            // Getting the information about the planetype from the planetype jsonobject
                            val planeType = PlaneType()
                            val planeInfo: JSONObject = jsonObject["aircraftType"] as JSONObject
                            planeType.iataMain = planeInfo["iataMain"] as String?
                            planeType.iataSub = planeInfo["iataSub"] as String?
                            flight.aircraftType = planeType

                            // Getting the destination info
                            val route: JSONObject = jsonObject["route"] as JSONObject
                            flight.visa = route["gate"] as Boolean?
                            flight.destination = route["destinations"].toString()
                            flight.eu = route["eu"] as String?

                            // Creating the tickets based on the plane type
                            flight.setTicketPool()

                            flightList.add(flight)
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }
                    }
                } else {
                    println(
                        """
                        Oops something went wrong
                        Http response code: ${response.statusLine.statusCode}
                        Http response body: ${EntityUtils.toString(response.entity)}
                        """.trimIndent()
                    )
                }
            } catch (e: ArrayIndexOutOfBoundsException) {
                println("Oops something went wrong\nPlease insert your APP_ID and APP_KEY as arguments")
            } catch (e: IOException) {
                e.printStackTrace()
            } catch (e: ParseException) {
                e.printStackTrace()
            } catch (e: org.json.simple.parser.ParseException) {
                e.printStackTrace()
            }
            return flightList
        }


    /**
     * subscribe method, adds observer to the observers list
     * @param FlightObserver
     */
    fun subscribe(o: FlightObserver) {
        observers.add(o)
        if (!t.isAlive) {
            startObserver()
        }
    }

    /**
     * unsubscribe method, removes observer from observers list
     * @param FlightObserver
     */
    fun unsubscribe(o: FlightObserver) {
        observers.remove(o)
    }

    /**
     * startObserver method, start thread
     */
    private fun startObserver() {
        t.start()
    }

}