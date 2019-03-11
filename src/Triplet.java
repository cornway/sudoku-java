/**
 * Created by Роман on 12.05.2017.
 */
public class Triplet {
    private int row, col;
    private int a, b, c;

    public Triplet (int a, int b, int c, int row, int col)
    {
        this.a = a;
        this.b = b;
        this.c = c;
        this.row = row;
        this.col = col;
    }


    public int getRow ()
    {
        return row;
    }

    public int getCol ()
    {
        return col;
    }

    public int getA ()
    {
        return a;
    }

    public int getB ()
    {
        return b;
    }


    public int getC ()
    {
        return c;
    }

    public boolean compare (Triplet triplet)
    {
        if (triplet.a != a) {
            return false;
        }
        if (triplet.b != b) {
            return false;
        }
        if (triplet.c != c) {
            return false;
        }
        return true;
    }
}
