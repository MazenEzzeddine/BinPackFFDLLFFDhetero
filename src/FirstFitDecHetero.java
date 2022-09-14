import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FirstFitDecHetero {

    private List<Double> capacities;
    private List<Item> items;

    public FirstFitDecHetero( List<Item> items,List<Double> capacities) {
        this.capacities = capacities;
        this.items = items;
    }


    List<Bin> fftFFDHetero() {
        List<Bin> bins = new LeastLoadedFFD(items, capacities.get(capacities.size() - 1)).fitFFD();
        capacities.sort(new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return Double.compare(o1, o2);
            }
        });

        System.out.println(bins);
        List<Bin> newbins = new ArrayList<>();
        for (Bin b : bins) {
            for (Double capacity : capacities) {
                if ((b.getCapacity()- b.currentCapacity()) < capacity) {
                    Bin newbin = new Bin(capacity);
                    newbin.setItems(b.getItems());
                    newbin.setCurrentCapacity(b.getCurrentCapacity() - (b.getCapacity() - newbin.getCapacity()));
                    newbins.add(newbin);
                    break;
                }

            }
        }

        System.out.println(capacities);
        System.out.println(newbins);
        List<FairBin> fairbins =  new ArrayList<>();

        for(Bin b: newbins){
            fairbins.add(new FairBin(b.getCapacity()));
        }




        for(Item i: items) {
            Collections.sort(fairbins, Collections.reverseOrder());
            fairbins.get(0).assign(i);
        }

        System.out.println("fair bins are");
        System.out.println(fairbins);











        return bins;


    }










}
