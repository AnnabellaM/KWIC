public class MasterControl implements InputListener {

    private Input input;
    private Output output;
    private LineStorage lineStorage;
    private CircularShift circularShift;
    private AlphabeticShift alphabeticShift;

    public MasterControl() {
        this.input = new Input();
        this.lineStorage = new LineStorage();
    }

    public void start() {
        input.addListener(this);
        input.enterKeywords();
    }

    @Override
    public void handleAddLineEvent(String line) {
        lineStorage.addLine(line);
    }

    @Override
    public void handleProcessLineEvent() {
        circularShift = new CircularShift(lineStorage);
        alphabeticShift = new AlphabeticShift(circularShift);
        output = new Output(alphabeticShift.getOrderedShifts());
        output.displayOrderedShift();
    }

}
