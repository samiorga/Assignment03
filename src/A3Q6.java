
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

        //new robot to live in City
        Robot karel = new Robot(kw, 3, 3, Direction.SOUTH);
        
        //karel moves around everything twice
        for (int moveWhole = 2; moveWhole > 0; moveWhole = moveWhole - 1) {
            //karel moves around first box
            for (int moveAround = 3; moveAround > 0; moveAround = moveAround - 1) {
                
                //karel moves around one side 3 times
                for (int moveCount = 3; moveCount > 0; moveCount = moveCount - 1) {
                    karel.move();
                }
                //karel turns left if he isnt beside a wall
                if (!karel.isBesideThing(IPredicate.aWall)) {
                    karel.turnLeft();
                }
            }
            //karel moves foreward 6 times
            for (int moveCount = 6; moveCount > 0; moveCount = moveCount - 1) {
                karel.move();
            }
            //karel moves around second box
            for (int moveAround = 3; moveAround > 0; moveAround = moveAround - 1) {
                //karel turns left if he isnt beside a wall
                if (!karel.isBesideThing(IPredicate.aWall)) {
                    karel.turnLeft();
                }
                //karel move 3 times around side
                for (int moveCount = 3; moveCount > 0; moveCount = moveCount - 1) {
                    karel.move();
                }
            }
        }
    }
}
