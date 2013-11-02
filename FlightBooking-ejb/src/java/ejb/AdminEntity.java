/*
 * RedemptionEntity.java
 */
package ejb;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Admin")
public class AdminEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String username;
    private String password;

    // private Collection<BookingEntity> bookings = new ArrayList <BookingEntity>();
    //  private Collection<FlightEntity> flights = new ArrayList <BookingEntity>();
    public AdminEntity() {
    }

    public void create(String username, String password) {
        this.username = username;

        this.password = password;


    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
