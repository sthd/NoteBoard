package er;

import java.util.*;

/**
 * A Strategy that update the BillaBoard by column for ColorGenerator strategy design pattern
 *
 */
public class ColumnsPaintOrderStrategy implements PanelPaintOrderStrategy{

    /*
     * Abstraction function
     * ColumnStrategy is
     * this is part of Strategy design pattern
     * which will return the next element in by column
     * curRow is the index row of the billaboard panel
     * currCol is the currCol of the billaboard panel
     */

    /* Rep invariant is
     * currRow >=0 and currRow<36
     * currCol >=0 and currCol<36
     * and rowsLength = 6
     * */
    private int currRow=0,currCol=0;
    private int rowsLength = 6;

    /**
     * @modifies this
     * @effects return the next index by column order. for example,
     * for matrix 6x6 and row order,
     * this will return 1,7,...,31,2,8,...,32,...,36
     */
    @Override
    public int getNextPanel() {
        int next = currCol + currRow*rowsLength;
        currRow = (currRow+1)%rowsLength;
        if (0 == currRow) {currCol = (currCol+1)%rowsLength;}
        return next;
    }
    private void checkRep() {
        assert currRow>=0 && currRow<36;
        assert currCol>=0 && currCol<36;
        assert 6 == rowsLength;
    }
}



