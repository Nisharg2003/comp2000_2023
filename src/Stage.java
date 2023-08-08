
import java.awt.Point;
import java.awt.Graphics;

public class Stage {
    Grid grid = new Grid();
    Cat cat = new Cat(grid.cells[2][2]);
    Dog dog = new Dog(grid.cells[5][5]);
    Bird bird = new Bird(grid.cells[10][10]);

    public void paint(Graphics g, Point mousePos) {
        grid.paint(g, mousePos);
        cat.paint(g);
        dog.paint(g);
        bird.paint(g);
    }
}
