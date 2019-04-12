package item.treasure;

import controller.Player;

public class MediumTreasure extends Treasure {

    private int score;

    public MediumTreasure(int score, String name) {
        super(name);
        this.score = score;
    }

    @Override
    public void useItem(Player player) {
        //Increases the player score
        player.setScore(player.getScore() + score);
    }
}
