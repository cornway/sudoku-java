import javax.swing.*;

/**
 * Created by Роман on 11.05.2017.
 */
public class Cell {
    private int[] intArray;
    private Block block;
    private JTextField textField;
    private int digit;
    private int row, col;

    public Cell (int row, int col, JTextField textField, Block block, int digit)
    {
        this.intArray = new int[9];
        for (int i = 0; i < 9; i++) {
            this.intArray[i] = 0;
        }
        this.block = block;
        this.digit = digit;
        this.textField = textField;
        this.row = row;
        this.col = col;
        for (int i : block.getIntArray()) {
            this.pushInt(i);
        }
    }

    public int pushInt (int num)
    {
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

    public void pushInts (int ... ints)
    {
        for (int j : ints) {
            if (pushInt(j) < 0) return;
        }
    }

    public int testSingle ()
    {
        int[] array = this.getFreeInts();
        if (array[0] == 0) {
            return -1;
        }
        if (array[1] == 0) {
            return array[0];
        }
        return 0;
    }

    public boolean testFree (int digit)
    {
        for (int i = 0; i < 9; i++) {
            if (intArray[i] == 0) {
                return true;
            }
            if (intArray[i] == digit) {
                return false;
            }
        }
        return false;
    }

    public void setDigit (int digit)
    {
        this.digit = digit;
        textField.setToolTipText("");
    }

    public void setInts (int ... ints)
    {
        int i = 0;
        for (int j : ints) {
            if (i > 8) {
                break;
            }
            intArray[i++] = j;
        }
        intArray[i] = 0;
    }

    public void setIntsBut (int ... ints)
    {
        if (ints.length == 0) {
            return;
        }
        int[] array = new int[9];
        for (int i = 0; i < 9; i++) {array[i] = i + 1;}
        int i = 0;
        for (int j : ints) {
            if (j > 9) {
                continue;
            }
            if (j < 0) {
                continue;
            }
            array[j - 1] = 0;
        }
        i = 0;
        int j = 0;
        for (; i < 9; i++) {
            if (array[i] != 0) {
                intArray[j++] = array[i];
            }
        }
    }

    public int[] getIntArray ()
    {
        return this.intArray;
    }

    public int[] getFreeInts ()
    {
        int[] arrayBuf = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < 9; i++) {
            if (intArray[i] == 0) {
                break;
            }
            arrayBuf[ intArray[i] - 1 ] = 0;
        }
        int[] array = new int[9];
        for (int i = 0, j = 0; i < 9; i++) {
            if (arrayBuf[i] != 0) {
                array[j++] = arrayBuf[i];
            }
        }
        return array;
    }

    public int getDigit ()
    {
        return this.digit;
    }

    JTextField getTextField ()
    {
        return  textField;
    }

    int getRow ()
    {
        return row;
    }

    int getCol ()
    {
        return col;
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

    public String toStringFree ()
    {
        String s = "";
        int[] array = this.getFreeInts();
        for (int i = 0; i < 9; i++) {
            if (array[i] == 0) {
                return s;
            }
            s += Integer.toString(array[i]);
        }
        return s;
    }

}
