package er;

public class TwoRoundsPaintOrderStrategy implements PanelPaintOrderStrategy {
    /*
     * Abstraction function for TwoRoundsPaintOrderStrategy
     * this is part of Strategy ColorGenerate design pattern
     * which will return indexes by even order and then odd order
     * this.parity tells if we are in the even nubmers part or if we are in the odd par
     * this.iterator tells us in which index we are currentnly now
     * BORADSIZE is the size of the board
     */

    /*
     * Rep invariant:
     * BOARDSIZE is always 36
     * iterator >=0 and iterator <36
     * parity is boolean
     * if parity is true then iterator iterating on even numbers
     * if parity is false then iterator iterating on odd numbers
     *
     */

    private final int BOARDSIZE = 36;
    private int iterator=0;
    private boolean parity = true;

    /**
     * @modifies this
     * @effects return the next odd or even index in 2 round strategy
     * for example
     * 0,2,4,6,...,34,1,3,5,...35
     *
     */
    @Override
    public int getNextPanel(){
        if(0==iterator || 1==iterator ) {
            iterator = (parity)?0:1;
            parity = !parity;
        }
        // update next panel algorithm
        //checkRep();
        int nextPanel = iterator;
        iterator = (iterator+2)%BOARDSIZE;

        return nextPanel;
    }

    private void checkRep(){
        assert iterator >=0 && iterator <36;
        assert 36 == BOARDSIZE;
        if(parity)
            assert 0==iterator%2;
        else
            assert 0==iterator%3;
    }

}
