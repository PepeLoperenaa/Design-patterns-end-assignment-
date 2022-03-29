package airport;

import flights.Flight;

import java.util.ArrayList;

public class NoticeBoard {
    public NoticeBoard(ArrayList<Flight> flights){
        for(int i = 0; flights.size() > i; i++){
            System.out.println(flights.get(i));
        }
    }

}
