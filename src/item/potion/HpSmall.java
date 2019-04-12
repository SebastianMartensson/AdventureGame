package item.potion;

import controller.Player;

public class HpSmall extends Potion {
    private int hp; // + health to hero

    public HpSmall(String name, int hp) {
        super(name);
        this.hp=hp;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    @Override
    public void useItem(Player player){
        player.getHero().setCurrHealthPoint(player.getHero().getCurrHealthPoint() + hp);
        //Check to see that we don't give the hero more health than he can have.
        if (player.getHero().getCurrHealthPoint() > player.getHero().getFullHealthPoint()){
            player.getHero().setCurrHealthPoint(player.getHero().getFullHealthPoint());
        }
    }
}

