
import becker.robots.City;
import becker.robots.Direction;
import becker.robots.Robot;
import becker.robots.Thing;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Sami
 */
public class A3Q5 {

    public static void main(String[] args) {
        
        //City for tobot to live in
        City kw = new City();

        //Things for robot to pick up
        new Thing(kw, 1, 1);
        new Thing(kw, 1, 2);
        new Thing(kw, 1, 3);
        new Thing(kw, 1, 4);
        new Thing(kw, 1, 5);
        new Thing(kw, 1, 6);
        new Thing(kw, 1, 7);
        new Thing(kw, 1, 8);
        new Thing(kw, 1, 9);
        new Thing(kw, 1, 10);

        //new robot to live in City
        Robot karel = new Robot(kw, 1, 1, Direction.EAST);
        
        //karel picks ups things if he can
        while (karel.canPickThing()) {
            
                karel.pickThing();
            
            //if karel is on avenue 12 and can pick up thing and is facing east then he stops
            if (karel.getAvenue() == 12 && karel.canPickThing() && karel.getDirection() == Direction.EAST) {
                break;
            }
            //karel moves 11 times
            for (int moveAhead = 0; moveAhead < 11; moveAhead = moveAhead + 1) {
                karel.move();
            }
            //karel picks up thing if he can
            if (!karel.canPickThing()) {
                karel.putThing();
            }
            //karel turns around if he can pick up thing
            if (karel.canPickThing()) {
                karel.turnLeft();
                karel.turnLeft();
            }
            //karel moves back 10 times then turn around
            for (int moveAhead = 0; moveAhead < 10; moveAhead = moveAhead + 1) {
                karel.move();
            }
            karel.turnLeft();
            karel.turnLeft();
        }
        //karel moves once if he cant pick up thing
        if (!karel.canPickThing()) {
            karel.move();
        }
    }
}
