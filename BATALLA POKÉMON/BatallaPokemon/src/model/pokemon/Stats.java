package model.pokemon;

public class Stats {
    private int health;
    private int baseAttack;
    private int baseDefense;

    public int getHealth() {
        return health;
    }

    public int getBaseAttack() {
        return baseAttack;
    }

    public int getBaseDefense() {
        return baseDefense;
    }

    protected void hit(int damage) {
        health -= damage;
    }

    protected void uploadStats(int level) {
        health += level * 5;
        baseAttack += level * 2 + 10;
        baseDefense += level * 2 + 10;
    }

    public Stats(int health, int baseAttack, int baseDefense) {
        this.health = health;
        this.baseAttack = baseAttack;
        this.baseDefense = baseDefense;
    }
}
