package er;

public class AcsendingPaintOrderStrategy implements PanelPaintOrderStrategy {

    /*
     *
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
        int currentPanel = nextPanel++;
        if (nextPanel == BOARDSIZE){
            nextPanel = 0;
        }
        //checkRep();
        return currentPanel;
    }

}
