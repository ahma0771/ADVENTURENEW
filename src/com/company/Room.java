package com.company;

public class Room {
    private String name;
    private String item;
    private boolean currentRoom;
    private Room north;
    private Room south;
    private Room east;
    private Room west;
    private Monster monster;
    private String weapon;
    private String food;



    public Room(String name, boolean currentRoom, Monster monster, String items) { // Constructor - En constructor er en cunstructor når den har det samme navn som en klasse
        this.name = name;
        this.currentRoom = currentRoom;
        this.item = items;
        this.monster = monster;

    }

    public Room(String name, boolean currentRoom, String items, String weapon){
        this.name = name;
        this.currentRoom = currentRoom;
        this.item = items;
        this.weapon = weapon;

    }

    public Room(String food, String name, boolean currentRoom, String items) {
        this.name = name;
        this.currentRoom = currentRoom;
        this.item = items;
        this.food = food;
    }

    public boolean hasMonster(){
        if (monster == null){
            return false;
        }
        return true;
    }


    public String getWeapon() {
        return weapon;
    }

    public String getFood(){
        return food;
    }

    public String hasFood(){
        if (food != null){
            return this.food;
        }
        return "no food";
    }

    public String hasWeapon(){
        if (weapon != null){
            return this.weapon;
        }
        return "no weapon";
    }



    public Room(String name, boolean currentRoom, String items) { // Constructor - En constructor er en cunstructor når den har det samme navn som en klasse
        this.name = name;
        this.currentRoom = currentRoom;
        this.item = items;

    }

    public Monster getMonster() {
        return monster;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public void setCurrentRoom(boolean currentRoom) {
        this.currentRoom = currentRoom;
    }

    public void setDirections(Room north, Room south, Room east, Room west) {
        this.north = north;
        this.south = south;
        this.east = east;
        this.west = west;
    }

    public void setNorth(Room north) {
        this.north = north;
    }

    public void setSouth(Room south) {
        this.south = south;
    }

    public void setEast(Room east) {
        this.east = east;
    }

    public void setWest(Room west) {
        this.west = west;
    }

    public String getName() {
        return name;
    }

    public String getItem() {
        return item;
    }

    public boolean isCurrentRoom() {
        return currentRoom;
    }

    public Room getNorth() {
        return north;
    }

    public Room getSouth() {
        return south;
    }

    public Room getEast() {
        return east;
    }

    public Room getWest() {
        return west;
    }

    public void look() {
        System.out.println("You are currently in " + name);

        System.out.println(this.item);
    }
}
