/**
 * Created by Роман on 11.05.2017.
 */
public class Pair {
    private int a, b;
    private int row, col;

    public Pair (int a, int b, int row, int col)
    {
        this.a = a;
        this.b = b;
        this.row = row;
        this.col = col;
    }

    int getA ()
    {
        return a;
    }

    int getB ()
    {
        return b;
    }

    int getRow ()
    {
        return row;
    }

    int getCol ()
    {
        return col;
    }

    boolean compare (Pair pair)
    {
        if (a != pair.a) {
            return false;
        }
        if (b != pair.b) {
            return false;
        }
        return true;
    }

}
