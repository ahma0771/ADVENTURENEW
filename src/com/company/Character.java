package com.company;

public class Character {

    private int health;
    private int damage;
    private String weapon;
    private String[] inventory;

    public Character(int health, int damage, int inventorySize, String weapon) {
        this.health = health;
        this.damage = damage;
        this.weapon = weapon;
        this.inventory = new String[inventorySize];

    }

    public void useInventory(int index){
        for (int i = 0; i < inventory.length; i++){
            if (i == index-1){
                String item = inventory[i];
                if (item.equals("axe") || item.equals("sword") || item.equals("bow")){
                    equipWeapon(item);
                    System.out.println("equipped " + item + " damage is now " + this.damage );

                }
                else {
                    eat(item);
                    System.out.println("Ate " + item + " health is now " + this.health );
                }
            }
        }

    }

    public String[] getInventory() {
        return inventory;
    }

    public void setInventory(String[] inventory) {
        this.inventory = inventory;
    }

    public void getInventoryString(){
        for (int i = 0; i < this.inventory.length; i++){
            System.out.print("[" + this.inventory[i] + "]");
        }
        System.out.println();
    }

    public int getHealth() {
        return health;
    }

    public void eat(String food) {
        if (food == "apple"){
            this.health += 15;
        } else if (food == "pie"){
            this.health += 25;
        } else if (food == "cake"){
            this.health += 50;
        }

    }

    public void damageTaken(int health){
        this.health -= health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage() {
        if (this.weapon.equals("bow")){
            this.damage = 5;
        } else if (this.weapon.equals("sword")){
            this.damage = 10;
        } else if (this.weapon.equals("axe")){
            this.damage = 15;
        }

    }

    public String getWeapon() {
        return weapon;
    }

    public void equipWeapon(String weapon) {
        this.weapon = weapon;
        setDamage();
    }
}
