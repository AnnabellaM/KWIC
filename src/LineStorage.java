import java.util.ArrayList;
import java.util.Arrays;

public class LineStorage {

    private ArrayList<String> lines;
    private ArrayList<ArrayList<String>> words;

    public LineStorage() {
        this.lines = new ArrayList<>();
        this.words = new ArrayList<ArrayList<String>>();
    }

    public ArrayList<ArrayList<String>> getWords() {
        return words;
    }

    public void addLine(String line) {
        lines.add(line);
        words.add(splitLine(line));
    }

    private ArrayList<String> splitLine(String line) {
        return new ArrayList<String>(Arrays.asList(line.split(" ")));
    }

}
