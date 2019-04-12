package controller.combat_logic;

import controller.Dice;
import controller.Player;
import creature.Hero;
import creature.Monster;

public class HeroStrike {
    // Normal Strike
    public static void playerStrike(Player player, Monster monster, String choice) {
        int heroAttackRoll;
        int criticalRoll;
        int heroDmg = 0;
        heroAttackRoll = Dice.getD20() + player.getHero().getHitChance();
        criticalRoll = heroAttackRoll - player.getHero().getHitChance();

        switch (choice) {
            // Normal strike
            case "1":
                System.out.println(player.getHero().getName() + " attacks the " + monster.getName() + "!");
                heroDmg = player.getHero().getAttackDmg();
                break;
            // Fast Strike
            case "2":
                System.out.println(player.getHero().getName() + " attacks the " + monster.getName() + " with a fast attack!");
                heroAttackRoll = heroAttackRoll + 5;
                heroDmg = player.getHero().getAttackDmg() / 2;
                break;
            // Power Strike
            case "3":
                System.out.println(player.getHero().getName() + " attacks the " + monster.getName() + " with a hard power strike.");
                heroAttackRoll = heroAttackRoll - 6;
                heroDmg = (player.getHero().getAttackDmg() * 3) / 2;
                break;
        }
        if (heroAttackRoll >= monster.getArmorClass() || criticalRoll == 20) {
            if (criticalRoll == 20) {       // Critical hit
                heroDmg = heroDmg * 2;
                player.getHero().getAttackGrunt();
                player.getHero().getHitSound();
                System.out.println("Landed a critical hit! (x2 Damage)");
                monster.getScream();
            } else {
                player.getHero().getAttackGrunt();
                player.getHero().getHitSound();
                System.out.println("Hit!");
                monster.getScream();
            }
            System.out.println(monster.getName() + " takes " + heroDmg + " damage from the " + player.getHero().getName() + "s attack!");
            monster.setCurrHealthPoint(monster.getCurrHealthPoint() - heroDmg);
        } else {
            player.getHero().getAttackGrunt();
            player.getHero().getMiss(player, monster);
        }
    }
}
