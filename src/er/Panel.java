package er;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;


public class Panel extends JPanel implements Observer {

    private Color color;

    public Panel() {
        setBackground(Color.WHITE);
    }

    @Override
    public void update(Observable o, Object arg) {
        ColorGenerator colorGenerator = (ColorGenerator)o;
        setBackground(colorGenerator.getColor());
        repaint();
    }

}
