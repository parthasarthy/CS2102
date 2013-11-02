package ejb;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.ejb.Remote;

@Remote
public interface FlightBookingBeanRemote {
    
  public void makeBooking (String name, String email, String contactNo, String flightNo, String depDest, String arrDest, String carrier, String depDate, String depTime, String arrDate, String arrTime, String capacity, String model, String classTravel, Double price, int noOfSeats);
  public boolean isSeatsAvailable (String flightNo, String depDate, int noOfSeats, String classTravel);
  public void deleteBookingByPnr(long pnr);
    
    
}

