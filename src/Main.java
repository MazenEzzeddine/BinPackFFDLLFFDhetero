import java.util.*;

public class Main {

    public static void main(String[] args) {

        Item item1 = new Item(70);
        Item item2 = new Item(40);

        Item item3 = new Item(30);

        Item item4 = new Item(20);
        Item item5 = new Item(10);
        Item item6 = new Item(20);

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
        Bin mybin = null;
        for (Item itt : items) {
            for (Bin b : bins) {
                if (itt.getSize() <= b.currentCapacity()) {
                    b.assign(itt);
                    break;
                }
                if (b == bins.get(bins.size() - 1)) {
                    mybin = new Bin(100);
                    mybin.assign(itt);
                }
            }
            if (mybin != null) {
                bins.add(mybin);
                mybin = null;
            }
            }

        for (Bin b : bins) {
            System.out.println(b);
        }
        }












}
