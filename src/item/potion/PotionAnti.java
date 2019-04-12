package item.potion;


import controller.Player;

public class PotionAnti extends Potion {
    private boolean gasPotion = true;

    public PotionAnti(String name) {
        super(name);
    }

    public boolean isGasPotion() {
        return gasPotion;
    }

    @Override
    public void useItem(Player player){
        //This method is empty. The usage is implemented in Inventory class.
    }
}
