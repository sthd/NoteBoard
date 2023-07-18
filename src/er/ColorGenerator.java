package er;

import java.awt.Color;
import java.util.*;


/**
 * ColorGenerator is Singleton Observable by Different Billboards.
 * It is responsible for generating a random color and notifying the Billboards
 */
public class ColorGenerator extends Observable {
    //	 Abstraction function:
    //	 A ColorGenerator is a singleton represented by its color (currentColor).
    //	 The color initialized to Pink.
    //
    //	 Representation Invariant:
    //   The color is valid ( 0 <= r,g,b <= 255)

    private final int DELAY = 40;
    private Random random;
    private PanelPaintOrderStrategy panelPaintOrderStrategy;
    private Vector<Observer> observers;

    private Color currentColor;


    @Override
    public synchronized void addObserver(Observer observer) {
        if (observer == null)
            throw new NullPointerException();
        if (!observers.contains(observer)) {
            observers.addElement(observer);
        }
    }

    @Override
    public void notifyObservers() {
        ColorGenerator copyOfThis = this;
        if (hasChanged()) {
            Timer timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                int counter = 0;

                public void run() {
                    (observers.get(panelPaintOrderStrategy.getNextPanel())).update(copyOfThis, null);
                    counter++;
                    if (counter == observers.size()) {
                        this.cancel();
                    }
                }
            }, DELAY, DELAY);
            clearChanged();
        }
    }


    // Using Singleton design pattern with eager initialisation
    private static ColorGenerator colorGenerator = new ColorGenerator();

    public void setPanelPaintOrderStrategy(PanelPaintOrderStrategy paintStrategy ){
        this.panelPaintOrderStrategy = paintStrategy;

    }


    /**
     *
     *
     * @modifies this
     * @effects Constructs a new ColorGenerator
     */
    protected ColorGenerator() {
        this.random = new Random();
        this.currentColor = Color.RED;
        this.panelPaintOrderStrategy = new AcsendingPaintOrderStrategy();
        this.observers = new Vector<>();
        //checkRep();
    }
    public void setRandomColor() {
        this.currentColor = generateRandomColor();
        setChanged();
        notifyObservers();
    }

    public Color getColor() {
        return this.currentColor;
    }

    /**
     * @returns a random color.
     */
    public Color generateRandomColor() {
        float r = random.nextFloat();
        float g = random.nextFloat();
        float b = random.nextFloat();
        Color randomColor = new Color(r, g, b);
        return randomColor;
    }


    /**
     *
     * @return the single ColorGenerator instance
     */
    public static ColorGenerator getInstance() {
        return colorGenerator;
    }

    public int getDelay() {
        return this.DELAY;
    }

}
