package com.company;

public class Monster {

    private int health;
    private int damage;
    private String name;

    public Monster(int health, int damage, String name) {
        this.health = health;
        this.damage = damage;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void damageTaken(int health) {
        this.health -= health;
    }

    public int getDamage() {
        return damage;
    }

}
