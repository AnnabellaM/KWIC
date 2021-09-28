import java.util.Scanner;

public class Input {

    private InputListener inputListener;

    public void addListener(InputListener listener) {
        this.inputListener = listener;
    }

    public void enterKeywords() {
        String keyword = "";
        while (!keyword.equals("$")) {
            System.out.print("Please enter keywords here(Enter $ to finish input):");
            Scanner scanner = new Scanner(System.in);
            keyword = scanner.nextLine();
            if (!keyword.equals("$")) {
                inputListener.handleAddLineEvent(keyword);
            }
        }
        System.out.println("Processing...");
        inputListener.handleProcessLineEvent();
    }
}
