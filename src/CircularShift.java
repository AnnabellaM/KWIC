import java.util.ArrayList;
import java.util.Collections;

public class CircularShift {

    private LineStorage lineStorage;
    private ArrayList<ArrayList<String>> shifts;

    public CircularShift(LineStorage storage) {
        this.lineStorage = storage;
        this.shifts = shiftForLines(lineStorage.getWords());
    }

    public ArrayList<ArrayList<String>> getShifts() {
        return shifts;
    }

    public ArrayList<String> getFirstWords() {
        ArrayList<String> firstWords = new ArrayList<String>();
        for (ArrayList<String> shift: shifts) {
            firstWords.add(shift.get(0));
        }
        return firstWords;
    }

    private ArrayList<ArrayList<String>> shiftForLines(ArrayList<ArrayList<String>> lines) {
        ArrayList<ArrayList<String>> shifts = new ArrayList<ArrayList<String>>();
        for (ArrayList<String> line: lines) {
            shifts.addAll(shiftForLine(line));
        }
        return shifts;
    }

    private ArrayList<ArrayList<String>> shiftForLine(ArrayList<String> line) {
        ArrayList<ArrayList<String>> shifts = new ArrayList<ArrayList<String>>();
        for (int i = 0; i < line.size(); i ++) {
            ArrayList<String> shift = new ArrayList<String>(line);
            Collections.rotate(shift, -1);
            shifts.add(shift);
            line = shift;
        }
        return shifts;
    }
}
