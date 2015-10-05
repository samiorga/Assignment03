
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

        //City for robot to live in
        City kw = new City();

        //Walls in city
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

        //new Things
        new Thing(kw, 1, 2);
        new Thing(kw, 2, 2);
        new Thing(kw, 2, 3);
        new Thing(kw, 2, 4);
        new Thing(kw, 3, 1);
        new Thing(kw, 3, 1);
        new Thing(kw, 3, 4);

        //new robot to live in city
        Robot karel = new Robot(kw, 1, 1, Direction.EAST);

        //this happens if true
        while (true) {
            //karel moves
            karel.move();
            //karel picks things if he can
            if (karel.canPickThing()) {
                karel.pickThing();
            }
            //karel picks things if front is clear and not on avenue 1
            while (karel.frontIsClear() && karel.getAvenue() != 1) {
                if (karel.canPickThing()) {
                    karel.pickThing();
                }
                karel.move();

            }
            //karel picks things if he can
            if (karel.canPickThing()) {
                karel.pickThing();
            }
            //karel turns around if front isnt clear and not on avenue 1
            if (!karel.frontIsClear() && karel.getAvenue() != 1) {
                karel.turnLeft();
                karel.turnLeft();
            }
            //karel picks thing if he can
            if (karel.canPickThing()) {
                karel.pickThing();
            }
            //karel turns left if front isnt clear but is on avenue 1
            if (!karel.frontIsClear() && karel.getAvenue() == 1) {
                karel.turnLeft();
                
                //karel turns left then moves if front is clear
                if (karel.frontIsClear()) {
                    karel.move();
                    karel.turnLeft();
                } 
                //if not then karel turns around
                else {
                    karel.turnLeft();
                    karel.turnLeft();
                }

            }
            //if karel is on street 1 and avenue 1 and facing east program stops
            if (karel.getAvenue() == 1 && karel.getStreet() == 1 && karel.getDirection() == Direction.EAST) {
                break;
            }
        }
    }
}
