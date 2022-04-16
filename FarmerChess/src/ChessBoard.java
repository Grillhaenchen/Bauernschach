import Infrasructure.Cell;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ChessBoard {
    private static final String COLS = "ABCDEFGH";
    Cell[][] CellSquare = new Cell[8][8];
    JPanel chessBoard;

    public ChessBoard() {
        initCellSquareArray();
    }

    private void initCellSquareArray() {
        for (int i = 0; i < CellSquare.length; i++) {
            for (int j = 0; j < CellSquare[i].length; j++) {
                CellSquare[i][j] = new Cell();
            }
        }
    }


    public void CreateGameField() {
        Insets buttonMargin = new Insets(0, 0, 0, 0);

        for (int ii = 0; ii < CellSquare.length; ii++) {
            for (int jj = 0; jj < CellSquare[ii].length; jj++) {

                CellSquare[jj][ii].setMargin(buttonMargin);
                // our chess pieces are 64x64 px in size, so we'll
                // 'fill this in' using a transparent icon..
                ImageIcon icon = new ImageIcon(new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB));
                CellSquare[jj][ii].setIcon(icon);

                if ((jj % 2 == 1 && ii % 2 == 1) || (jj % 2 == 0 && ii % 2 == 0)) {
                    CellSquare[jj][ii].setBackground(Color.WHITE);
                } else {
                    CellSquare[jj][ii].setBackground(Color.BLACK);
                }
            }
        }

        /*
         * fill the chess board
         */
        chessBoard.add(new JLabel(""));
        // fill the top row
        for (int ii = 0; ii < 8; ii++) {
            chessBoard.add(new JLabel(COLS.substring(ii, ii + 1), SwingConstants.CENTER));
        }
        // fill the black non-pawn piece row
        for (int ii = 0; ii < 8; ii++) {
            for (int jj = 0; jj < 8; jj++) {
                switch (jj) {
                    case 0:
                        chessBoard.add(new JLabel("" + (9 - (ii + 1)), SwingConstants.CENTER));
                    default:
                        chessBoard.add(CellSquare[jj][ii]);
                }
            }
        }


    }

    public JPanel CreateChessBoard() {
        chessBoard = new JPanel(new GridLayout(0, 9)) {

            @Override
            public final Dimension getPreferredSize() {
                Dimension d = super.getPreferredSize();
                Dimension prefSize = null;
                Component c = getParent();
                if (c == null) {
                    prefSize = new Dimension((int) d.getWidth(), (int) d.getHeight());
                } else if (c != null && c.getWidth() > d.getWidth() && c.getHeight() > d.getHeight()) {
                    prefSize = c.getSize();
                } else {
                    prefSize = d;
                }
                int w = (int) prefSize.getWidth();
                int h = (int) prefSize.getHeight();
                // the smaller of the two sizes
                int s = (w > h ? h : w);
                return new Dimension(s, s);
            }
        };

        chessBoard.setBorder(new CompoundBorder(new EmptyBorder(8, 8, 8, 8), new LineBorder(Color.BLACK)));
        // Set the BG to be ochre
        Color ochre = new Color(204, 119, 34);
        chessBoard.setBackground(ochre);
        JPanel boardConstrain = new JPanel(new GridBagLayout());
        boardConstrain.setBackground(ochre);
        CreateGameField();
        boardConstrain.add(chessBoard);


        return boardConstrain;
    }
}
