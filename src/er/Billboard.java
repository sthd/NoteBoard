package er;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;




public class Billboard extends JFrame {


    /*
     * The main application class for billboard excersie
     * Will choose randomly one of 4 strategies and painting the panels in 6x6 billboard
     * Every 2 seconds will switch color
     *
     */



    private static final int PANELS_IN_COLUMNS = 6;
    private static final int PANELS_IN_ROWS = 6;
    private final int BOARDSIZE = PANELS_IN_COLUMNS * PANELS_IN_ROWS;
    private final int FREQUENCY = 2000; // 40 milliseconds delay
    private int time = 0;

    // preferred frame width and height.
    private static final int WINDOW_WIDTH = 600;
    private static final int WINDOW_HEIGHT = 600;

    JPanel billboard = new JPanel();
    Panel panels[] = new Panel[BOARDSIZE];
    ColorGenerator colorGenerator = ColorGenerator.getInstance();


    /**
     * @modifies this
     * @effects will run billaboard animation with random 1 of 4 strategies of paint order and random color
     */
    public Billboard() {
        super("Billboard");
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        billboard.setLayout(new GridLayout(PANELS_IN_ROWS, PANELS_IN_COLUMNS));

        for(int i = 0; i < BOARDSIZE; i++) {
            panels[i] = new Panel();
            colorGenerator.addObserver(panels[i]);
            billboard.add(panels[i]);
        }
        add(billboard);
        setVisible(true);

        Timer timer = new Timer(colorGenerator.getDelay(), new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (time % FREQUENCY == 0) {
                    Random randomPaintOrder = new Random();
                    switch (randomPaintOrder.nextInt(0,4)) {
                        case 0:
                            colorGenerator.setPanelPaintOrderStrategy(new AcsendingPaintOrderStrategy());
                            break;
                        case 1:
                            colorGenerator.setPanelPaintOrderStrategy(new ColumnsPaintOrderStrategy());
                            break;
                        case 2:
                            colorGenerator.setPanelPaintOrderStrategy(new RandomPaintOrderStrategy());
                            break;
                        case 3:
                            colorGenerator.setPanelPaintOrderStrategy(new TwoRoundsPaintOrderStrategy());
                            break;
                        default:
                            break;
                    }
                    colorGenerator.setRandomColor();
                }
                time += colorGenerator.getDelay();
                repaint();
            }
        });
        timer.start();
    }
    public static void main(String args[]) {
        Billboard billboard = new Billboard();
        billboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        billboard.setResizable(false);
        //billboard.pack();

    }

}