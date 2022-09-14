import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;

public class Bin implements Comparable {
    private final double capacity;
    private double currentCapacity;
    private  ArrayList<Item> Items;

    public Bin(double capacity) {
        this.capacity = capacity;
        Items = new ArrayList<>();
        this.currentCapacity = capacity;
    }

    public double currentCapacity(){
      return currentCapacity;
    }

    public void  assign(Item i) {
        Items.add(i);
        currentCapacity -= i.getSize();
    }


    public void  removeAssignment() {
         Items.clear();
         currentCapacity= capacity;

    }

    @Override
    public String toString() {
        return "Bin{" +
                "capacity=" + capacity +
                ", currentCapacity=" + currentCapacity +
                ", Items=" + Items +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return Double.compare(currentCapacity , ((Bin)o).currentCapacity);
    }
}
