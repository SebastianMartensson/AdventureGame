package controller.monster_logic;

import controller.Player;
import controller.Program;
import controller.State;
import controller.world.World;

import creature.*;

import java.io.Serializable;

public class MonsterLogic implements Serializable {

    public void monsterMovement(Player player, World world, Program program) {
        boolean startCombat = false;
        Monster[][] allMonsters = world.getMonsters();

        for (int y = 0; y < world.getWorld().length; y++) {
            if (startCombat) {
                break;
            }
            for (int x = 0; x < world.getWorld().length; x++) {
                if (startCombat) {
                    break;
                }
                Monster currentMonster = allMonsters[y][x];
                if (currentMonster instanceof Spider/* || currentMonster instanceof Goblin*/) {
                    //Check the distance between monster and player
                    int dy = currentMonster.getPosY() - player.getHero().getPosY();
                    int dx = currentMonster.getPosX() - player.getHero().getPosX();
                    //Get the next position
                    Direction nextPosition = getMovementDelta(x, y, dx, dy);

                    //Check if the next position has a monster
                    if (hasBoss(allMonsters, x + nextPosition.x, y + nextPosition.y)) {
                        if (hasMonster(allMonsters, x + (nextPosition.x * 2), y + (nextPosition.y * 2))) {
                            swap(allMonsters, x, y, x + (nextPosition.x * 2), y + (nextPosition.y * 2));
                        } else {
                            setPosition(allMonsters, currentMonster, y, x, nextPosition);
                        }
                    } else if (hasMonster(allMonsters, x + nextPosition.x, y + nextPosition.y)) {
                        if (hasHero(player, allMonsters, x, y)) {
                            startCombat = true;
                        } else {
                            swap(allMonsters, x, y, x + nextPosition.x, y + nextPosition.y);
                        }
                    } else {
                        if (Math.abs(nextPosition.y) > 0 || Math.abs(nextPosition.x) > 0) {
                            if (hasHero(player, allMonsters, x, y)) {
                                startCombat = true;
                            } else {
                                setPosition(allMonsters, currentMonster, y, x, nextPosition);
                            }
                        }
                    }
                    if (player.getHero().getPosY() == currentMonster.getPosY() && player.getHero().getPosX() == currentMonster.getPosX()) {
                        program.setCurrentState(State.Fighting);
                        startCombat = true;
                    }
                }
            }
        }
        world.setMonsters(allMonsters);
    }

    private void setPosition(Monster[][] allMonsters, Monster monster, int y, int x, Direction direction) {
        monster.setPosY(y + direction.y);
        monster.setPosX(x + direction.x);
        allMonsters[y + direction.y][x + direction.x] = monster;
        allMonsters[y][x] = null;
    }

    private Direction getMovementDelta(int x, int y, int dx, int dy) {
        int x2 = 0;
        int y2 = 0;

        //Check if monster is furthest away on the x or the y axel
        if (Math.abs(dx) >= Math.abs(dy)) {
            // Move on x axel
            if (dx < 0) {
                // Move right
                x2 = 1;
                y2 = 0;
            } else {
                // Move left
                x2 = -1;
                y2 = 0;
            }
        } else {
            // Move on y axel
            if (dy < 0) {
                // Move down
                x2 = 0;
                y2 = 1;
            } else {
                // Move up
                x2 = 0;
                y2 = -1;
            }
        }
        return new Direction(y2, x2);
    }

    //Swap the monster in the next position with the monster in the current position
    private void swap(Monster[][] monsters, int x0, int y0, int x1, int y1) {
        //Set monsters posY and posX
        monsters[y0][x0].setPosY(y1);
        monsters[y0][x0].setPosX(x1);
        monsters[y1][x1].setPosY(y0);
        monsters[y1][x1].setPosX(x0);

        //Swap place
        Monster temp = monsters[y0][x0];
        monsters[y0][x0] = monsters[y1][x1];
        monsters[y1][x1] = temp;
    }

    //Check if the next room has a Boss
    private boolean hasBoss(Monster[][] monsters, int x, int y) {
        boolean checkMonster = false;
        if (!(y < 0 || y > 8) && !(x < 0 || x > 8)) {
            if (monsters[y][x] instanceof Ogre) {
                checkMonster = true;
            }
        }
        return checkMonster;
    }

    //Check if the room has a monster
    private boolean hasMonster(Monster[][] monsters, int x, int y) {
        boolean checkMonster = false;
        if (!(y < 0 || y > 8) && !(x < 0 || x > 8)) {
            if (monsters[y][x] != null) {
                checkMonster = true;
            }
        }
        return checkMonster;
    }

    private boolean hasHero(Player player, Monster[][] monsters, int x, int y) {
        boolean startCombat = false;
        if ((player.getHero().getPosY() == monsters[y][x].getPosY()) && player.getHero().getPosX() == monsters[y][x].getPosX()) {
            startCombat = true;
        }
        return startCombat;
    }
}
