package controller.world;

import item.Item;
import item.potion.Potion;

import java.io.Serializable;
import java.security.SecureRandom;
import java.util.ArrayList;

public class WorldItem implements Serializable {
    // List of items that can be found in the world
    ArrayList<Item> items;
    private Item mediumTreasure;
    private Item largeTreasure;


    //adding items to the Arraylist
    public WorldItem(){
        items = new ArrayList<>();
        items.add(new item.key.KeyBoss("Forgotten Key", true));
        items.add(new item.key.KeyBoss("Unwanted Key", true));
        items.add(new item.potion.HpSmall("Less Health Potion", 5));
        items.add(new item.potion.HpMedium("Health Potion", 15));
        items.add(new item.potion.HpBig("Great Health Potion", 30));
        items.add(new item.treasure.SmallTreasure(50, "Small Treasure"));
        items.add(new item.weapon.axe.BattleAxe("Scourgeborne Waraxe", 0,0,0,true));
        items.add(new item.weapon.axe.GreatAxe("Gladiator's Cleaver",0,0,0, false));
        items.add(new item.weapon.club.Mace("Head crusher", 0,2,0,true));
        items.add(new item.shield.Buckler("Guardian Buckler",0,0,1));
        items.add(new item.shield.KiteShield("Knight's Crest",0,0,2));
        items.add(new item.shield.HeavyShield("Dragon Protector",-1,0, 3));
        items.add(new item.weapon.sword.ShortSword("Warrior's Blade",0,1,0,true ));
        items.add(new item.weapon.sword.LongSword("King Slayer",0,0,0,false ));
        items.add(new item.weapon.sword.GreatSword("Infernal Greatsword", -1, -1, 0, false));

        this.largeTreasure = new item.treasure.LargeTreasure(200, "Large Treasure");
        this.mediumTreasure = new item.treasure.MediumTreasure(100, "Medium Treasure");
    }

    public ArrayList<Item> getItems(Item item) {
        if (item instanceof Potion){

        }
        return items;
    }

    //Return a random item from the ArrayList of items
    public Item getRandomItem(){
        SecureRandom rand = new SecureRandom();
        int getRandomItem = rand.nextInt(items.size());
        return items.get(getRandomItem);
    }
    public Item getMediumTreasure() {
        return mediumTreasure;
    }
    public Item getLargeTreasure() {
        return largeTreasure;
    }
}
