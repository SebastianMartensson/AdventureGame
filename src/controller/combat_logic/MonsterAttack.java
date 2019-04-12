package controller.combat_logic;

import controller.Dice;
import creature.Hero;
import creature.Monster;

import java.security.SecureRandom;

public class MonsterAttack {

    // Monster attack
    public static void monsterCombat(Hero hero, Monster monster) {
        SecureRandom randMonsterAttack = new SecureRandom();
        int enemyAttackRoll;
        int criticalRoll;
        int monsterDmg = 0;
        int monsterAttack = 1 + randMonsterAttack.nextInt(3);

        enemyAttackRoll = Dice.getD20() + monster.getHitChance();
        criticalRoll = enemyAttackRoll - monster.getHitChance();

        switch (monsterAttack) {
            // Normal attack
            case 1:
                System.out.println(monster.getName() + " attacks the " + hero.getName() + "!");
                monsterDmg = monster.getAttackDmg();                     // Damage 1.0 = normal
                break;
            // fast attack
            case 2:
                System.out.println(monster.getName() + " attacks the " + hero.getName() + " with a fast attack!");
                enemyAttackRoll = enemyAttackRoll + 5;
                monsterDmg = monster.getAttackDmg() / 2;                 // Damage 0.5
                break;
            // power strike attack
            case 3:
                System.out.println(monster.getName() + " attacks the " + hero.getName() + " with a hard power strike.");
                enemyAttackRoll = enemyAttackRoll - 6;
                monsterDmg = (monster.getAttackDmg() * 3) / 2;           // Damage 1.5
                break;
        }
        if (enemyAttackRoll >= hero.getArmorClass() || criticalRoll == 20) {
            if (criticalRoll == 20) {        // Critical Hit if dice is 20
                monsterDmg = monsterDmg * 2;
                monster.getAttackGrunt();
                monster.getHitSound();
                System.out.println("Landed a critical hit! (x2 Damage)");
                hero.getScream();
            } else {
                monster.getAttackGrunt();
                monster.getHitSound();
                System.out.println("Hit!");
                hero.getScream();
            }
            System.out.println(hero.getName() + " takes " + monsterDmg + " damage from the " + monster.getName() + "s attack!");
            hero.setCurrHealthPoint(hero.getCurrHealthPoint() - monsterDmg);
        } else {
            monster.getAttackGrunt();
            monster.getMiss(hero, monster);  // monster miss sound
        }
    }
}
