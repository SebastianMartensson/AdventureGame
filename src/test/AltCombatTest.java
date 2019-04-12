/*

package test;

import controller.Dice;
import controller.Player;
import controller.input_handling.HandleInput;
import controller.world.World;
import creature.*;
import item.weapon.club.Club;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.security.SecureRandom;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AltCombatTest {
        private int turn;
        private Scanner scanner = new Scanner(System.in);
        private SecureRandom random = new SecureRandom();
        private SoundTest getSound = new SoundTest();

        public static void main(String[] args) {
            AltCombatTest game = new AltCombatTest();
            game.combatTest();
        }

        private void combatTest(){
            Player player = new Player("TestPlayer", new Warrior("TestHero", 35, 12, 3, -1, -2, 1, 0, 0, 0, 0, new Club("TestName", 5, 5, 5, false)));
            World world = new World(player);
            Monster monster = world.getMonsters()[4][4];
            startCombat(player, monster);
        }

        private void startCombat(Player player, Monster monster) {
            initiator(player, monster);
            while ((player.getHero().getCurrHealthPoint() != 0 || player.getHero().getCurrHealthPoint() > 0) || (monster.getCurrHealthPoint() != 0 || monster.getCurrHealthPoint() > 0)) {
                switch (turn) {
                    //Hero attacks
                    case 0:
                        monster.setCurrHealthPoint(monster.getCurrHealthPoint() - attack(player, monster, HandleInput.checkInput(scanner.nextLine(), true)));
                        turn++;
                        break;
                    //Monster attacks    
                    case 1:
                        player.getHero().setCurrHealthPoint(player.getHero().getCurrHealthPoint() - attack(player, monster, "null"));
                        turn--;
                        break;

                    default:
                        //TODO Error handling
                        break;
                }
            }
            if (player.getHero().getCurrHealthPoint() > 0) {
                //Hero is dead
            } else if (monster.getCurrHealthPoint() > 0) {
                //Monster is dead
            }
        }

        private void initiator(Player player, Monster monster) {
            int heroInit = player.getHero().getInitiative() + Dice.getD20();
            int monsterInit = monster.getInitiative() + Dice.getD20();
            do {
                if (heroInit > monsterInit) {
                    turn = 0;
                } else if (heroInit < monsterInit) {
                    turn = 1;
                } else {
                    heroInit = player.getHero().getInitiative() + Dice.getD20();
                    monsterInit = monster.getInitiative() + Dice.getD20();
                }
            } while (heroInit == monsterInit);
        }

        private int attack(Player player, Monster monster, String attackType) {
            int hitChance, roll;
            //Set to 1 to remove possible division by 0
            int totalDamage = 1;
            switch (turn) {
                case 0:
                    roll = Dice.getD20();
                    hitChance = roll + player.getHero().getHitChance();
                    getSound.getResponse(player.getHero(), "attack");
                    switch (attackType) {
                        case "1":
                            if (hitChance >= monster.getArmorClass()) {
                                totalDamage = player.getHero().getAttackDmg();
                                getSound.getResponse(player.getHero(), "hit");
                            } else if (roll == 20) {
                                totalDamage = player.getHero().getAttackDmg() * 2;
                                getSound.getResponse(player.getHero(), "crit");
                            } else {
                                totalDamage = 0;
                                getSound.getResponse(player.getHero(), "miss");
                            }
                            break;
                        case "2":
                            hitChance += 5;
                            if (hitChance >= monster.getArmorClass()) {
                                totalDamage = player.getHero().getAttackDmg() / 2;
                                getSound.getResponse(player.getHero(), "hit");
                            } else if (roll == 20) {
                                totalDamage = (player.getHero().getAttackDmg() / 2) * 2;
                                getSound.getResponse(player.getHero(), "crit");
                            } else {
                                totalDamage = 0;
                                getSound.getResponse(player.getHero(), "miss");
                            }
                            break;
                        case "3":
                            if (hitChance >= 6) {
                                hitChance -= 6;
                            } else {
                                hitChance = 0;
                            }
                            if (hitChance >= monster.getArmorClass()) {
                                totalDamage = (player.getHero().getAttackDmg() * 3) / 2;
                                getSound.getResponse(player.getHero(), "hit");
                            } else if (roll == 20) {
                                totalDamage = ((player.getHero().getAttackDmg() * 3) / 2) * 2;
                                getSound.getResponse(player.getHero(), "crit");
                            } else {
                                totalDamage = 0;
                                getSound.getResponse(player.getHero(), "miss");
                            }
                            break;
                        default:
                            //If we enter default the input is likely to be null since its hardcoded
                            //when the monster is attacking. Check turn.
                            //TODO Error handling
                            break;
                    }
                case 1:
                    roll = Dice.getD20();
                    hitChance = roll + monster.getHitChance();
                    String randomAttack = String.valueOf(random.nextInt(3));
                    getSound.getResponse(monster, "attack");
                    switch (randomAttack) {
                        case "0":
                            if (hitChance + monster.getHitChance() >= player.getHero().getArmorClass()) {
                                totalDamage = monster.getAttackDmg();
                                getSound.getResponse(monster, "hit");
                            } else if (hitChance == 20) {
                                totalDamage = monster.getAttackDmg() * 2;
                                getSound.getResponse(monster, "crit");
                            } else {
                                totalDamage = 0;
                                getSound.getResponse(monster, "miss");
                            }
                            break;
                        case "1":
                            hitChance += 5;
                            if (hitChance >= player.getHero().getArmorClass()) {
                                totalDamage = monster.getAttackDmg() / 2;
                                getSound.getResponse(monster, "hit");
                            } else if (roll == 20) {
                                totalDamage = (monster.getAttackDmg() / 2) * 2;
                                getSound.getResponse(monster, "crit");
                            } else {
                                totalDamage = 0;
                                getSound.getResponse(monster, "miss");
                            }
                            break;
                        case "2":
                            if (hitChance >= 6) {
                                hitChance -= 6;
                            } else {
                                hitChance = 0;
                            }
                            if (hitChance >= player.getHero().getArmorClass()) {
                                totalDamage = (monster.getAttackDmg() * 3) / 2;
                                getSound.getResponse(monster, "hit");
                            } else if (roll == 20) {
                                totalDamage = ((monster.getAttackDmg() * 3) / 2) * 2;
                                getSound.getResponse(monster, "crit");
                            } else {
                                totalDamage = 0;
                                getSound.getResponse(monster, "miss");
                            }
                            break;
                        default:
                            //TODO Error handling
                            break;
                    }
                    break;

                default:
                    //TODO Error handling
                    System.err.print("The variable turn is out of bounds. \nIt should be 0 or 1 but it is: " + turn);
                    break;
            }
            return totalDamage;
        }
    }

class SoundTest {
    private SecureRandom soundRandom = new SecureRandom();

    public static void main(String[] args) {
    }

    private static void playSoundTest(String soundFile) {
        File f = null;
        Clip clip = null;
        try {
            f = new File("./" + soundFile);
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(f.toURI().toURL()));
            clip.start();
            Thread.sleep(clip.getMicrosecondLength() / 2000);
            // If you want the sound to loop infinitely, then put: clip.loop(Clip.LOOP_CONTINUOUSLY);
            // If you want to stop the sound, then use clip.stop();
        } catch (Exception ex) {
            Logger.getLogger(SoundTest.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (clip != null) {
                clip.close();
            }
        }
    }
    //Using this approach we separate sound speech from text speech

    // The files needs to be ordered:
    // sounds
    // /type of sound (speak, scream, attack, miss, hit, death)
    // /classname(goblin, ghoul, orc, spider, ogre)
    // /speakX.wav(every file should be named speak1.wav, speak2.wav etc)
    //E.g: sounds/type/creature.getClass().getSimpleName().toLowerCase()/speak4
    void getResponse(Creature creature, String type) {
        playSoundTest("sounds/" + type + "/" + creature.getClass().getSimpleName().toLowerCase() + "/speak" + (1 + soundRandom.nextInt(getNumberOfFiles(type, creature)))  + ".wav");
    }

    //Check the amount of files in the given folder.
    //We don't want the random number to be generated ouside the amount of files in the folder
    private int getNumberOfFiles(String type, Creature creature) {
        File file = new File("sounds/" + type + "/" + creature.getClass().getSimpleName().toLowerCase() + "/");
        File[] listOfFiles = file.listFiles();
        int count = 0;
        assert listOfFiles != null;
        for (File file1 : listOfFiles) {
            count++;
        }
        return count;
    }
}

*/