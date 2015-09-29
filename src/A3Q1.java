
import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Robot;
import becker.robots.Thing;
import becker.robots.Wall;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author iorgs3184
 */
public class A3Q1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        City kw = new City();

        Robot karel = new Robot(kw, 1, 1, Direction.EAST);
        Robot tina = new Robot(kw, 4, 1, Direction.EAST);

        new Wall(kw, 1, 5, Direction.WEST);
        new Wall(kw, 4, 5, Direction.EAST);

        new Thing(kw, 1, 3);
        new Thing(kw, 1, 4);
        new Thing(kw, 4, 6);

        while (!karel.canPickThing()) {
            karel.move();
        }

        while (tina.frontIsClear()) {
            tina.move();
        }
    }
}
