import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LLFFD {

    public static void main(String[] args) {
        double [] it = new double[]{70,40,30,20,10, 20};
        ArrayList<Item> items = new ArrayList<>();
        List<Bin> bins = new ArrayList<>();

        for (int i = 0; i <6; i++) {
            items.add(new Item(it[i]));
        }

        Collections.sort(items, Collections.reverseOrder());
        Bin bin = new Bin(100);
        bins.add(bin);
        Bin newbin = null;

        while(true) {
            for (Bin b : bins) {
                b.removeAssignment();
            }
            int i=0;
            for ( i = 0; i< items.size(); i++) {
                Item itt = items.get(i);

                Collections.sort(bins, Collections.reverseOrder());
                for (Bin b : bins) {
                    if (itt.getSize() <= b.currentCapacity()) {
                        b.assign(itt);
                        break;
                    }
                    if (b == bins.get(bins.size() - 1)) {
                        newbin = new Bin(100);
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
        System.out.println(bins);
        System.out.println("=======================================================");
        LeastLoadedFFD llffd = new LeastLoadedFFD(items, 100);
        FirstFitDecHetero ffdh = new FirstFitDecHetero(items, Arrays.asList(100.0, 150.0));
        System.out.println(ffdh.fftFFDHetero());
    }
}


