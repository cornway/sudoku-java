import org.omg.CORBA.INTERNAL;
import sun.net.www.http.HttpClient;

import javax.net.ssl.SSLContext;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InterfaceAddress;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by Роман on 11.05.2017.
 */

interface GetRepeats {
    abstract int[] getRepeats (Cell[][] cells, int position);
}

interface PushDigitsFrom {
    abstract void pushDigitsFrom (Cell[][] cells, ArrayList<Digit> digitArrayList, ArrayList<Integer> integerArrayList, int position);
}

interface PositionChecker {
    abstract boolean check (int row, int col);
}

interface StripIterator {
    abstract void stripIterator (int row, int col, int digit, PositionChecker positionChecker);
}

public class Gui extends JFrame {
    private JTextField cell00;
    private JTextField cell01;
    private JTextField cell02;
    private JTextField cell03;
    private JTextField cell04;
    private JTextField cell05;
    private JTextField cell06;
    private JTextField cell07;
    private JTextField cell08;
    private JTextField cell10;
    private JTextField cell11;
    private JTextField cell12;
    private JTextField cell13;
    private JTextField cell14;
    private JTextField cell15;
    private JTextField cell16;
    private JTextField cell17;
    private JTextField cell18;
    private JTextField cell20;
    private JTextField cell21;
    private JTextField cell22;
    private JTextField cell23;
    private JTextField cell24;
    private JTextField cell25;
    private JTextField cell26;
    private JTextField cell27;
    private JTextField cell28;
    private JTextField cell30;
    private JTextField cell31;
    private JTextField cell32;
    private JTextField cell33;
    private JTextField cell34;
    private JTextField cell35;
    private JTextField cell36;
    private JTextField cell37;
    private JTextField cell38;
    private JTextField cell40;
    private JTextField cell41;
    private JTextField cell42;
    private JTextField cell43;
    private JTextField cell44;
    private JTextField cell45;
    private JTextField cell46;
    private JTextField cell47;
    private JTextField cell48;
    private JTextField cell50;
    private JTextField cell51;
    private JTextField cell52;
    private JTextField cell53;
    private JTextField cell54;
    private JTextField cell55;
    private JTextField cell56;
    private JTextField cell57;
    private JTextField cell58;
    private JTextField cell60;
    private JTextField cell61;
    private JTextField cell62;
    private JTextField cell63;
    private JTextField cell64;
    private JTextField cell65;
    private JTextField cell66;
    private JTextField cell67;
    private JTextField cell68;
    private JTextField cell70;
    private JTextField cell71;
    private JTextField cell72;
    private JTextField cell73;
    private JTextField cell74;
    private JTextField cell75;
    private JTextField cell76;
    private JTextField cell77;
    private JTextField cell78;
    private JTextField cell80;
    private JTextField cell81;
    private JTextField cell82;
    private JTextField cell83;
    private JTextField cell84;
    private JTextField cell85;
    private JTextField cell86;
    private JTextField cell87;
    private JTextField cell88;
    private JButton buttonGo;
    private JPanel rootPanel;
    private JButton buttonClear;
    private JButton buttonStore;
    private JButton buttonRestore;
    private JTextArea textAreaReport;

    private JTextField[][] cellsGrid;
    private ArrayList<JState> jStates;
    private HttpWorkflow httpWorkflow;
    private int totalPlacedDigits;
    private long totalTimeMilis;

    public Gui (String name)
    {
        super(name);

        this.setContentPane(this.rootPanel);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(500, 400));

        cellsGrid = new JTextField[9][9];
        cellsGrid[0][0] = cell00; cellsGrid[0][1] = cell01; cellsGrid[0][2] = cell02; cellsGrid[0][3] = cell03;
        cellsGrid[0][4] = cell04; cellsGrid[0][5] = cell05; cellsGrid[0][6] = cell06; cellsGrid[0][7] = cell07;
        cellsGrid[0][8] = cell08;

        cellsGrid[1][0] = cell10; cellsGrid[1][1] = cell11; cellsGrid[1][2] = cell12; cellsGrid[1][3] = cell13;
        cellsGrid[1][4] = cell14; cellsGrid[1][5] = cell15; cellsGrid[1][6] = cell16; cellsGrid[1][7] = cell17;
        cellsGrid[1][8] = cell18;

        cellsGrid[2][0] = cell20; cellsGrid[2][1] = cell21; cellsGrid[2][2] = cell22; cellsGrid[2][3] = cell23;
        cellsGrid[2][4] = cell24; cellsGrid[2][5] = cell25; cellsGrid[2][6] = cell26; cellsGrid[2][7] = cell27;
        cellsGrid[2][8] = cell28;

        cellsGrid[3][0] = cell30; cellsGrid[3][1] = cell31; cellsGrid[3][2] = cell32; cellsGrid[3][3] = cell33;
        cellsGrid[3][4] = cell34; cellsGrid[3][5] = cell35; cellsGrid[3][6] = cell36; cellsGrid[3][7] = cell37;
        cellsGrid[3][8] = cell38;

        cellsGrid[4][0] = cell40; cellsGrid[4][1] = cell41; cellsGrid[4][2] = cell42; cellsGrid[4][3] = cell43;
        cellsGrid[4][4] = cell44; cellsGrid[4][5] = cell45; cellsGrid[4][6] = cell46; cellsGrid[4][7] = cell47;
        cellsGrid[4][8] = cell48;

        cellsGrid[5][0] = cell50; cellsGrid[5][1] = cell51; cellsGrid[5][2] = cell52; cellsGrid[5][3] = cell53;
        cellsGrid[5][4] = cell54; cellsGrid[5][5] = cell55; cellsGrid[5][6] = cell56; cellsGrid[5][7] = cell57;
        cellsGrid[5][8] = cell58;

        cellsGrid[6][0] = cell60; cellsGrid[6][1] = cell61; cellsGrid[6][2] = cell62; cellsGrid[6][3] = cell63;
        cellsGrid[6][4] = cell64; cellsGrid[6][5] = cell65; cellsGrid[6][6] = cell66; cellsGrid[6][7] = cell67;
        cellsGrid[6][8] = cell68;

        cellsGrid[7][0] = cell70; cellsGrid[7][1] = cell71; cellsGrid[7][2] = cell72; cellsGrid[7][3] = cell73;
        cellsGrid[7][4] = cell74; cellsGrid[7][5] = cell75; cellsGrid[7][6] = cell76; cellsGrid[7][7] = cell77;
        cellsGrid[7][8] = cell78;

        cellsGrid[8][0] = cell80; cellsGrid[8][1] = cell81; cellsGrid[8][2] = cell82; cellsGrid[8][3] = cell83;
        cellsGrid[8][4] = cell84; cellsGrid[8][5] = cell85; cellsGrid[8][6] = cell86; cellsGrid[8][7] = cell87;
        cellsGrid[8][8] = cell88;

        /*demo*/
        cell00.setText("6");
        cell04.setText("5");
        cell08.setText("8");

        cell12.setText("1");
        cell15.setText("9");

        cell22.setText("4");
        cell24.setText("1");
        cell26.setText("3");
        cell27.setText("7");

        cell31.setText("1");
        cell36.setText("8");
        cell37.setText("3");
        cell38.setText("9");

        cell46.setText("5");
        cell47.setText("2");

        cell50.setText("3");
        cell53.setText("8");

        cell62.setText("5");
        cell63.setText("1");
        cell66.setText("2");
        cell67.setText("6");
        cell68.setText("3");

        cell70.setText("8");
        cell72.setText("6");
        cell75.setText("2");
        cell76.setText("1");

        cell85.setText("3");
        /*demo*/

        jStates = new ArrayList<>();

        textAreaReport.setEditable(false);
        totalPlacedDigits = 0;
        totalTimeMilis = 0;

        updateColor();

        //httpWorkflow = new HttpWorkflow();

        buttonClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == buttonClear) {
                    for (JTextField[] tArray : cellsGrid) {
                        for (JTextField tf : tArray) {
                            tf.setText("");
                        }
                    }
                    totalTimeMilis = 0;
                    textAreaReport.setText("");
                    updateColor();
                }
            }
        });

        buttonGo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == buttonGo) {
                    go();
                }
            }
        });

        buttonStore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == buttonStore) {
                    jStates.clear();
                    for (JTextField[] tArray : cellsGrid) {
                        for (JTextField tf : tArray) {
                            jStates.add(new JState(tf.getText(), tf.getBackground()));
                        }
                    }
                }
            }
        });

        buttonRestore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == buttonRestore) {
                    if (jStates.isEmpty() == true) {
                        return;
                    }
                    int i = 0;
                    JState state;
                    for (JTextField[] tArray : cellsGrid) {
                        for (JTextField tf : tArray) {
                            state = jStates.get(i);
                            tf.setText(state.getText());
                            tf.setBackground(state.getColor());
                            i++;
                        }
                    }
                    textAreaReport.setText("");
                }
            }
        });

    }

    private void updateColor ()
    {
        int rowSel = 0;
        int colSel = 0;
        Color colorPink = Color.PINK;
        Color colorGray = new Color(170, 200, 200);
        Color[][] color = { {colorPink, colorGray, colorPink}, {colorGray, colorPink, colorGray}, {colorPink, colorGray, colorPink} };
        for (int i = 0; i < 9; i++) {
            colSel = i / 3;
            for (int j = 0; j < 9; j++) {
                rowSel = j / 3;
                cellsGrid[i][j].setBackground(color[colSel][rowSel]);
            }
        }
    }

    private void go ()
    {
        long timeMilis = System.currentTimeMillis();
        textAreaReport.setText("");
        totalPlacedDigits = 0;
        int[][] matrix = new int[9][9];
        JTextField tf;
        String text;
        boolean error = false;
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                tf = cellsGrid[row][col];
                tf.setToolTipText("");
                text = tf.getText();
                if (text.length() > 1) {
                    tf.setBackground(Color.RED);
                    textAreaReport.setText("Too much digits !\n" + "Row : [" + Integer.toString(row) + "], Column : [" + Integer.toString(col) + "];");
                    error = true;
                } else {
                    if (text.length() > 0) {
                        matrix[row][col] = Integer.parseInt(text);
                        totalPlacedDigits++;
                    } else {
                        matrix[row][col] = 0;
                    }
                }
            }
        }
        if (error == true) {
            return;
        }
        /*Build 3x3 blocks*/

        Block[][] blocks = new Block[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                blocks[i][j] = new Block();
            }
        }
        int bRow = 0, bCol = 0;
        for (int row = 0; row < 9; row++) {
            bRow = row / 3;
            for (int col = 0; col < 9; col++) {
                bCol = col / 3;
                if (matrix[row][col] != 0) {
                    blocks[bRow][bCol].pushInt(matrix[row][col]);
                }
            }
        }
        Cell[][] cells = new Cell[9][9];
        for (int row = 0; row < 9; row++) {
            bRow = row / 3;
            for (int col = 0; col < 9; col++) {
                bCol = col / 3;
                cells[row][col] = new Cell(row, col, cellsGrid[row][col], blocks[bRow][bCol], matrix[row][col]);
                blocks[bRow][bCol].addCell(cells[row][col]);
            }
        }


        /*check cells for single*/
        checkSingle(cells, blocks);

        /*check point Pairs Row*/
        checkPointPairs(cells,
                this::getRepeatsRow,
                this::pushDigitsFromRow,
                (row, col, digit, positionChecker) -> {
                    for (int _col = 0; _col < 9; _col++) {
                        if (positionChecker.check(row, _col) == true) {
                            continue;
                        }
                        cells[row][_col].pushInt(digit);
                    }
                }
        );

        /*check point Pairs Col*/
        checkPointPairs(cells,
                this::getRepeatsCol,
                this::pushDigitsFromCol,
                (row, col, digit, positionChecker) -> {
                    for (int _row = 0; _row < 9; _row++) {
                        if (positionChecker.check(_row, col) == true) {
                            continue;
                        }
                        cells[_row][col].pushInt(digit);
                    }
                }
        );

        /*check point Pairs Block*/
        checkPointPairsBlock(cells, blocks);

        /*check Pairs*/

        checkPairs(cells, this::getRepeatsRow, this::pushDigitsFromRow);
        checkPairs(cells, this::getRepeatsCol, this::pushDigitsFromCol);

        /*check Block pairs*/
        checkBlockPairs(cells, blocks);

        /*check Triplets*/
        checkTriplets(cells, this::getRepeatsRow, this::pushDigitsFromRow);
        checkTriplets(cells, this::getRepeatsCol, this::pushDigitsFromCol);

        /*check Block Triplets*/
        checkTrpletsBlock(cells, blocks);

        /*check rows for hidden*/
        checkRowHidden(cells, blocks);

        /*check columns for hidden*/
        checkColHidden(cells, blocks);

        /*check blocks for hidden*/
        checkBlockHidden(cells, blocks);

        boolean resolved = false;
        if (totalPlacedDigits == 81) {
            resolved = this.verify(cells, blocks);
        } else {
            for (Cell[] cellArray : cells) {
                for (Cell cell : cellArray) {
                    if (cell.getDigit() > 0) {
                        continue;
                    }
                    cell.getTextField().setToolTipText(cell.toStringFree());
                }
            }
        }

        timeMilis = System.currentTimeMillis() - timeMilis;
        textAreaReport.append("\nStep done in : " + Float.toString( ( (float)timeMilis / 1000 ) ) + " seconds");
        totalTimeMilis += timeMilis;
        if (resolved == true) {
            textAreaReport.append("\nPuzzle done in : " + Float.toString( ( (float)totalTimeMilis / 1000 ) ) + " seconds");
        }
    }

    private void checkSingle (Cell[][] cells, Block[][] blocks)
    {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (cells[row][col].getDigit() == 0) {
                    Cell cell = cells[row][col];
                    Cell _cell;
                    for (int _row = 0; _row < 9; _row++) {
                        _cell = cells[_row][col];
                        if (_cell == cell) {
                            continue;
                        }
                        if (_cell.getDigit() > 0) {
                            cell.pushInt(_cell.getDigit());
                        }
                    }
                    for (int _col = 0; _col < 9; _col++) {
                        _cell = cells[row][_col];
                        if (_cell == cell) {
                            continue;
                        }
                        if (_cell.getDigit() > 0) {
                            cell.pushInt(_cell.getDigit());
                        }
                    }
                    int single = cell.testSingle();
                    if (single > 0) {
                        totalPlacedDigits++;
                        cell.setDigit(single);
                        cell.getTextField().setText(Integer.toString(single));
                        cell.getTextField().setBackground(Color.ORANGE);
                        rejectCell(cells, blocks, cell);
                    }

                }

            }
        }
    }

    interface PutSingle {
        abstract void putSingle (int single, Cell cell);
    }

    interface CellCheck {
        abstract boolean cellCheck (Cell aCell, Cell bCell);
    }

    private void rejectCell (Cell[][] cells, Block[][] blocks, Cell cell)
    {
        PutSingle putSingle = (y_single, y_cell) -> {
            if (y_single > 0) {
                totalPlacedDigits++;
                y_cell.setDigit(y_single);
                y_cell.getTextField().setText(Integer.toString(y_single));
                y_cell.getTextField().setBackground(Color.ORANGE);
                rejectCell(cells, blocks, y_cell);
            }
        };
        CellCheck cellCheck = (Cell aCell, Cell bCell) -> {
            if (aCell == bCell) {
                return true;
            }
            if (aCell.getDigit() > 0) {
                return true;
            }
            return false;
        };
        int row = cell.getRow();
        int col = cell.getCol();
        Cell _cell;
        int digit = cell.getDigit();
        for (int _row = 0; _row < 9; _row++) {
            _cell = cells[_row][col];
            if (cellCheck.cellCheck(_cell, cell) == true) {
                continue;
            }
            _cell.pushInt(digit);
            putSingle.putSingle(_cell.testSingle(), _cell);
        }

        for (int _col = 0; _col < 9; _col++) {
            _cell = cells[row][_col];
            if (cellCheck.cellCheck(_cell, cell) == true) {
                continue;
            }
            _cell.pushInt(digit);
            putSingle.putSingle(_cell.testSingle(), _cell);
        }

        Block block = blocks[cell.getRow() / 3][cell.getCol() / 3];
        for (Cell tCell : block.getCellArray()) {
            if (cellCheck.cellCheck(tCell, cell) == true) {
                continue;
            }
            tCell.pushInt(cell.getDigit());
            putSingle.putSingle(tCell.testSingle(), tCell);
        }

    }

    private boolean verify (Cell[][] cells, Block[][] blocks)
    {
        int sum = 0;
        for (Block[] bArray : blocks) {
            for (Block block : bArray) {
                sum = 0;
                for (Cell cell : block.getCellArray()) {
                    sum += cell.getDigit();
                }
                if (sum != 45) {
                    textAreaReport.setText(textAreaReport.getText() + "Wrong puzzle !");
                    return false;
                }
            }
        }
        for (int row = 0; row < 9; row++) {
            sum = 0;
            for (int col = 0; col < 9; col++) {
                sum += cells[row][col].getDigit();
            }
            if (sum != 45) {
                return false;
            }
        }
        for (int col = 0; col < 9; col++) {
            sum = 0;
            for (int row = 0; row < 9; row++) {
                sum += cells[row][col].getDigit();
            }
            if (sum != 45) {
                return false;
            }
        }
        textAreaReport.setText(textAreaReport.getText() + "Puzzle done !");
        return true;
    }

    private void checkRowHidden (Cell[][] cells, Block[][] blocks)
    {
        int[] zeroArray = {0};
        int[][] freeDigits = new int[9][];
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                Cell cell = cells[row][col];
                if (cell.getDigit() > 0) {
                    freeDigits[col] = zeroArray;
                } else {
                    freeDigits[col] = cell.getFreeInts();
                }
            }

            int repeats;
            int  column = 0;
            for (int digit = 0; digit < 9; digit++) {
                repeats = 0;
                for (int col = 0; col < 9; col++) {
                    for (int j = 0; j < 9; j++) {
                        if (freeDigits[col][j] == 0) {
                            break;
                        } else if (freeDigits[col][j] == digit + 1) {
                            repeats++;
                            column = col;
                            break;
                        }
                    }
                }
                if (repeats == 1) {
                    totalPlacedDigits++;
                    cellsGrid[row][column].setText(Integer.toString(digit + 1));
                    cellsGrid[row][column].setBackground(Color.ORANGE);
                    rejectCell(cells, blocks, cells[row][column]);
                    break;
                }
            }

        }
    }

    private void checkColHidden (Cell[][] cells, Block[][] blocks)
    {
        int[][] freeDigits = new int[9][];
        int[] zeroArray = {0};
        for (int col = 0; col < 9; col++) {
            for (int row = 0; row < 9; row++) {
                Cell cell = cells[row][col];
                if (cell.getDigit() > 0) {
                    freeDigits[row] = zeroArray;
                } else {
                    freeDigits[row] = cell.getFreeInts();
                }
            }

            int repeats;
            int _row = 0;
            for (int digit = 0; digit < 9; digit++) {
                repeats = 0;
                for (int row = 0; row < 9; row++) {
                    for (int j = 0; j < 9; j++) {
                        if (freeDigits[row][j] == 0) {
                            break;
                        } else if (freeDigits[row][j] == digit + 1) {
                            repeats++;
                            _row = row;
                            break;
                        }
                    }
                }
                if (repeats == 1) {
                    totalPlacedDigits++;
                    cellsGrid[_row][col].setText(Integer.toString(digit + 1));
                    cellsGrid[_row][col].setBackground(Color.ORANGE);
                    rejectCell(cells, blocks, cells[_row][col]);
                    break;
                }
            }

        }
    }

    private void checkBlockHidden (Cell[][] cells, Block[][] blocks)
    {
        int[][] freeDigits = new int[9][];
        int[] zeroArray = {0};
        for (Block[] blockArray : blocks) {
            for (Block block : blockArray) {
                ArrayList<Cell> cellArray = block.getCellArray();
                int j = 0;
                for (Cell cell : cellArray) {
                    if (cell.getDigit() > 0) {
                        freeDigits[j++] = zeroArray;
                    } else {
                        freeDigits[j++] = cell.getFreeInts();
                    }
                }

                int repeats;
                int position = 0;
                for (int digit = 0; digit < 9; digit++) {
                    if (block.testInt(digit + 1) > 0) {
                        continue;
                    }
                    repeats = 0;
                    for (int cnum = 0; cnum < 9; cnum++) {
                        for (int i = 0; i < 9; i++) {
                            if (freeDigits[cnum][i] == 0) {
                                break;
                            } else if (freeDigits[cnum][i] == digit + 1) {
                                repeats++;
                                position = cnum;
                                break;
                            }
                        }
                    }
                    if (repeats == 1) {
                        totalPlacedDigits++;
                        Cell cell = cellArray.get(position);
                        cell.setDigit(digit + 1);
                        cell.getTextField().setText(Integer.toString(digit + 1));
                        cell.getTextField().setBackground(Color.ORANGE);
                        rejectCell(cells, blocks, cell);
                    }
                }
            }

        }
    }

    private void checkPairs (Cell[][] cells, GetRepeats getRepeats, PushDigitsFrom pushDigitsFrom)
    {
        int[] digits;
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        ArrayList<Digit> digitArrayList = new ArrayList<>();
        ArrayList<Pair> pairs = new ArrayList<>();

        for (int position = 0; position < 9; position++) {
            digits = getRepeats.getRepeats(cells, position);

            integerArrayList.clear();

            pushByIf(integerArrayList, digits, repeats -> repeats == 2);

            if (integerArrayList.size() < 2) {
                continue;
            }

            digitArrayList.clear();
            pushDigitsFrom.pushDigitsFrom(cells, digitArrayList, integerArrayList, position);

            Digit cDigit = null;
            pairs.clear();
            for (; digitArrayList.size() > 0;) {
                cDigit = digitArrayList.remove(0);
                for (Digit tDigit : digitArrayList) {
                    if ((tDigit.getCol() == cDigit.getCol()) && (tDigit.getRow() == cDigit.getRow())) {
                        pairs.add( new Pair(tDigit.getDigit(), cDigit.getDigit(), tDigit.getRow(), tDigit.getCol()) );
                    }
                }
            }

            Pair pair;
            Pair pRemove;
            for (; pairs.size() > 0;) {
                pair = pairs.remove(0);
                pRemove = null;
                for (Pair tPair : pairs) {
                    if (pair.compare(tPair) == true) {
                        pRemove = tPair;
                        cellsGrid[tPair.getRow()][tPair.getCol()].setBackground(new Color(200, 150, 240));
                        cellsGrid[pair.getRow()][pair.getCol()].setBackground(new Color(200, 150, 240));
                        cells[tPair.getRow()][tPair.getCol()].setIntsBut(tPair.getA(), tPair.getB());
                        cells[pair.getRow()][pair.getCol()].setIntsBut(pair.getA(), pair.getB());
                        break;
                    }
                }
                if (pRemove != null) {
                    pairs.remove(pRemove);
                }
            }

        } /*rows*/
    }

    public void checkBlockPairs (Cell[][] cells, Block[][] blocks)
    {
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        ArrayList<Digit> digitArrayList = new ArrayList<>();
        ArrayList<Pair> pairs = new ArrayList<>();
        int[] digits;
        ArrayList<Cell> cellArrayList;
        for (Block[] blockArray : blocks) {
            for (Block block : blockArray) {

                cellArrayList = block.getCellArray();
                digits = getRepeatsArray(cellArrayList);

                integerArrayList.clear();

                pushByIf(integerArrayList, digits, repeats -> repeats == 2);

                if (integerArrayList.size() < 2) {
                    continue;
                }

                digitArrayList.clear();
                pushDigitsFromArray(cellArrayList, digitArrayList, integerArrayList);

                Digit cDigit = null;
                pairs.clear();
                for (; digitArrayList.size() > 0;) {
                    cDigit = digitArrayList.remove(0);
                    for (Digit tDigit : digitArrayList) {
                        if ((tDigit.getRow() == cDigit.getRow()) && (tDigit.getCol() == cDigit.getCol())) {
                            pairs.add( new Pair(tDigit.getDigit(), cDigit.getDigit(), tDigit.getRow(), tDigit.getCol()) );
                        }
                    }
                }
                Pair pair;
                Pair pRemove;
                for (; pairs.size() > 0;) {
                    pair = pairs.remove(0);
                    pRemove = null;
                    for (Pair tPair : pairs) {
                        if (pair.compare(tPair) == true) {
                            pRemove = tPair;
                            cellsGrid[tPair.getRow()][tPair.getCol()].setBackground(new Color(200, 150, 240));
                            cellsGrid[pair.getRow()][pair.getCol()].setBackground(new Color(200, 150, 240));
                            cells[tPair.getRow()][tPair.getCol()].setIntsBut(tPair.getA(), tPair.getB());
                            cells[pair.getRow()][pair.getCol()].setIntsBut(pair.getA(), pair.getB());
                            break;

                        }
                    }
                    if (pRemove != null) {
                        pairs.remove(pRemove);
                    }
                }

            } /*bCol*/

        } /*bRow*/


    }

    private void checkTriplets (Cell[][] cells, GetRepeats getRepeats, PushDigitsFrom pushDigitsFrom)
    {
        int[] digits;
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        ArrayList<Digit> digitArrayList = new ArrayList<>();
        ArrayList<Triplet> triplets = new ArrayList<>();

        for (int position = 0; position < 9; position++) {
            digits = getRepeats.getRepeats(cells, position);

            integerArrayList.clear();
            pushByIf(integerArrayList, digits, repeats -> repeats == 3);

            if (integerArrayList.size() < 3) {
                continue;
            }

            digitArrayList.clear();
            pushDigitsFrom.pushDigitsFrom(cells, digitArrayList, integerArrayList, position);

            Digit aDigit = null;
            Digit bDigit = null;
            triplets.clear();
            for (; digitArrayList.size() > 0;) {
                aDigit = digitArrayList.remove(0);
                bDigit = null;
                for (Digit tDigit : digitArrayList) {
                    if ((tDigit.getCol() == aDigit.getCol()) && (tDigit.getRow() == aDigit.getRow())) {
                        bDigit = tDigit;
                        break;
                    }
                }
                if (bDigit != null) {
                    digitArrayList.remove(bDigit);
                    for (Digit tDigit : digitArrayList) {
                        if ((tDigit.getCol() == bDigit.getCol()) && (tDigit.getRow() == bDigit.getRow())) {
                            triplets.add( new Triplet(aDigit.getDigit(), bDigit.getDigit(), tDigit.getDigit(), tDigit.getRow(), tDigit.getCol()) );
                        }
                    }
                    digitArrayList.add(bDigit);
                }
            }

            Triplet aTriplet = null;
            Triplet bTriplet = null;
            Triplet tRemove;
            for (; triplets.size() > 0; ) {
                aTriplet = triplets.remove(0);
                bTriplet = null;
                for (Triplet tTriplet : triplets) {
                    if (aTriplet.compare(tTriplet) == true) {
                        bTriplet = tTriplet;
                        break;
                    }
                }
                if (bTriplet != null) {
                    triplets.remove(bTriplet);
                    tRemove = null;
                    for (Triplet tTriplet : triplets) {
                        if (bTriplet.compare(tTriplet) == true) {
                            tRemove = tTriplet;
                            cellsGrid[aTriplet.getRow()][aTriplet.getCol()].setBackground(new Color(100, 200, 100));
                            cellsGrid[bTriplet.getRow()][bTriplet.getCol()].setBackground(new Color(100, 200, 100));
                            cellsGrid[tTriplet.getRow()][tTriplet.getCol()].setBackground(new Color(100, 200, 100));
                            cells[aTriplet.getRow()][aTriplet.getCol()].setIntsBut(aTriplet.getA(), aTriplet.getB(), aTriplet.getC());
                            cells[bTriplet.getRow()][bTriplet.getCol()].setIntsBut(bTriplet.getA(), bTriplet.getB(), bTriplet.getC());
                            cells[tTriplet.getRow()][tTriplet.getCol()].setIntsBut(tTriplet.getA(), tTriplet.getB(), tTriplet.getC());
                            break;
                        }
                    }
                    if (tRemove != null) {
                        triplets.remove(tRemove);
                    }
                }
            }
        } /*row*/

    } /*check row triplets*/

    private void checkTrpletsBlock (Cell[][] cells, Block[][] blocks)
    {
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        ArrayList<Digit> digitArrayList = new ArrayList<>();
        ArrayList<Triplet> triplets = new ArrayList<>();
        int[] digits;
        ArrayList<Cell> cellArrayList;
        for (int bRow = 0; bRow < 3; bRow++) {

            for (int bCol = 0; bCol < 3; bCol++) {

                cellArrayList = blocks[bRow][bCol].getCellArray();
                digits = getRepeatsArray(cellArrayList);

                integerArrayList.clear();
                pushByIf(integerArrayList, digits, repeats -> repeats == 3);

                if (integerArrayList.size() < 3) {
                    continue;
                }

                digitArrayList.clear();
                pushDigitsFromArray(cellArrayList, digitArrayList, integerArrayList);

                Digit aDigit = null;
                Digit bDigit = null;
                triplets.clear();
                for (; digitArrayList.size() > 0;) {
                    aDigit = digitArrayList.remove(0);
                    bDigit = null;
                    for (Digit tDigit : digitArrayList) {
                        if ((tDigit.getRow() == aDigit.getRow()) && (tDigit.getCol() == aDigit.getCol())) {
                            bDigit = tDigit;
                            break;
                        }
                    }
                    if (bDigit != null) {
                        digitArrayList.remove(bDigit);
                        for (Digit tDigit : digitArrayList) {
                            if ((tDigit.getRow() == bDigit.getRow()) && (tDigit.getCol() == bDigit.getCol())) {
                                triplets.add( new Triplet(aDigit.getDigit(), bDigit.getDigit(), tDigit.getDigit(), tDigit.getRow(), tDigit.getCol()) );
                            }
                        }
                        digitArrayList.add(bDigit);
                    }
                }

                Triplet aTriplet = null;
                Triplet bTriplet = null;
                Triplet tRemove;
                for (; triplets.size() > 0; ) {
                    aTriplet = triplets.remove(0);
                    bTriplet = null;
                    for (Triplet tTriplet : triplets) {
                        if (aTriplet.compare(tTriplet) == true) {
                            bTriplet = tTriplet;
                            break;
                        }
                    }
                    if (bTriplet != null) {
                        tRemove = null;
                        triplets.remove(bTriplet);
                        for (Triplet tTriplet : triplets) {
                            if (bTriplet.compare(tTriplet) == true) {
                                tRemove = tTriplet;
                                cellsGrid[aTriplet.getRow()][aTriplet.getCol()].setBackground(new Color(100, 200, 100));
                                cellsGrid[bTriplet.getRow()][bTriplet.getCol()].setBackground(new Color(100, 200, 100));
                                cellsGrid[tTriplet.getRow()][tTriplet.getCol()].setBackground(new Color(100, 200, 100));
                                cells[aTriplet.getRow()][aTriplet.getCol()].setIntsBut(aTriplet.getA(), aTriplet.getB(), aTriplet.getC());
                                cells[bTriplet.getRow()][bTriplet.getCol()].setIntsBut(bTriplet.getA(), bTriplet.getB(), bTriplet.getC());
                                cells[tTriplet.getRow()][tTriplet.getCol()].setIntsBut(tTriplet.getA(), tTriplet.getB(), tTriplet.getC());
                                break;
                            }
                        }
                        if (tRemove != null) {
                            triplets.remove(tRemove);
                        }
                    }
                }

            } /*bCol*/

        } /*bRow*/

    }

    private void checkPointPairs (Cell[][] cells, GetRepeats getRepeats, PushDigitsFrom pushDigitsFrom, StripIterator stripIterator)
    {
        ArrayList<Digit> digitArrayList = new ArrayList<>();
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        int[] digitArray;
        for (int position = 0; position < 9; position++) {
            digitArray = getRepeats.getRepeats(cells, position);

            integerArrayList.clear();
            pushByIf(integerArrayList, digitArray, repeats -> repeats == 2);

            if (integerArrayList.size() < 1) {
                continue;
            }

            digitArrayList.clear();
            pushDigitsFrom.pushDigitsFrom(cells, digitArrayList, integerArrayList, position);
            Digit dRemove;
            for (; digitArrayList.size() > 0; ) {
                dRemove = null;
                Digit cDigit = digitArrayList.remove(0);
                for (Digit tDigit : digitArrayList) {
                    if (tDigit.getDigit() == cDigit.getDigit()) {
                        dRemove = tDigit;
                        stripIterator.stripIterator(tDigit.getRow(), tDigit.getCol(), tDigit.getDigit(), (row, col) -> {
                            if ((col == cDigit.getCol()) && (row == cDigit.getRow())) {
                                return true;
                            }
                            if ((col == tDigit.getCol()) && (row == tDigit.getRow())) {
                                return true;
                            }
                            return false;
                        });
                    }
                    if (dRemove != null) {
                        digitArrayList.remove(dRemove);
                        break;
                    }
                }
            }
        }
    }

    private void checkPointPairsBlock (Cell[][] cells, Block[][] blocks)
    {
        ArrayList<Digit> digitArrayList = new ArrayList<>();
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        int[] digitArray;
        for (Block[] blockArray : blocks) {
            for (Block block : blockArray) {
                ArrayList<Cell> cellArrayList = block.getCellArray();
                digitArray = getRepeatsArray(cellArrayList);

                integerArrayList.clear();
                pushByIf(integerArrayList, digitArray, repeats -> repeats == 2);

                if (integerArrayList.size() < 1) {
                    continue;
                }

                digitArrayList.clear();
                pushDigitsFromArray(cellArrayList, digitArrayList, integerArrayList);
                Digit dRemove;
                for (; digitArrayList.size() > 0; ) {
                    dRemove = null;
                    Digit cDigit = digitArrayList.remove(0);
                    for (Digit tDigit : digitArrayList) {
                        if (tDigit.getDigit() == cDigit.getDigit()) {
                            dRemove = tDigit;
                            if (tDigit.getRow() == cDigit.getRow()) {
                                int row = tDigit.getRow();
                                int digit = tDigit.getDigit();
                                for (int col = 0; col < 9; col++) {
                                    if (col == cDigit.getCol()) {
                                        continue;
                                    }
                                    if (col == tDigit.getCol()) {
                                        continue;
                                    }
                                    cells[row][col].pushInt(digit);
                                }
                            } else if (tDigit.getCol() == cDigit.getCol()) {
                                int col = tDigit.getCol();
                                int digit = tDigit.getDigit();
                                for (int row = 0; row < 9; row++) {
                                    if (row == tDigit.getRow()) {
                                        continue;
                                    }
                                    if (row == cDigit.getRow()) {
                                        continue;
                                    }
                                    cells[row][col].pushInt(digit);
                                }
                            }
                            if (false) {
                                //cells[tDigit.getRow()][tDigit.getCol()].getTextField().setBackground(Color.CYAN);
                                //cells[cDigit.getRow()][cDigit.getCol()].getTextField().setBackground(Color.CYAN);
                                //cells[tDigit.getRow()][tDigit.getCol()].getTextField().setToolTipText(Integer.toString( tDigit.getDigit() ));
                                //cells[cDigit.getRow()][cDigit.getCol()].getTextField().setToolTipText(Integer.toString( cDigit.getDigit() ));
                            }
                        }
                        if (dRemove != null) {
                            digitArrayList.remove(dRemove);
                            break;
                        }
                    }
                }

            } /*bCol*/

        } /*bRow*/
    }

    private int[] getRepeatsRow (Cell[][] cells, int row)
    {
        int[] digits = new int[9];
        int[] intArray;
        for (int i = 0; i < 9; i++) {digits[i] = 0; }

        for (int col = 0; col < 9; col++) {
            if (cells[row][col].getDigit() > 0) {
                continue;
            }
            intArray = cells[row][col].getFreeInts();
            for (int j = 0; j < 9; j++) {
                if (intArray[j] == 0) {
                    break;
                }
                digits[ intArray[j] - 1]++;
            }
        }
        return digits;
    }

    private int[] getRepeatsCol (Cell[][] cells, int col)
    {
        int[] digits = new int[9];
        int[] intArray;
        for (int i = 0; i < 9; i++) {digits[i] = 0; }

        for (int row = 0; row < 9; row++) {
            if (cells[row][col].getDigit() > 0) {
                continue;
            }
            intArray = cells[row][col].getFreeInts();
            for (int j = 0; j < 9; j++) {
                if (intArray[j] == 0) {
                    break;
                }
                digits[ intArray[j] - 1]++;
            }
        }
        return digits;
    }

    private int[] getRepeatsArray (ArrayList<Cell> cellArrayList)
    {
        int[] intArray;
        int[] digits = new int[9];
        for (int i = 0; i < 9; i++) {digits[i] = 0;}

        for (Cell cell : cellArrayList) {
            if (cell.getDigit() > 0) {
                continue;
            }
            intArray = cell.getFreeInts();
            for (int i = 0; i < 9; i++) {
                if (intArray[i] == 0) {
                    break;
                }
                digits[intArray[i] - 1]++;
            }
        }
        return digits;
    }

    interface Maybe {
        abstract boolean maybe (int cond);
    }

    public void pushByIf (ArrayList<Integer> integerArrayList, int[] digits, Maybe maybe)
    {
        for (int j = 0; j < 9; j++) {
            if (maybe.maybe(digits[j]) == true) {
                integerArrayList.add(new Integer(j + 1));
            }
        }
    }

    public void pushDigitsFromRow (Cell[][] cells, ArrayList<Digit> digitArrayList,  ArrayList<Integer> integerArrayList, int row)
    {
        for (int digit : integerArrayList) {
            for (int col = 0; col < 9; col++) {
                if (cells[row][col].getDigit() > 0) {
                    continue;
                }
                if (cells[row][col].testFree(digit) == true) {
                    digitArrayList.add( new Digit(digit, row, col) );
                }
            }
        }
    }

    public void pushDigitsFromCol (Cell[][] cells, ArrayList<Digit> digitArrayList,  ArrayList<Integer> integerArrayList, int col)
    {
        for (int digit : integerArrayList) {
            for (int row = 0; row < 9; row++) {
                if (cells[row][col].getDigit() > 0) {
                    continue;
                }
                if (cells[row][col].testFree(digit) == true) {
                    digitArrayList.add( new Digit(digit, row, col) );
                }
            }
        }
    }

    public void pushDigitsFromArray (ArrayList<Cell> cellArrayList, ArrayList<Digit> digitArrayList, ArrayList<Integer> integerArrayList)
    {
        for (int digit : integerArrayList) {
            for (Cell cell : cellArrayList) {
                if (cell.getDigit() > 0) {
                    continue;
                }
                if (cell.testFree(digit) == true) {
                    digitArrayList.add( new Digit(digit, cell.getRow(), cell.getCol()) );
                }
            }
        } /*digit*/
    }

    public static void main (String... args)
    {
        Gui gui = new Gui("Sudoku");
    }
}
