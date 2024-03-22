import javax.swing.*;
import java.awt.*;

public class Tester extends JFrame {
    private JPanel title;
    private JPanel buttonPanel;

    private JButton square;
    private JButton triangle;
    private JButton circle;
    private JButton rectangle;


    public Tester(){
        setTitle("Kyle The rizzler");

        addButtons();

        setSize(new Dimension(700, 500));
        setVisible(true);
        setEnabled(true);
    }

    private void addButtons() {
        buttonPanel = new JPanel(new FlowLayout());
        square = new JButton();
        triangle = new JButton();
        rectangle = new JButton();
        circle = new JButton();

        buttonPanel.add(square);
        buttonPanel.add(triangle);
        buttonPanel.add(rectangle);
        buttonPanel.add(circle);
    }

    public static void main(String[] args) {
        new Tester();
    }



}
