/**
 * Created by Роман on 11.05.2017.
 */
public class Digit {
    private int digit;
    private int row;
    private int col;

    public Digit (int digit, int row, int col)
    {
        this.digit = digit;
        this.row = row;
        this.col = col;
    }


    public int getDigit ()
    {
        return digit;
    }

    public int getRow ()
    {
        return row;
    }

    public int getCol ()
    {
        return col;
    }

}
