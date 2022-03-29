package airport


import flights.Flight
import flights.PlaneType
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

class AirportApi {
    private lateinit var flightList: ArrayList<Flight>
    val flights: ArrayList<Flight>
        get() {
            try {
                val APP_ID = "975bc6d0"
                val APP_KEY = "a802c0b2c90faffa941925455e73ec9e"
                val httpClient: HttpClient = HttpClients.createDefault()
                val request = HttpGet("https://api.schiphol.nl/public-flights/flights")
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
                    flightList = arrayListOf()
                    //println("found " + flights.size + " flights")
                    for (element in flights) {
                        try {
                            val jsonObject: JSONObject = element as JSONObject
                            val flight = Flight()
                            flight.flightName = jsonObject["flightName"] as String?
                            var planeType = PlaneType()
                            val planeInfo: JSONObject = jsonObject["aircraftType"] as JSONObject
                            planeType.iataMain = planeInfo["iataMain"] as String?
                            planeType.iataSub = planeInfo["iataSub"] as String?
                            flight.aircraftType = planeType
                            flight.terminal = jsonObject["terminal"] as Long?
                            flight.flightNumber = jsonObject["flightNumber"] as Long?
                            flight.lastUpdated = jsonObject["lastUpdatedAt"] as String?
                            flight.actualLandingTime = jsonObject["actualLandingTime"] as String?
                            flight.estimatedLandingTime = jsonObject["estimatedLandingTime"] as String?
                            flight.pier = jsonObject["pier"] as String?
                            val route: JSONObject = jsonObject["route"] as JSONObject
                            flight.visa = route["gate"] as Boolean?
                            flight.destination = route["destinations"].toString()
                            flight.eu = route["eu"] as String?
                            flight.scheduleDateTime = jsonObject["scheduleDateTime"] as String?
                            flight.mainFlight = jsonObject["mainFlight"] as String?
                            flight.gate = jsonObject["gate"] as String?
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
}