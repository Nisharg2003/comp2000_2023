import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame {
    public static void main(String[] args) throws Exception {
        Main window = new Main();
    }

    class Canvas extends JPanel {
        private Grid grid;

        public Canvas() {
            setPreferredSize(new Dimension(720, 720));
            grid = new Grid(20, 20);

            addMouseMotionListener(new MouseAdapter() {
                @Override
                public void mouseMoved(MouseEvent e) {
                    Point mousePosition = e.getPoint();
                    int cellRow = (mousePosition.y - 10) / 35;
                    int cellColumn = (mousePosition.x - 10) / 35;
                    grid.highlightCell(cellRow, cellColumn);
                    repaint(); // Request repaint to update the highlighted cell.
                }
            });
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            grid.draw(g);
        }
    }

    // Grid Class
    class Grid {
        private int r;
        private int c;
        private Cell[][] cells;
        private int highlightedRow;
        private int highlightedColumn;

        public Grid(int r, int c) {
            this.r = r;
            this.c = c;
            cells = new Cell[r][c];
            highlightedRow = -1; // Initialize to an invalid value
            highlightedColumn = -1;

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    cells[i][j] = new Cell(i, j);
                }
            }
        }

        public void draw(Graphics g) {
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    cells[i][j].paint(g);
                }
            }
        }

        public void highlightCell(int row, int column) {
            // Reset previously highlighted cell (if any)
            if (highlightedRow >= 0 && highlightedColumn >= 0) {
                cells[highlightedRow][highlightedColumn].setHighlighted(false);
            }

            // Update the currently highlighted cell
            if (row >= 0 && row < r && column >= 0 && column < c) {
                cells[row][column].setHighlighted(true);
                highlightedRow = row;
                highlightedColumn = column;
            } else {
                highlightedRow = -1;
                highlightedColumn = -1;
            }
        }
    }

    class Cell {
        private int r;
        private int c;
        private boolean highlighted;

        public Cell(int r, int c) {
            this.r = r;
            this.c = c;
            this.highlighted = false;
        }

        public void paint(Graphics g) {
            int x = 10 + c * 35;
            int y = 10 + r * 35;

            if (highlighted) {
                g.setColor(Color.RED);
                g.fillRect(x, y, 35, 35);
            } else {
                g.setColor(Color.BLACK);
                g.drawRect(x, y, 35, 35);
                g.setColor(Color.WHITE);
                g.fillRect(x, y, 35, 35);
            }
        }

        public void setHighlighted(boolean highlighted) {
            this.highlighted = highlighted;
        }
    }

    private Main() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Canvas canvas = new Canvas();
        this.setContentPane(canvas);
        this.pack();
        this.setVisible(true);
    }
}
