import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FFD {
    private double capacity;
    private List<Item> items;

    public FFD(double capacity, List<Item> items) {
        this.capacity = capacity;
        this.items = items;
    }

    public List<Bin> fitFFD() {
        Collections.sort(items, Collections.reverseOrder());
        List<Bin> bins = new ArrayList<>();

        Bin bin = new Bin(capacity);
        bins.add(bin);
        Bin newbin = null;
        for (Item itt : items) {
            for (Bin b : bins) {
                if (itt.getSize() <= b.currentCapacity()) {
                    b.assign(itt);
                    break;
                }
                if (b == bins.get(bins.size() - 1)) {
                    newbin = new Bin(capacity);
                    newbin.assign(itt);
                }
            }
            if (newbin != null) {
                bins.add(newbin);
                newbin = null;
            }
        }

        for (Bin b : bins) {
            System.out.println(b);
        }

        return bins;

    }
}
