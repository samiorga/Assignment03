
import becker.robots.City;
import becker.robots.Direction;
import becker.robots.IPredicate;
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
public class A3Q2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        City kw = new City();

        new Wall(kw, 1, 1, Direction.WEST);
        new Wall(kw, 1, 1, Direction.NORTH);
        new Wall(kw, 1, 2, Direction.NORTH);
        new Wall(kw, 1, 3, Direction.NORTH);
        new Wall(kw, 1, 4, Direction.NORTH);
        new Wall(kw, 1, 4, Direction.EAST);
        new Wall(kw, 2, 4, Direction.EAST);
        new Wall(kw, 3, 4, Direction.EAST);
        new Wall(kw, 3, 4, Direction.SOUTH);
        new Wall(kw, 3, 3, Direction.SOUTH);
        new Wall(kw, 3, 2, Direction.SOUTH);
        new Wall(kw, 3, 1, Direction.SOUTH);
        new Wall(kw, 3, 1, Direction.WEST);
        new Wall(kw, 2, 1, Direction.WEST);

        new Thing(kw, 1, 2);
        new Thing(kw, 2, 2);
        new Thing(kw, 2, 3);
        new Thing(kw, 2, 4);
        new Thing(kw, 3, 1);
        new Thing(kw, 3, 1);
        new Thing(kw, 3, 4);

        Robot karel = new Robot(kw, 1, 1, Direction.EAST);

        while (true) {

            karel.move();

            if (karel.canPickThing()) {
                karel.pickThing();
            }

            while (karel.frontIsClear() && karel.getAvenue() != 1) {
                if (karel.canPickThing()) {
                    karel.pickThing();
                }
                karel.move();

            }
            if (karel.canPickThing()) {
                karel.pickThing();
            }
            if (!karel.frontIsClear() && karel.getAvenue() != 1) {
                karel.turnLeft();
                karel.turnLeft();
            }
            if (karel.canPickThing()) {
                karel.pickThing();
            }
            if (!karel.frontIsClear() && karel.getAvenue() == 1) {
                karel.turnLeft();

                if (karel.frontIsClear()) {
                    karel.move();
                    karel.turnLeft();
                } else {
                    karel.turnLeft();
                    karel.turnLeft();
                }

            }
            if (karel.getAvenue() == 1 && karel.getStreet() == 1 && karel.getDirection() == Direction.EAST) {
                break;
            }
        }
    }
}
