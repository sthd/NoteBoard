package er;

/**
 * A Strategy that update the BillaBoard by Acsending Order of rows
 * part of strategy design pattern as strategy implement
 */
public class AcsendingPaintOrderStrategy implements PanelPaintOrderStrategy {

    /*
     * Abstraction function
     * AcsendingPaintOrderStrategy is
     *  part of Strategy design pattern
     * which will return the next element in by raw
     * nextPanel is the current index  of the billaboard panel
     * BOARDSIZE is the size of the board
     */

    /* Rep Invariant
     * BOARDSIZE == 36 and (0<= nextPanel < 36)
     *
     */

    private final int BOARDSIZE = 36;
    private int nextPanel =0;

    /**
     * @modifies this
     * @effects return the next index in order from 0 to 35
     * for example 0,1,2,3,4....,35
     *
     */
    @Override
    public int getNextPanel(){
        checkRep();
        int next = nextPanel;
        nextPanel=(nextPanel+1)%(BOARDSIZE);
        checkRep();
        return next;
    }
    public void checkRep() {
        assert  36 == BOARDSIZE;
        assert nextPanel>=0 && nextPanel<36;

    }

}
