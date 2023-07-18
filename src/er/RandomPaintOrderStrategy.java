package er;

public class RandomPaintOrderStrategy implements PanelPaintOrderStrategy{

    /*
     * Abstract Function:
     *
     *
     *
     *
     *
     */

    /*
     * Rep invariant:
     *
     *
     *
     *
     *
     *
     *
     *
     *
     */
    private final int BOARDSIZE = 36;
    private int nextPanel;

    /**
     *
     * @modifies this
     * @effects
     *
     */
    @Override
    public int getNextPanel() {
        int currentPanel = nextPanel;
        // update next panel algorithm
        //checkRep();
        return currentPanel;
    }

}



