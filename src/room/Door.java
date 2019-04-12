package room;

import java.io.Serializable;

public class Door implements Serializable {
    private boolean isLocked;

    public Door(boolean isLocked) {
        this.isLocked = isLocked;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }
}
