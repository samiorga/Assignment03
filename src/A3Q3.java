
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
public class A3Q3 {

    public static void main(String[] args) {

        //City for robot to live in
        City kw = new City();

        //New walls in City
        new Wall(kw, 1, 1, Direction.WEST);
        new Wall(kw, 1, 1, Direction.NORTH);
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

        //new robot that lives in City
        Robot karel = new Robot(kw, 2, 2, Direction.WEST);

        //if karel isnt beside a wall he moves
        while (!karel.isBesideThing(IPredicate.aWall)) {
            while (karel.frontIsClear()) {
                karel.move();
            }
            //if front isnt clear then karel turns left
            if (!karel.frontIsClear()) {
                karel.turnLeft();
            }
        }
        //while true karel does this 
        while (true) {
            //karel moves if he is beside wall
            if (karel.isBesideThing(IPredicate.aWall)) {
                //if front is clear karel moves
                if (karel.frontIsClear()) {
                    karel.move();
                    //karel turns left if front isnt clear
                    if (!karel.frontIsClear()) {
                        karel.turnLeft();
                    }
                }
            }
            //karel turns right if he is not beside a wall then stops
            if (!karel.isBesideThing(IPredicate.aWall)) {
                karel.turnLeft();
                karel.turnLeft();
                karel.turnLeft();

                break;
            }
        }
    }
}
