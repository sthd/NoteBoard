package er;


import java.awt.Color;
import java.util.*;


/**
 * ColorGenerator is Singleton Observable by Different Billboards.
 * It is responsible for generating a random color and notifying the Billboards
 */
public class ColorGenerator extends Observable {
    /*
     * Abstraction function: A ColorGenerator is a singleton represented by its
     * color (currentColor). The color initialized to Pink.
     * this.DELAY is the delay time in milliseconds between each panel update in billbaord
     * panelPaintOrderStrategy is the strategy the defines the order which we update each order
     */

    /*
     * Representation Invariant:
     * currentColor instanceof Color
     * DELAY = 40
     * panelPaintOrderStrategy instance of PanelPaintOrderStrategy
     * panelPaintOrderStrategy != null
     * there is only one instance of ColorGenerator!=null
     */



    private static ColorGenerator colorGenerator = new ColorGenerator();
    private final int DELAY = 40;
    private PanelPaintOrderStrategy panelPaintOrderStrategy;
    private Vector<Observer> observers;
    private Color currentColor;

    /**
     * @modifies this
     * @effects Constructs a new ColorGenerator
     */
    public ColorGenerator() {
        this.currentColor = Color.RED;
        this.panelPaintOrderStrategy = new AcsendingPaintOrderStrategy();
        this.observers = new Vector<>();
        //checkRep();
    }
    /**
     * @requires observer implements Observable's update() method
     * @modifies this
     * @effects method for observer design pattern. will add new observers to this which will update later in animation
     * if observer already added then do nothing
     * @throws NullPointerException if observer=null
     */
    @Override
    public synchronized void addObserver(Observer observer) {
        if (observer == null)
            throw new NullPointerException();
        if (!observers.contains(observer)) {
            observers.addElement(observer);
        }
    }

    /**
     * @requires all added observers must implements Observable's update() method
     * @modifies this
     * @effects will call upadte() function of all the observers that had added
     * to this through addobservers()
     *
     */
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




    /**
     * @modifies this
     * @effects update this panel Paint Order Strategy to paintStrategy
     *
     */
    public void setPanelPaintOrderStrategy(PanelPaintOrderStrategy paintStrategy ){
        this.panelPaintOrderStrategy = paintStrategy;

    }

    /**
     * @modifies this
     * @effects randomaize new this.color and will update all the observers panels by the strategy
     *
     */
    public void setRandomColor() {
        this.currentColor = new Color((int)(Math.random() * 0x1000000));
        setChanged();
        notifyObservers();
    }
    /**
     * @return return this.color of the panels
     */
    public Color getColor() {
        return this.currentColor;
    }


    /**
     *
     * @return the single ColorGenerator instance
     */
    public static ColorGenerator getInstance() {
        return colorGenerator;
    }
    /**
     *
     * @return return the DELAY time between each panel update colour
     */
    public int getDelay() {
        return this.DELAY;
    }

    private void checkRep() {
        assert currentColor instanceof Color;
        assert panelPaintOrderStrategy instanceof PanelPaintOrderStrategy;
        assert panelPaintOrderStrategy !=null;
        assert colorGenerator!=null;
        assert 40 ==  DELAY;

    }

}
