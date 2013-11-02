/*
 * RedemptionEntity.java
 */

package ejb;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name="Seat")
public class SeatEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    long seatId;
    private String seatClass;
    private int seatsAvailable;
    private double price;
    
    
   
    
    public SeatEntity (){
        setSeatId(System.nanoTime());
    }
    
    public void create (String seatClass, int seatsAvailable,  double price){
        this.seatClass = seatClass;
        this.seatsAvailable = seatsAvailable;
        this.price = price;
    }

    public long getSeatId() {
        return seatId;
    }

    public void setSeatId(long seatId) {
        this.seatId = seatId;
    }

    public String getSeatClass() {
        return seatClass;
    }

    public void setSeatClass(String seatClass) {
        this.seatClass = seatClass;
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    public void setSeatsAvailable(int seatsAvailable) {
        this.seatsAvailable = seatsAvailable;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

    