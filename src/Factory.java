import javax.swing.*;

/**
 * A class from which the program starts.
 * Contains the {@code main()} method.
 */
public class Factory {
    /**
     * The main method of the program. To
     * start it, start this method.
     * @param args arguments of the main
     */
    public static void main(String[] args) {
        MyFrame frame = new MyFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        frame.setVisible(true);
    }
}
