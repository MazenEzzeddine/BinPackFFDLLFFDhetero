import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeastLoadedFFD {

    private List<Item> items;
    private double bincapacity;

    public LeastLoadedFFD(List<Item> items, double bincapacity) {
        this.items = items;
        this.bincapacity = bincapacity;
    }

    public List<Bin> fitFFD(){
        List<Bin> bins = new ArrayList<>();

        Collections.sort(items, Collections.reverseOrder());
        Bin bin = new Bin(bincapacity);
        bins.add(bin);
        Bin newbin = null;

        while(true) {

            for (Bin b : bins) {
                b.removeAssignment();
            }
            int i;
            for ( i = 0; i< items.size(); i++) {
                Item itt = items.get(i);

                Collections.sort(bins, Collections.reverseOrder());
                for (Bin b : bins) {
                    if (itt.getSize() <= b.currentCapacity()) {
                        b.assign(itt);
                        break;
                    }
                    if (b == bins.get(bins.size() - 1)) {
                        newbin = new Bin(bincapacity);
                        newbin.assign(itt);
                    }
                }
                if (newbin != null) {
                    bins.add(newbin);
                    newbin = null;
                    break;
                }

            }

            if ( i == items.size() ) {
                break;
            }
        }

        return bins;
    }

}
