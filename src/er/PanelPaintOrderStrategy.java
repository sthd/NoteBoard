package er;


/**
 * This interface is for implemented by each strategy that sets the panel paint order
 * in the Billboard class.
 */
public interface PanelPaintOrderStrategy {
    //  Abstraction function:
    //	A PanelPaintOrderStrategy sets the order of painting the panels on the board
    //
    //	Representation Invariant:
    //

    /**
     * @effects Return the index of the next panel to paint
     */
    public int getNextPanel();
}
