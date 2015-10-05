
import becker.robots.City;
import becker.robots.Direction;
import becker.robots.IPredicate;
import becker.robots.Robot;
import becker.robots.Wall;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Sami
 */
public class A3Q6 {

    public static void main(String[] args) {

        //Make a city for the robot to live in
        City kw = new City();

        //Make Walls
        new Wall(kw, 1, 1, Direction.NORTH);
        new Wall(kw, 1, 2, Direction.NORTH);
        new Wall(kw, 1, 2, Direction.EAST);
        new Wall(kw, 2, 2, Direction.EAST);
        new Wall(kw, 2, 2, Direction.SOUTH);
        new Wall(kw, 2, 1, Direction.SOUTH);
        new Wall(kw, 2, 1, Direction.WEST);
        new Wall(kw, 1, 1, Direction.WEST);

        new Wall(kw, 1, 4, Direction.NORTH);
        new Wall(kw, 1, 5, Direction.NORTH);
        new Wall(kw, 1, 5, Direction.EAST);
        new Wall(kw, 2, 5, Direction.EAST);
        new Wall(kw, 2, 5, Direction.SOUTH);
        new Wall(kw, 2, 4, Direction.SOUTH);
        new Wall(kw, 2, 4, Direction.WEST);
        new Wall(kw, 1, 4, Direction.WEST);

        new Wall(kw, 4, 1, Direction.NORTH);
        new Wall(kw, 4, 2, Direction.NORTH);
        new Wall(kw, 4, 2, Direction.EAST);
        new Wall(kw, 5, 2, Direction.EAST);
        new Wall(kw, 5, 2, Direction.SOUTH);
        new Wall(kw, 5, 1, Direction.SOUTH);
        new Wall(kw, 5, 1, Direction.WEST);
        new Wall(kw, 4, 1, Direction.WEST);

        new Wall(kw, 4, 4, Direction.NORTH);
        new Wall(kw, 4, 5, Direction.NORTH);
        new Wall(kw, 4, 5, Direction.EAST);
        new Wall(kw, 5, 5, Direction.EAST);
        new Wall(kw, 5, 5, Direction.SOUTH);
        new Wall(kw, 5, 4, Direction.SOUTH);
        new Wall(kw, 5, 4, Direction.WEST);
        new Wall(kw, 4, 4, Direction.WEST);

        Robot karel = new Robot(kw, 3, 3, Direction.SOUTH);

        for (int moveWhole = 2; moveWhole > 0; moveWhole = moveWhole - 1) {

            for (int moveAround = 3; moveAround > 0; moveAround = moveAround - 1) {

                for (int moveCount = 3; moveCount > 0; moveCount = moveCount - 1) {
                    karel.move();
                }
                if (!karel.isBesideThing(IPredicate.aWall)) {
                    karel.turnLeft();
                }
            }
            
            for (int moveCount = 6; moveCount > 0; moveCount = moveCount - 1) {
                karel.move();
            }
            for (int moveAround = 3; moveAround > 0; moveAround = moveAround - 1) {
                if (!karel.isBesideThing(IPredicate.aWall)) {
                    karel.turnLeft();
                }
                for (int moveCount = 3; moveCount > 0; moveCount = moveCount - 1) {
                    karel.move();
                }
            }
        }
    }
}
