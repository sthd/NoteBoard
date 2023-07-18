package er;

public class TwoRoundsPaintOrderStrategy implements PanelPaintOrderStrategy {

    /*
     * Representation Invariant:
     *
     *
     */

    /*Abstraction Function:
     *
     *
     *
     */
    private final int BOARDSIZE = 36;
    private int nextPanel;

    /**
     * @modifies this
     * @effects
     *
     */
    @Override
    public int getNextPanel(){
        int currentPanel = nextPanel;
        // update next panel algorithm
        //checkRep();
        return currentPanel;
    }

}
