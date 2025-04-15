package Map;

public abstract class Doors {
    private boolean isUnlocked;

    public Doors(boolean isUnlocked) {
        this.isUnlocked = isUnlocked;
    }

    public boolean isUnlocked() {
        return isUnlocked;
    }

    public void setUnlocked(boolean unlocked) {
        isUnlocked = unlocked;
    }
}
