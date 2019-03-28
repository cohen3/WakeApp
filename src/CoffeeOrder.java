import java.sql.Time;
import java.util.Date;
import java.util.Objects;

public class CoffeeOrder implements Comparable {

    private final String ID;
    private final String order;
    private final Date orederTime;
    private final Date pickUpTime;
    public CoffeeOrder(String ID, String order, Date orederTime,Date pickUpTime) {
        this.ID = ID;
        this.order = order;
        this.orederTime = orederTime;
        this.pickUpTime = pickUpTime;
    }
    public String getID() { return ID; }
    public String getorder() {return order;}
    public Date getorederTime() { return orederTime; }
    public Date getpickUpTime() { return pickUpTime; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoffeeOrder that = (CoffeeOrder) o;
        return Objects.equals(ID, that.ID) &&
                Objects.equals(order, that.order) &&
                Objects.equals(orederTime, that.orederTime) &&
                Objects.equals(pickUpTime, that.pickUpTime);
    }
    @Override
    public int hashCode() {
        return Objects.hash(ID, order, orederTime, pickUpTime);
    }
    @Override
    public int compareTo(Object o) {
        CoffeeOrder other = (CoffeeOrder)o;
        if(this.pickUpTime.after(other.pickUpTime)){
            return 1; }
        else if (other.pickUpTime.after(this.orederTime)){
            return -1; }
        else{
            if(this.orederTime.after(other.orederTime)){
                return 1;}
            else if (other.orederTime.after(this.orederTime)){
                return -1;} }
        return 0;}
}

