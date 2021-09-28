import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class AlphabeticShift {

    private CircularShift circularShift;
    private Integer[] orderIndices;

    public AlphabeticShift(CircularShift circularShift) {
        this.circularShift = circularShift;
        this.orderIndices = alphabeticSort(circularShift.getFirstWords());
    }

    public ArrayList<ArrayList<String>> getOrderedShifts() {
        ArrayList<ArrayList<String>> orderedShifts = new ArrayList<ArrayList<String>>();
        for (Integer indice : orderIndices) {
            orderedShifts.add(circularShift.getShifts().get(indice));
        }
        return orderedShifts;
    }

    private Integer[] alphabeticSort(ArrayList<String> words) {
        Integer[] indices = new Integer[words.size()];
        for (int i = 0; i < words.size(); i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, new ArrayIndiceComparator(words));
        return indices;
    }

    class ArrayIndiceComparator implements Comparator<Integer> {
        private ArrayList<String> words;

        public ArrayIndiceComparator(ArrayList<String> words) {
            this.words = words;
        }

        @Override
        public int compare(Integer o1, Integer o2) {
            return words.get(o1).compareTo(words.get(o2));
        }
    }

}
