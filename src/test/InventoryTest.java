package test;

import controller.Player;
import creature.Hero;
import inventory.Inventory;
import item.Item;
import item.weapon.club.Club;

public class InventoryTest {
    private Player player;
    private Hero hero;

    Item [] inventory = new Item[10];

    public static void main(String[] args) {
    InventoryTest myApp = new InventoryTest();

    //myApp.addItems();
    //myApp.printInventory();

        Item item = new Club("Club of death",2,3,4,false);
        Inventory inventory = new Inventory();
    
    }
    private void addItems(){
        Item item = new Club("Club of death",2,3,4,false);
        inventory[0] = item;

    }
    private void printInventory (){

        for (int i = 0; i < inventory.length; i++) {

            if (inventory [i] == null){
                System.out.println((i + 1) +" "+ "Empty slot");
            }else{
                System.out.println( (i + 1) + " " + inventory [i].getName());
            }


            }
            /*
            Lägg till inparameter till addItem metoden typ (Item item) så kan vi skicka in vilket item vi vill lägga till.
             I remove kan inparametern vara int index så ber vi
            användaren skriva in en siffra beroende på vilket item i listan han vill ta bort
             */

            /*
            1. gör en ny array sätt in massa object, läs ut det, försök ta object från den array
            och sätt in i vår nya array inventory. testa och se!
             */
    }

}
