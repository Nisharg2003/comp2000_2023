import java.awt.Color;
import java.awt.Graphics;

abstract class Actor {
    Cell cell;

    public Actor(Cell cell) {
        this.cell = cell;
    }

    public abstract void paint(Graphics g);
}

class Cat extends Actor {
    public Cat(Cell cell) {
        super(cell);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(cell.x, cell.y, Cell.size, Cell.size);
        g.setColor(Color.BLACK);
        g.drawRect(cell.x, cell.y, Cell.size, Cell.size);
    }
}

class Dog extends Actor {
    public Dog(Cell cell) {
        super(cell);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillRect(cell.x, cell.y, Cell.size, Cell.size);
        g.setColor(Color.BLACK);
        g.drawRect(cell.x, cell.y, Cell.size, Cell.size);
    }
}

class Bird extends Actor {
    public Bird(Cell cell) {
        super(cell);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(cell.x, cell.y, Cell.size, Cell.size);
        g.setColor(Color.BLACK);
        g.drawRect(cell.x, cell.y, Cell.size, Cell.size);
    }
}
