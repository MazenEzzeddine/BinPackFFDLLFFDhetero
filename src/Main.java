import java.util.*;

public class Main {

    public static void main(String[] args) {

        double [] it = new double[]{70,40,30,20,10, 20};
        double [] it2 = new double[]{70,40,30,20,30, 20};

        ArrayList<Item> items = new ArrayList<>();


        for(int i = 0; i<6; i++) {
            items.add(new Item(it[i]));
        }


        FFD ffd = new FFD(100, items);
        ffd.fitFFD();

        LeastLoadedFFD llffd = new LeastLoadedFFD(items, 100);
        llffd.fitFFD();

        System.out.println("==========================================");


        FirstFitDecHetero ffdh = new FirstFitDecHetero(items, Arrays.asList(100.0,150.0));
        ffdh.fftFFDHetero();


    }












}
