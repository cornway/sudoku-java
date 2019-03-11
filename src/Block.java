import java.util.ArrayList;

/**
 * Created by Роман on 11.05.2017.
 */
public class Block {
    private int[] intArray;
    private ArrayList<Cell> cellArray;

    public Block ()
    {
        this.intArray = new int[9];
        for (int i = 0; i < 9; i++) {
            this.intArray[i] = 0;
        }
        cellArray = new ArrayList<>();
    }

    public int pushInt (int num)
    {
        if (num == 0) {
            return 1;
        }
        for (int i = 0; i < 9; i++) {
            if (intArray[i] == 0) {
                intArray[i] = num;
                return 0;
            } else if (intArray[i] == num) {
                return 1;
            }
        }
        return -1;
    }

    void addCell (Cell cell)
    {
        this.cellArray.add(cell);
    }


    public int testInt (int num)
    {
        for (int i = 0; i < 9; i++) {
            if (intArray[i] == 0) {
                return 0;
            }
            if (intArray[i] == num) {
                return 1;
            }
        }
        return 1;
    }

    public int[] getIntArray ()
    {
        return this.intArray;
    }

    ArrayList<Cell> getCellArray ()
    {
        return cellArray;
    }

    public String toString ()
    {
        String s = "";
        for (int i = 0; i < 9; i++) {
            if (intArray[i] == 0) {
                return s;
            }
            s += Integer.toString(intArray[i]);
        }
        return s;
    }

}
