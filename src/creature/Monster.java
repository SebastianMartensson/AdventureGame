package creature;

public abstract class Monster extends Creature {

    private int xP;                 // Experience points for killing the Creature.Monster  creature
    private String monsterDesc;     // Monsters description
    private int posY;
    private int posX;
    
    public Monster(String name, int healthPoint, int armorClass, int attackDmg, int hitChance, int initiative, int xP, String monsterDesc) {
        super(name, healthPoint, armorClass, attackDmg, hitChance, initiative);
        this.xP = xP;
        this.monsterDesc = monsterDesc;
    }

    public int getXP() {
        return xP;
    }

    public String getMonsterDesc() {
        return monsterDesc;
    }

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

    public abstract void getSpeakStart();

    public abstract void getScream();

    public abstract void getAttackGrunt();

    public abstract void getDeathScream();

    public abstract void getMiss(Hero hero, Monster monster);

    public abstract void getHitSound();
}