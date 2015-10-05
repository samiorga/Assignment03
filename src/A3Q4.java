
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
public class A3Q4 {

    public static void main(String[] args) {

        City kw = new City();

        new Wall(kw, 1, 1, Direction.NORTH);
        new Wall(kw, 1, 2, Direction.NORTH);
        new Wall(kw, 1, 2, Direction.EAST);
        new Wall(kw, 2, 2, Direction.EAST);
        new Wall(kw, 2, 2, Direction.SOUTH);
        new Wall(kw, 2, 1, Direction.SOUTH);
        new Wall(kw, 2, 1, Direction.WEST);
        new Wall(kw, 1, 1, Direction.WEST);

        Robot karel = new Robot(kw, 0, 3, Direction.WEST);

        for (int moveAround = 8; moveAround > 0; moveAround = moveAround - 1) {

            for (int moveCount = 3; moveCount > 0; moveCount = moveCount - 1) {
                karel.move();
            }
            if (!karel.isBesideThing(IPredicate.aWall)) {
                karel.turnLeft();
            }
        }
    }
}
