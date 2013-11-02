/*
 * RedemptionEntity.java
 */

package ejb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity (name="Flight")
public class FlightEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private long flightId;
    private String flightNo;
    private String departureDestination;
    private String arrivalDestination;
    private String carrier;
    private String departureDate;
    private String departureTime;
    private String arrivalDate;
    private String arrivalTime;
    private Integer capacity;
    private String aircraftModel;
    @OneToMany (cascade = {CascadeType.PERSIST})
    private Collection<SeatEntity> seats = new ArrayList <SeatEntity>();
   @OneToMany (cascade = {CascadeType.ALL}, mappedBy = "flight")
    private Collection <BookingEntity> bookings = new ArrayList <BookingEntity> ();
 
    
    public FlightEntity (){
    setFlightId(System.nanoTime());
    }
    
    public void create (String no,String departDest,String arrivalDest, String carrier, String depDate, String depTime,String arrDate, String arrTime, int capacity,String model, Collection<SeatEntity> seats){
        this.flightNo = no;
        this.departureDestination = departDest;
        this.arrivalDestination = arrivalDest;
        this.carrier = carrier;
        this.departureDate = depDate;
        this.departureTime = depTime;
        this.arrivalDate = arrDate;
        this.arrivalTime = arrTime;
        this.capacity = capacity;
        this.aircraftModel = model;
        this.seats = seats;
        
             
       }

    public Collection<BookingEntity> getBookings() {
        return bookings;
    }

    public void setBookings(Collection<BookingEntity> bookings) {
        this.bookings = bookings;
    }

    public long getFlightId() {
        return flightId;
    }

    public void setFlightId(long flightId) {
        this.flightId = flightId;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    

    public String getDepartureDestination() {
        return departureDestination;
    }

    public void setDepartureDestination(String departureDestination) {
        this.departureDestination = departureDestination;
    }

    public String getArrivalDestination() {
        return arrivalDestination;
    }

    public void setArrivalDestination(String arrivalDestination) {
        this.arrivalDestination = arrivalDestination;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getAircraftModel() {
        return aircraftModel;
    }

    public void setAircraftModel(String aircraftModel) {
        this.aircraftModel = aircraftModel;
    }

    public Collection<SeatEntity> getSeats() {
        return seats;
    }

    public void setSeats(Collection<SeatEntity> seats) {
        this.seats = seats;
    }

     
    
}

    
