package creature;

import controller.Player;
import inventory.Inventory;
import item.shield.Shield;
import item.weapon.Weapon;

import java.security.SecureRandom;

import static controller.Sound.playSound;

public abstract class Hero extends Creature {

    private int posY;
    private int posX;

    SecureRandom screamRand = new SecureRandom();
    private int baseAttackDmg;
    private int baseArmorClass;
    private int level;
    private int heroXP;
    private Inventory inventory; //ny
    private Weapon currentWeapon;
    private Shield currentShield;

    public Hero(String name, int healthPoint, int armorClass, int baseArmorClass, int attackDmg, int baseAttackDmg, int hitChance, int initiative, int level, int heroXP, int posY, int posX, Weapon currentWeapon, Shield currentShield) {
        super(name, healthPoint, armorClass, attackDmg, hitChance, initiative);
        this.posY = 0;
        this.posX = 0;
        this.level = level;
        this.heroXP = heroXP;
        this.baseAttackDmg = baseAttackDmg;
        this.baseArmorClass = baseArmorClass;
        this.inventory = new Inventory();
        this.currentWeapon = currentWeapon;
        this.currentShield = currentShield;
        
    }

    public int getBaseAttackDmg() {
        return baseAttackDmg;
    }

    public void setBaseAttackDmg(int baseAttackDmg) {
        this.baseAttackDmg = baseAttackDmg;
    }

    public int getBaseArmorClass() {
        return baseArmorClass;
    }

    public void setBaseArmorClass(int baseArmorClass) {
        this.baseArmorClass = baseArmorClass;
    }

    public Weapon getCurrentWeapon() {
        return currentWeapon;
    }

    public void setCurrentWeapon(Weapon currentWeapon) {
        this.currentWeapon = currentWeapon;
    }

    public Shield getCurrentShield() {
        return currentShield;
    }

    public void setCurrentShield(Shield currentShield) {
        this.currentShield = currentShield;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHeroXP() {
        return heroXP;
    }

    public void setHeroXP(int heroXP) {
        this.heroXP = heroXP;
    }

    public Inventory getInventory() {
        return inventory;
    }  //Inventory for hero.

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getPosX() {
        return posX;
    }
    
    

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void getScream() {
        int scream = 1 + screamRand.nextInt(6);
        switch (scream) {
            case 1:
                playSound("sounds/pain1.wav");
                break;
            case 2:
                playSound("sounds/pain3.wav");
                break;
            case 3:
                playSound("sounds/pain4.wav");
                break;
            case 4:
                playSound("sounds/pain5.wav");
                break;
            case 5:
                playSound("sounds/pain6.wav");
                break;
            case 6:
                playSound("sounds/pain7.wav");
                break;
        }
    }

    public void getAttackGrunt() {
        int scream = 1 + screamRand.nextInt(3);
        switch (scream) {
            case 1:
                playSound("sounds/attack_1.wav");
                break;
            case 2:
                playSound("sounds/attack_2.wav");
                break;
            case 3:
                playSound("sounds/attack_3.wav");
                break;
        }
    }

    public void getMiss(Player player, Monster monster) {
        int scream = 1 + screamRand.nextInt(4);
        switch (scream) {
            case 1:
                playSound("sounds/miss1.wav");
                System.out.println(monster.getName() + " dodge the " + player.getHero().getName() + "'s incoming attack. It´s a miss!");
                break;
            case 2:
                playSound("sounds/miss2.wav");
                System.out.println("The attack miss!");
                break;
            case 3:
                playSound("sounds/miss3.wav");
                System.out.println(monster.getName() + " moves away from the incoming attack. It´s a miss!");
                break;
            case 4:
                playSound("sounds/miss4.wav");
                System.out.println("Swings hard but miss the " + monster.getName() + " and hits the ground!");
                break;

        }
    }

    public void getHitSound() {
        int scream = 1 + screamRand.nextInt(7);
        switch (scream) {
            case 1:
                playSound("sounds/hit1.wav");
                break;
            case 2:
                playSound("sounds/hit2.wav");
                break;
            case 3:
                playSound("sounds/hit3.wav");
                break;
            case 4:
                playSound("sounds/hit4.wav");
                break;
            case 5:
                playSound("sounds/stabhit1.wav");
                break;
            case 6:
                playSound("sounds/stabhit2.wav");
                break;
            case 7:
                playSound("sounds/stabhit3.wav");
                break;
        }
    }
}
