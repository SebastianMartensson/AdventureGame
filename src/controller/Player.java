package controller;

import creature.Hero;

import java.io.Serializable;

public class Player implements Serializable {
    private String name;
    private int score;
    private Hero hero;

    public Player(String name, Hero hero) {
        this.name = name;
        this.hero = hero;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public void setScore(int score) {
        this.score = score;
    }

}
