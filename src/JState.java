import java.awt.*;

/**
 * Created by Роман on 11.05.2017.
 */
public class JState {
    String text;
    Color color;
    public JState (String text, Color color)
    {
        this.text = text;
        this.color = color;
    }

    Color getColor ()
    {
        return this.color;
    }

    String getText ()
    {
        return this.text;
    }

}
