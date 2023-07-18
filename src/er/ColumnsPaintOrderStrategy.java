package er;

import java.util.*;

public class ColumnsPaintOrderStrategy implements PanelPaintOrderStrategy{

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
        int currentPanel = nextPanel+2;
        // update next panel algorithm
        //checkRep();
        if (nextPanel !=0){
            nextPanel = 0;
        }
        return currentPanel;
    }

}



