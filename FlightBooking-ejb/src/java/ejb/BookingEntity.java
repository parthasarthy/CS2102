

package ejb;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity (name="Booking")
public class BookingEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private long pnr;
    @ManyToOne
    private FlightEntity flight = new FlightEntity();
    private String name;
    private String contactNo;
    private String email;
    private int noOfSeats;
    private String classTravel;
 
    
    public BookingEntity (){
        setPnr(System.nanoTime());
    }
    
    public void create (FlightEntity flight, String name, String contactNo,String email, int noOfSeats, String classTravel){
        this.flight = flight;
        this.name= name;
        this.contactNo = contactNo;
        this.email = email;
        this.noOfSeats = noOfSeats;
       this.classTravel = classTravel;
    }
       

    public long getPnr() {
        return pnr;
    }

    public int getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    public void setPnr(long pnr) {
        this.pnr = pnr;
    }

    public FlightEntity getFlight() {
        return flight;
    }

    public void setFlight(FlightEntity flight) {
        this.flight = flight;
    }

   

    public String getClassTravel() {
        return classTravel;
    }

    public void setClassTravel(String classTravel) {
        this.classTravel = classTravel;
    }

    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
        
    
        
    
     
    
}

    
