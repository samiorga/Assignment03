
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

        City kw = new City();

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

        Robot karel = new Robot(kw, 1, 1, Direction.EAST);

        while (karel.canPickThing()) {
            if (karel.canPickThing()) {
                karel.pickThing();
            }
            if (karel.getAvenue() == 12 && karel.canPickThing() && karel.getDirection() == Direction.EAST) {
                break;
            }
            for (int moveAhead = 0; moveAhead < 11; moveAhead = moveAhead + 1) {
                karel.move();
            }
            if (!karel.canPickThing()) {
                karel.putThing();
            }
            if (karel.canPickThing()) {
                karel.turnLeft();
                karel.turnLeft();
            }
            for (int moveAhead = 0; moveAhead < 10; moveAhead = moveAhead + 1) {
                karel.move();
            }
            karel.turnLeft();
            karel.turnLeft();
        }
        if (!karel.canPickThing()) {
            karel.move();
        }
    }
}
