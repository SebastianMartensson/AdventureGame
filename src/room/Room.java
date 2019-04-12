package room;

import creature.Monster;
import item.Item;

import java.io.Serializable;

public abstract class Room implements Serializable {
    private String name;
    private String description;
    private Monster monster;
    private Item item;
    private Door door;
    private Door bossDoor;
    private boolean hasItem;
    private boolean hasMonster;
    private boolean visited;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.hasMonster = false;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public boolean isHasItem() {
        return hasItem;
    }

    public void setHasItem(boolean hasItem) {
        this.hasItem = hasItem;
    }

    public boolean isHasMonster() {
        return hasMonster;
    }

    public void setHasMonster(boolean hasMonster) {
        this.hasMonster = hasMonster;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Door getDoor() {
        return door;
    }

    public void setDoor(Door door) {
        this.door = door;
    }

    public Door getBossDoor() {
        return bossDoor;
    }

    public void setBossDoor(Door bossDoor) {
        this.bossDoor = bossDoor;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
