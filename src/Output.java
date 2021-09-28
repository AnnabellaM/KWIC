import java.util.ArrayList;

public class Output {

    private ArrayList<ArrayList<String>> orderedShifts;

    public Output(ArrayList<ArrayList<String>> orderedShifts) {
        this.orderedShifts = orderedShifts;
    }

    public void displayOrderedShift() {
        for (ArrayList<String> shift : orderedShifts) {
            String line = "";
            for (String word : shift) {
                line += word + " ";
            }
            System.out.println(line);
        }
    }

}
