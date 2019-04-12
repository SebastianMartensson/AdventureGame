package controller.monster_logic;

import java.io.Serializable;

public class Direction implements Serializable {
    public int x;
    public int y;

    public Direction(int y, int x) {
        this.x = x;
        this.y = y;
    }
}
