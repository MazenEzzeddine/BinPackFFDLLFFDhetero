import java.util.*;

public class Main {

    public static void main(String[] args) {

        double [] it = new double[]{70,40,30,20,10, 20};
        ArrayList<Item> items = new ArrayList<>();
        List<Bin> bins = new ArrayList<>();

        for (int i = 0; i <6; i++) {
            items.add(new Item(it[i]));
        }


        for (Item i : items) {
            System.out.println(i);
        }

        Collections.sort(items, Collections.reverseOrder());

        for (Item i : items) {
            System.out.println(i);
        }



        ///// the FFD

        Bin bin = new Bin(100);
        bins.add(bin);
        Bin newbin = null;
        for (Item itt : items) {
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
            }
            }

        for (Bin b : bins) {
            System.out.println(b);
        }

    }












}
