package item.treasure;

import controller.Player;

public class SmallTreasure extends Treasure {

    private int score;

    public SmallTreasure(int score, String name) {
        super(name);
        this.score = score;
    }

    @Override
    public void useItem(Player player) {
        //Increases the player score
        player.setScore(player.getScore() + score);
    }
}
