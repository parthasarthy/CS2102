/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Stateful;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@Stateful
public class FlightBookingBean implements FlightBookingBeanRemote {

    @PersistenceContext
    EntityManager em;
    private SeatEntity seatEntity;
    private FlightEntity flightEntity;
    private AdminEntity adminEntity;
    private BookingEntity bookingEntity;
    

    public FlightBookingBean (){}
    
    @Override
    public void makeBooking (String name, String email, String contactNo, String flightNo, String depDest, String arrDest, String carrier, String depDate, String depTime, String arrDate, String arrTime, String capacity, String model, String classTravel, Double price, int noOfSeats){
        boolean check = isSeatsAvailable (flightNo, depDate, noOfSeats, classTravel);
        if (check == true)
        {
            Query query = em.createQuery("from Flight b where b.flightNo=:first and b.departureDate=:last");
            query.setParameter("first", flightNo);
            query.setParameter("last", depDate);
            for (Object o : query.getResultList()) 
                flightEntity = (FlightEntity) o;
           BookingEntity b = new BookingEntity ();
            b.create (flightEntity, name, contactNo, email,noOfSeats, classTravel);
            em.persist(b);
        
        }
    }
    
    // This function checks the availablity of seats and also updates the seats available
    @Override
    public boolean isSeatsAvailable (String flightNo, String depDate, int noOfSeats, String classTravel){
          Query query = em.createQuery("from Flight b where b.flightNo=:first and b.departureDate=:last");
        query.setParameter("first", flightNo);
        query.setParameter("last", depDate);
            for (Object o : query.getResultList()) {
                FlightEntity f = (FlightEntity) o;
             for (Object obj : f.getSeats()){
                 SeatEntity s = (SeatEntity) obj;
                 if (s.getSeatClass().equals (classTravel)==true){
                     if (s.getSeatsAvailable()<noOfSeats){
                         
                     
                         return false;
                     }    
                  }
                  else {
                        int seatsPreBooking = s.getSeatsAvailable();
                        int seatsPostBooking = seatsPreBooking - noOfSeats;
                        s.setSeatsAvailable(seatsPostBooking);
                        em.persist(s);
                        return true;
                 }
             }
             }
        return true;
    }
    
    @Override
    public void deleteBookingByPnr(long pnr) {
        
           
        Query query = em.createQuery("from Booking b where b.pnr=:first");
            query.setParameter("first", pnr);
            for (Object o : query.getResultList()) {
                bookingEntity = (BookingEntity) o;
                int noOfSeats = bookingEntity.getNoOfSeats();
                String classTravel = bookingEntity.getClassTravel();
                FlightEntity f = new FlightEntity ();
                f = bookingEntity.getFlight();
                for (Object obj : f.getSeats()){
                 SeatEntity s = (SeatEntity) obj;
                 if (s.getSeatClass().equals (classTravel)==true){
                     int finalSeats = s.getSeatsAvailable() + noOfSeats;
                     s.setSeatsAvailable(finalSeats);
                 }
                
                em.remove(bookingEntity);

            }
            
        }

    }
    
    
    
    
    
    
    
    
    
    
    
}

    
    
    
    
    