package er;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;



/*
 * this is Panel extends Jpanel class implementation with as a observers design pattern
 * the panel is a part of billaboard
 * each panel is observer
 */
public class Panel extends JPanel implements Observer {
    /*
     * Abstration function:
     * this is observer of billboard which will be called throught update()
     */
    /*
     * Rep invariant:
     * None
     */

    /**
     * @modifies this
     * @effects set the default color of this of white
     */
    public Panel() {
        setBackground(Color.WHITE);
    }

    /**
     * @modifies this
     * @effects update this.color to the color that return from o.getColor
     */
    @Override
    public void update(Observable o, Object arg) {
        ColorGenerator colorGenerator = (ColorGenerator)o;
        setBackground(colorGenerator.getColor());
        repaint();
    }


}
