enum DangerLevel {
    HIGH(3),
    MEDIUM(2),
    LOW(1);

    private final int level;

    DangerLevel(int lvl) {
        this.level = lvl;
    }

    public int getLevel() {
        return level;
    }
}